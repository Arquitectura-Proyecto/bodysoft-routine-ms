package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user_routine")
public class UserRoutine implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    private Integer idUser;
    private Routine routine;
    private Status status;

    public UserRoutine(Integer idUser, Routine routine, Status status) {
        this.idUser = idUser;
        this.routine = routine;
        this.status = status;
    }

    public UserRoutine() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
