package com.bodysoftmanage_routinesms.routinems.repository;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    public List<Routine> findAllByIdOwner(Integer idOwner);
    public List<Routine> findAllByTypeId(Integer idType);
}
