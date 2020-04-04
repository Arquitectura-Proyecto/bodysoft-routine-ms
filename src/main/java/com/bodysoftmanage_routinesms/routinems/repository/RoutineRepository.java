package com.bodysoftmanage_routinesms.routinems.repository;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Integer> {

}
