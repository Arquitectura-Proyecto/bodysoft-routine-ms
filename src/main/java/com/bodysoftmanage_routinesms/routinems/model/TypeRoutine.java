package com.bodysoftmanage_routinesms.routinems.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="type",schema = "public")
public class TypeRoutine implements Serializable {
    private static final long serialVersionUID=1L;
/**
 * Attributes
 */
    private Integer id;

    private String nombre;

    private List<Routine> routines;

    public TypeRoutine(Integer id, String nombre, List<Routine> routines) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }
}
