package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resource",schema = "public")
public class Resource implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * Attributes
     */
    @Id
    @SequenceGenerator( name = "RESOURCE_RESOURCEID_GENERATOR",
            sequenceName = "public.resource_resource_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "RESOURCE_RESOURCEID_GENERATOR" )
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="id_routine")
    private Routine routine;
    @Column(name="link")
    private String link;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="position")
    private Integer position;
    @ManyToOne
    @JoinColumn(name="id_type")
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
