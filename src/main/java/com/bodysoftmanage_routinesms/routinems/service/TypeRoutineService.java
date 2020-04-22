package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.TypeRoutine;
import com.bodysoftmanage_routinesms.routinems.repository.TypeRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRoutineService {
    private TypeRoutineRepository typeRoutineRepository;

    public TypeRoutineService(TypeRoutineRepository typeRoutineRepository) {
        this.typeRoutineRepository = typeRoutineRepository;
    }
    public void save(TypeRoutine type){
        this.typeRoutineRepository.save(type);
    }
    public TypeRoutine findById(Integer id ){
        return this.typeRoutineRepository.findById(id).orElse(null);
    }
    public List<TypeRoutine> getAll(){
        return this.typeRoutineRepository.findAll();
    }
}

