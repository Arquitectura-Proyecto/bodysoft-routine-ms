package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.model.TypeRoutine;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RoutineController {
    private RoutineService routineService;
    private TypeRoutine typeRoutine;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;

    }

    @PostMapping(value={"register/routine/{idType}"})
    public ResponseEntity registerNewRoutine(@PathVariable Integer idType, @RequestBody RegisterRoutinePOJO routinePOJO){
    Routine newRoutine=new Routine();
    newRoutine.setDescription(routinePOJO.getDescription());
    newRoutine.setPrice(routinePOJO.getPrice());
    newRoutine.setName(routinePOJO.getName());
    return new ResponseEntity(HttpStatus.CREATED);
    }
}
