package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.repository.RoutineRepository;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {
    private RoutineRepository routineRepository;

    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }
    public void save(Routine routine){
        this.routineRepository.save(routine);
    }
}
