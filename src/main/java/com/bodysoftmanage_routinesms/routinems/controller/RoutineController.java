package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.model.TypeRoutine;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import com.bodysoftmanage_routinesms.routinems.service.TypeRoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RoutineController {
    private static float DefaultRating= (float) 0.0;
    private  static Integer DefaultNumRaitings=0;
    private RoutineService routineService;
    private TypeRoutineService typeRoutineService;

    public RoutineController(RoutineService routineService, TypeRoutineService typeRoutineService) {
        this.routineService = routineService;
        this.typeRoutineService = typeRoutineService;
    }

    @PostMapping(value={"register/routine/{idType}"})
    public ResponseEntity registerNewRoutine(@PathVariable Integer idType, @RequestBody RegisterRoutinePOJO routinePOJO){
    TypeRoutine type=typeRoutineService.findById(idType);

        if(type==null || !routineService.isRigthRoutine(routinePOJO)){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
        Routine newRoutine=new Routine();
    newRoutine.setDescription(routinePOJO.getDescription());
    newRoutine.setPrice(routinePOJO.getPrice());
    newRoutine.setName(routinePOJO.getName());
    newRoutine.setLinkPreview(routinePOJO.getLink_preview());
    newRoutine.setIdOwner(routinePOJO.getIdOwner());
    newRoutine.setRating(DefaultRating);
    newRoutine.setType(type);
    newRoutine.setNumRaitings(DefaultNumRaitings);
    routineService.save(newRoutine);
    return new ResponseEntity(HttpStatus.CREATED);
    }
}
