package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Status;
import com.bodysoftmanage_routinesms.routinems.service.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class StatusController {
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    @GetMapping(value={"/routine-ms/status/getAll"})
    public ResponseEntity<List<Status>>getAll(){
        return new ResponseEntity(this.statusService.getAll(), HttpStatus.OK);
    }
}
