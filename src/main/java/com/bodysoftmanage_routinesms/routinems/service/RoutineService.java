package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.repository.RoutineRepository;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {
    private RoutineRepository routineRepository;

    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }
    public void save(Routine routine)
    {
        this.routineRepository.save(routine);

    }
    public boolean isRigthRoutine(RegisterRoutinePOJO routine){
        boolean correct=routine.getDescription()!=null&&routine.getIdOwner()!=null
                &&routine.getLink_preview()!=null&&routine.getName()!=null&&routine.getPrice()!=null;
        if(correct){
            correct=!routine.getDescription().trim().isEmpty()
                    &&!routine.getLink_preview().trim().isEmpty()
                    &&!routine.getName().trim().isEmpty();
        }
        return  correct;
    }

}
