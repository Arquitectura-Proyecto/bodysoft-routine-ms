package com.bodysoftmanage_routinesms.routinems.model;

import javafx.beans.DefaultProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_routine")
public class UserRoutine implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */

    @Id
    @SequenceGenerator( name = "TYPEROUTINE_TYPEROUTINEID_GENERATOR",
            sequenceName = "public.typeroutine_typeroutine_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "TYPEROUTINE_TYPEROUTINEID_GENERATOR" )
    @Column(name="id")
    private Integer id;
    @Column(name="id_user")
    private Integer idUser;
    @ManyToOne
    @JoinColumn(name="id_routine")
    private Routine routine;
    @ManyToOne
    @JoinColumn(name="id_status")
    private Status status;
    @Column(name="qualified",columnDefinition = "BOOLEAN DEFAULT 0")
    private Boolean quailified;

    public UserRoutine(Integer idUser, Routine routine, Status status, Boolean quailified) {
        this.idUser = idUser;
        this.routine = routine;
        this.status = status;
        this.quailified = quailified;
    }
    public UserRoutine() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getQuailified() {
        return quailified;
    }

    public void setQuailified(Boolean quailified) {
        this.quailified = quailified;
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
