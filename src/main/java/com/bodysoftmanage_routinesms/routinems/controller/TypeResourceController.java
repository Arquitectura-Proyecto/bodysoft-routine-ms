package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.TypeResource;
import com.bodysoftmanage_routinesms.routinems.service.TypeResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TypeResourceController {
    private TypeResourceService typeResourceService;

    public TypeResourceController(TypeResourceService typeResourceService) {
        this.typeResourceService = typeResourceService;
    }

    @GetMapping(value={"/routine-ms/typeResource/getAll"})
    public ResponseEntity<List<TypeResource>>getAll(){
        return new ResponseEntity(this.typeResourceService.getAll(), HttpStatus.OK);
    }


}
