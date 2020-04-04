package com.bodysoftmanage_routinesms.routinems.model;

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
    @Column
    private Integer idUser;
    @ManyToOne
    @JoinColumn(name="id_routine")
    private Routine routine;
    @ManyToOne
    @JoinColumn(name="id_status")
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
