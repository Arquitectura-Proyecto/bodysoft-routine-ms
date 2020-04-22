package com.bodysoftmanage_routinesms.routinems.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="routine",schema="public")
public class Routine implements Serializable {

    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    @Id
    @SequenceGenerator( name = "ROUTINE_ROUTINEID_GENERATOR",
        sequenceName = "public.routine_routine_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ROUTINE_ROUTINEID_GENERATOR" )
    @Column(name = "id")
    private Integer id;
    @Column(name="id_owner")
    private Integer idOwner;
    @Column(name="rating")
    private Float rating;
    @Column(name="num_raitings")
    private Integer numRaitings;
    @Column(name="price")
    private Float price;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="link_preview")
    private String linkPreview;
    @JsonIgnore
    @OneToMany(mappedBy = "routine")
    private List<Resource>resources;
    @JsonIgnore
    @OneToMany(mappedBy = "routine")
    private List<Request>requests;
    @JsonIgnore
    @OneToMany(mappedBy = "routine")
    private List<UserRoutine>userRoutines;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeRoutine type;

    public Routine(Integer idOwner, Float rating, Integer numRaitings, Float price, String name, String description, String linkPreview, List<Resource> resources, List<Request> requests, List<UserRoutine> userRoutines, TypeRoutine type) {
        this.idOwner = idOwner;
        this.rating = rating;
        this.numRaitings = numRaitings;
        this.price = price;
        this.name = name;
        this.description = description;
        this.linkPreview = linkPreview;
        this.resources = resources;
        this.requests = requests;
        this.userRoutines = userRoutines;
        this.type = type;
    }

    public Routine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getNumRaitings() {
        return numRaitings;
    }

    public void setNumRaitings(Integer numRaitings) {
        this.numRaitings = numRaitings;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkPreview() {
        return linkPreview;
    }

    public void setLinkPreview(String linkPreview) {
        this.linkPreview = linkPreview;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<UserRoutine> getUserRoutines() {
        return userRoutines;
    }

    public void setUserRoutines(List<UserRoutine> userRoutines) {
        this.userRoutines = userRoutines;
    }

    public TypeRoutine getType() {
        return type;
    }

    public void setType(TypeRoutine type) {
        this.type = type;
    }


}
