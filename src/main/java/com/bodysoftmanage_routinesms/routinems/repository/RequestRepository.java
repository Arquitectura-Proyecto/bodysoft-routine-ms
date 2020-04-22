package com.bodysoftmanage_routinesms.routinems.repository;

import com.bodysoftmanage_routinesms.routinems.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Integer> {
    public List<Request> findAllByRoutineId(Integer idRoutine);
}
