package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="type",schema = "public")
public class TypeResource implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    private Integer id;

    private String name;

    private List<Routine> routines;

    public TypeResource(Integer id, String name, List<Routine> routines) {
        this.id = id;
        this.name = name;
        this.routines = routines;
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

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }
}
