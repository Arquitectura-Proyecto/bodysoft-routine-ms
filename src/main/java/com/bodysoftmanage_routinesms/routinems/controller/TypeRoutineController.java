package com.bodysoftmanage_routinesms.routinems.controller;



import com.bodysoftmanage_routinesms.routinems.model.TypeRoutine;
import com.bodysoftmanage_routinesms.routinems.service.TypeRoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TypeRoutineController {
    private TypeRoutineService typeRoutineService;

    public TypeRoutineController(TypeRoutineService typeRoutineService) {
        this.typeRoutineService = typeRoutineService;
    }

    @GetMapping(value={"/routine-ms/typeRoutine/getAll"})
    public ResponseEntity<List<TypeRoutine>> getAll(){
        return new ResponseEntity(this.typeRoutineService.getAll(), HttpStatus.OK);
}



}
