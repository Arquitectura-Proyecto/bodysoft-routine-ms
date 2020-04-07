
-- -----------------------------------------------------
-- Table `mydb`.`type`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`type` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`routine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`routine` (
  `id` INT NOT NULL,
  `id_owner` INT NOT NULL,
  `id_type` INT NOT NULL,
  `rating` FLOAT NOT NULL,
  `num_raitings` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `link_preview` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_routine_type_idx` (`id_type` ASC),
  CONSTRAINT `fk_routine_type`
    FOREIGN KEY (`id_type`)
    REFERENCES `mydb`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`request` (
  `id` INT NOT NULL,
  `id_routine` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_request_routine_idx` (`id_routine` ASC) ,
  CONSTRAINT `fk_request_routine`
    FOREIGN KEY (`id_routine`)
    REFERENCES `mydb`.`routine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
ROW_FORMAT = DEFAULT;


-- -----------------------------------------------------
-- Table `mydb`.`type_resource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`type_resource` (
  `id` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`resource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`resource` (
  `id` INT NOT NULL,
  `id_routine` INT NOT NULL,
  `link` VARCHAR(200) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `position` INT NOT NULL,
  `id_type` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_resource_routine_idx` (`id_routine` ASC) ,
  INDEX `fk_resource_typeresource_idx` (`id_type` ASC),
  CONSTRAINT `fk_resource_routine`
    FOREIGN KEY (`id_routine`)
    REFERENCES `mydb`.`routine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_typeresource`
    FOREIGN KEY (`id_type`)
    REFERENCES `mydb`.`type_resource` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`status` (
  `id` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_routine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_routine` (
  `id` INT NOT NULL,
  `id_user` INT NOT NULL,
  `id_routine` INT NOT NULL,
  `id_status` INT NOT NULL,
  `qualified` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_userroutine_routine_idx` (`id_routine` ASC) ,
  INDEX `fk_userroutine_status_idx` (`id_status` ASC) ,
  CONSTRAINT `fk_userroutine_routine`
    FOREIGN KEY (`id_routine`)
    REFERENCES `mydb`.`routine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userroutine_status`
    FOREIGN KEY (`id_status`)
    REFERENCES `mydb`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


