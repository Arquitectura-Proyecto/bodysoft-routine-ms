package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Resource;
import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.model.TypeResource;
import com.bodysoftmanage_routinesms.routinems.model.UserRoutine;
import com.bodysoftmanage_routinesms.routinems.pojo.GetRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterResourcePOJO;
import com.bodysoftmanage_routinesms.routinems.service.ResourceService;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import com.bodysoftmanage_routinesms.routinems.service.TypeResourceService;
import com.bodysoftmanage_routinesms.routinems.service.UserRoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class ResourceController {
    private ResourceService resourceService;
    private RoutineService routineService;
    private TypeResourceService typeResourceService;
    private UserRoutineService userRoutineService;

    public ResourceController(ResourceService resourceService, RoutineService routineService, TypeResourceService typeResourceService, UserRoutineService userRoutineService) {
        this.resourceService = resourceService;
        this.routineService = routineService;
        this.typeResourceService = typeResourceService;
        this.userRoutineService = userRoutineService;
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
    @GetMapping(value={"/routine-ms/resources/getByRoutine/{idRoutine}"})
    public ResponseEntity<List<Resource>>getByRoutine(@PathVariable Integer idRoutine, @RequestBody GetRoutinePOJO getRoutine){
        Routine routine=routineService.getById(idRoutine);
        if(routine==null|| !resourceService.isRigthGetByRoutine(getRoutine)){
            return new ResponseEntity( HttpStatus.BAD_REQUEST);

        }

        UserRoutine userRoutine=userRoutineService.getByIdUserAndIdRoutine(getRoutine.getIdRequester(),routine.getId());
        if(userRoutine==null&&routine.getIdOwner()!=getRoutine.getIdRequester()){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(routine.getResources(),HttpStatus.OK);

    }

}
