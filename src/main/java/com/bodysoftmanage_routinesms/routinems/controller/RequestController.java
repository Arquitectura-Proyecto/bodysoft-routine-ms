package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Request;
import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRequestPOJO;
import com.bodysoftmanage_routinesms.routinems.service.RequestService;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    private RequestService requestService;
    private RoutineService routineService;

    public RequestController(RequestService requestService, RoutineService routineService) {
        this.requestService = requestService;
        this.routineService = routineService;
    }

    @PostMapping(value={"/routine-ms/request"})
    public ResponseEntity register(@RequestBody RegisterRequestPOJO requestPOJO){
        if(!requestService.isRigthRequest(requestPOJO)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Routine routine=routineService.getById(requestPOJO.getIdRoutine());
        if(routine==null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        Request newRequest =new Request();
        newRequest.setIdUser(requestPOJO.getIdUser());
        newRequest.setRoutine(routine);
        requestService.save(newRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
