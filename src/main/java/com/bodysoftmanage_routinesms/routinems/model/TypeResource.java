package com.bodysoftmanage_routinesms.routinems.model;

import com.bodysoftmanage_routinesms.routinems.repository.ResourceRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="type",schema = "public")
public class TypeResource implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    @Id
    @SequenceGenerator( name = "TYPERESOURCE_TYPERESOURCEID_GENERATOR",
            sequenceName = "public.typeresource_typeresource_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "TYPERESOURCE_TYPERESOURCEID_GENERATOR" )
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Resource> resources;

    public TypeResource(Integer id, String name, List<Resource> resources) {
        this.id = id;
        this.name = name;
        this.resources = resources;
    }

    public TypeResource() {
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
