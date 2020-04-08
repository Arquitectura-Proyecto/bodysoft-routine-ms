package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.TypeResource;
import com.bodysoftmanage_routinesms.routinems.repository.TypeResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeResourceService {
    private TypeResourceRepository typeResourceRepository;

    public TypeResourceService(TypeResourceRepository typeResourceRepository) {
        this.typeResourceRepository = typeResourceRepository;
    }

    public TypeResource getById(Integer idType){
        return this.typeResourceRepository.findById(idType).orElse(null);
    }
}
