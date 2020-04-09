package com.bodysoftmanage_routinesms.routinems.controller;

import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.model.TypeRoutine;
import com.bodysoftmanage_routinesms.routinems.model.UserRoutine;
import com.bodysoftmanage_routinesms.routinems.pojo.RaitingRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import com.bodysoftmanage_routinesms.routinems.service.TypeRoutineService;
import com.bodysoftmanage_routinesms.routinems.service.UserRoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RoutineController {
    private static float DefaultRating= (float) 0.0;
    private  static Integer DefaultNumRaitings=0;
    private RoutineService routineService;
    private TypeRoutineService typeRoutineService;
    private UserRoutineService userRoutineService;
    public RoutineController(RoutineService routineService, TypeRoutineService typeRoutineService,UserRoutineService userRoutineService) {
        this.routineService = routineService;
        this.typeRoutineService = typeRoutineService;
        this.userRoutineService=userRoutineService;
    }

    @PostMapping(value={"/routine-ms/register/routine"})
    public ResponseEntity registerNewRoutine(@RequestBody RegisterRoutinePOJO routinePOJO){


        if( !routineService.isRigthRoutine(routinePOJO)){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        TypeRoutine type=typeRoutineService.findById(routinePOJO.getIdType());
        if(type==null){
            return new ResponseEntity(HttpStatus.CONFLICT);
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

    @GetMapping(value={"/routine-ms/routine/byIdOwner/{idOwner}"})
    public ResponseEntity<List<Routine>> getRoutinesByOwner(@PathVariable Integer  idOwner){
        return new ResponseEntity(routineService.getAllByIdOwner(idOwner),HttpStatus.OK);
    }

    @PutMapping(value={"/routine-ms/routine/update/{idRoutine}"})
    public ResponseEntity updateRoutine(@PathVariable Integer idRoutine,@RequestBody RegisterRoutinePOJO routinePOJO){


        if( !routineService.isRigthRoutine(routinePOJO)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        TypeRoutine type=typeRoutineService.findById(routinePOJO.getIdType());
        Routine routine=routineService.getById(idRoutine);
        if(type==null||routine==null){
            return new ResponseEntity(HttpStatus.CONFLICT);

        }

        if(!routineService.isOwner(idRoutine,routinePOJO.getIdOwner())){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        routine.setDescription(routinePOJO.getDescription());
        routine.setPrice(routinePOJO.getPrice());
        routine.setName(routinePOJO.getName());
        routine.setLinkPreview(routinePOJO.getLink_preview());
        routine.setType(type);
        routineService.save(routine);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping(value={"/routine-ms/routine/getAll"})
    public ResponseEntity<List<Routine>>getAllRoutines(){
        return new ResponseEntity(routineService.getAll(),HttpStatus.OK);
    }
    @GetMapping(value={"/routine-ms/routine/getByType/{idType}"})
    public ResponseEntity<List<Routine>>getAllByType(@PathVariable Integer idType){
        return new ResponseEntity(routineService.getByType(idType),HttpStatus.OK);
    }
    @PutMapping(value={"/routine-ms/routine/raiting/{idRoutine}"})
    public ResponseEntity raitingRoutine(@PathVariable Integer idRoutine,@RequestBody RaitingRoutinePOJO raiting){
        Routine routine=routineService.getById(idRoutine);
        if(routine==null||!routineService.isRigthRaiting(raiting)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        UserRoutine userRoutine=userRoutineService.getByIdUserAndIdRoutine(raiting.getIdUser(),idRoutine);
       if(userRoutine==null||!userRoutineService.canBeQualified(userRoutine)){
           return new ResponseEntity(HttpStatus.UNAUTHORIZED);
       }
        userRoutine.setQuailified(true);
        routineService.rateARoutine(routine,raiting.getRaiting());
        routineService.save(routine);
        userRoutineService.save(userRoutine);
        return new ResponseEntity(HttpStatus.OK);


    }

}
