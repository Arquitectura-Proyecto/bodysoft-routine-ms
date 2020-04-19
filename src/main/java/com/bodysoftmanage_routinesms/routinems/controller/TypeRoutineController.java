package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.service.TypeResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TypeRoutineController {
    private TypeRoutineController typeResourceService;

    public TypeRoutineController(TypeRoutineController typeResourceService) {
        this.typeResourceService = typeResourceService;
    }

    @GetMapping(value={"/routine-ms/typeRoutine/getAll"})
    public ResponseEntity getAll(){
        return new ResponseEntity(this.typeResourceService.getAll(), HttpStatus.OK);
}



}
