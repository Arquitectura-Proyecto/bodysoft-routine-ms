package com.bodysoftmanage_routinesms.routinems.model;

import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="request",schema = "public")
public class Request implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * Attributes
     */
    @Id
    @SequenceGenerator( name = "REQUEST_REQUESTID_GENERATOR",
            sequenceName = "public.request_request_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "REQUEST_REQUESTID_GENERATOR" )
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name="id_routine")
    private Routine routine;

    @Column(name="id_user")
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
