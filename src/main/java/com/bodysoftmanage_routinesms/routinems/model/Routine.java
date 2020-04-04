package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="routine",schema="public")
public class Routine implements Serializable {

    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    private Integer id;

    private Integer idOwner;

    private Float rating;

    private Integer numRaitings;

    private Float price;

    private String name;

    private String description;

    private String linkPreview;

    private List<Resource>resources;

    private List<Request>requests;

    private List<UserRoutine>userRoutines;

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
