package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
                    &&!routine.getName().trim().isEmpty()&&routine.getPrice()>=0;
        }
        return  correct;
    }
    public boolean isOwner(Integer idRoutine,Integer idOwner){
        Routine routine= routineRepository.findById(idRoutine).orElse(null);
        return routine.getIdOwner().compareTo(idOwner)==0;

    }
    public List<Routine> getAllByIdOwner(Integer idOwner){
        return routineRepository.findAllByIdOwner(idOwner);
    }
    public Routine getById(Integer id){
        return this.routineRepository.findById(id).orElse(null);
    }
    public List<Routine>getAll(){
        return this.routineRepository.findAll();
    }
    public List<Routine>getByType(Integer idType){
        return routineRepository.findAllByTypeId(idType);
    }

}
