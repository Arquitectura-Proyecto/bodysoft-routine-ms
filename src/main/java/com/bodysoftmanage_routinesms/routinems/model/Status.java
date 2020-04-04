package com.bodysoftmanage_routinesms.routinems.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="status",schema = "public")
public class Status implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    @Id
    @SequenceGenerator( name = "STATUS_STATUSID_GENERATOR",
        sequenceName = "public.status_status_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STATUS_STATUSID_GENERATOR" )
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "status")
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
