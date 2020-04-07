package com.bodysoftmanage_routinesms.routinems.repository;

import com.bodysoftmanage_routinesms.routinems.model.UserRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoutineRepository extends JpaRepository<UserRoutine,Integer> {
    public List<UserRoutine> findAllByIdUserAndStatusId(Integer idUser,Integer idStatus);
    public UserRoutine findFirstByIdUserAndRoutineId(Integer idUser,Integer idRoutine);
}
