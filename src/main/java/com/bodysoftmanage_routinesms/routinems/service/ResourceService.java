package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.Resource;
import com.bodysoftmanage_routinesms.routinems.pojo.GetRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterResourcePOJO;
import com.bodysoftmanage_routinesms.routinems.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public boolean isRigthResource(RegisterResourcePOJO registerResourcePOJO){
        boolean correct=registerResourcePOJO.getLink()!=null &&registerResourcePOJO.getTitle()!=null
                &&registerResourcePOJO.getDescription()!=null&&registerResourcePOJO!=null
                &&registerResourcePOJO.getIdType()!=null&&registerResourcePOJO.getIdOwner()!=null;
        if(correct){
            correct=registerResourcePOJO.getPosition()>0
                    &&registerResourcePOJO.getIdType()>0
                    &&registerResourcePOJO.getIdOwner()>0;
        }

        return correct;

    }
    public void save(Resource resource){
        resourceRepository.save(resource);
    }
    public boolean isRigthGetByRoutine(GetRoutinePOJO getRoutinePOJO){
        boolean correct=getRoutinePOJO.getIdRequester()!=null;
        if(correct){

            correct=getRoutinePOJO.getIdRequester()>0;
        }
        return correct;
    }
    public Resource getById(Integer id){
        return this.resourceRepository.findById(id).orElse(null);
    }
    public void delete(Resource resource){
        this.resourceRepository.delete(resource);
    }
}
