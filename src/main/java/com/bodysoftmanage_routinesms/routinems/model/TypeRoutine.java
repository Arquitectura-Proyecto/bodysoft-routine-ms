package com.bodysoftmanage_routinesms.routinems.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="type",schema = "public")
public class TypeRoutine implements Serializable {
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
    @Column(name="name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Routine> routines;

    public TypeRoutine(Integer id, String name, List<Routine> routines) {
        this.id = id;
        this.name = name;
        this.routines = routines;
    }

    public TypeRoutine() {
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

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }
}
