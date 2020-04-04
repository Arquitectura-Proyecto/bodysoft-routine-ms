package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="resource",schema = "public")
public class Resource implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * Attributes
     */

    private Integer id;

    private Routine routine;

    private String link;

    private String title;

    private String description;

    private Integer position;

    private TypeResource type;

    public Resource(Routine routine, String link, String title, String description, Integer position, TypeResource type) {

        this.routine = routine;
        this.link = link;
        this.title = title;
        this.description = description;
        this.position = position;
        this.type = type;
    }

    public Resource() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public TypeResource getType() {
        return type;
    }

    public void setType(TypeResource type) {
        this.type = type;
    }
}
