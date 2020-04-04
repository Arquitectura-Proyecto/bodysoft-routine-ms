package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="request",schema = "public")
public class Request implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * Attributes
     */
    private Integer id;

    private Routine routine;

    private Integer idUser;

    public Request(Routine routine, Integer idUser) {
        this.routine = routine;
        this.idUser = idUser;
    }

    public Request() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
