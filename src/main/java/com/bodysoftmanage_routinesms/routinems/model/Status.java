package com.bodysoftmanage_routinesms.routinems.model;

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="status",schema = "public")
public class Status implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    private Integer id;

    private String name;

    private List<UserRoutine> userRoutines;

    public Status(Integer id, String name, List<UserRoutine> userRoutines) {
        this.id = id;
        this.name = name;
        this.userRoutines = userRoutines;
    }

    public Status() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRoutine> getUserRoutines() {
        return userRoutines;
    }

    public void setUserRoutines(List<UserRoutine> userRoutines) {
        this.userRoutines = userRoutines;
    }
}
