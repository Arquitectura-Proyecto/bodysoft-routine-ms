package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Resource;
import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.model.TypeResource;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterResourcePOJO;
import com.bodysoftmanage_routinesms.routinems.service.ResourceService;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import com.bodysoftmanage_routinesms.routinems.service.TypeResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    private ResourceService resourceService;
    private RoutineService routineService;
    private TypeResourceService typeResourceService;


    public ResourceController(ResourceService resourceService, RoutineService routineService) {
        this.resourceService = resourceService;
        this.routineService = routineService;
    }

    @PostMapping(value={"/routine-ms/resources/register/{idRoutine}"})
    public ResponseEntity register(@PathVariable Integer idRoutine, @RequestBody RegisterResourcePOJO resourcePOJO){
            if(!resourceService.isRigthResource(resourcePOJO)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            Routine routine=routineService.getById(idRoutine);
            TypeResource typeResource=typeResourceService.getById(resourcePOJO.getIdType());
            if(routine==null || typeResource==null){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            if(routine.getIdOwner()!=resourcePOJO.getIdOwner()){
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
            Resource newResource=new Resource();
            newResource.setRoutine(routine);
            newResource.setLink(resourcePOJO.getLink());
            newResource.setTitle(resourcePOJO.getTitle());
            newResource.setDescription(resourcePOJO.getDescription());
            newResource.setPosition(resourcePOJO.getPosition());
            newResource.setType(typeResource);
            resourceService.save(newResource);
            return new ResponseEntity(HttpStatus.CREATED);
    }
}
