package com.bodysoftmanage_routinesms.routinems.controller;


import com.bodysoftmanage_routinesms.routinems.model.Routine;
import com.bodysoftmanage_routinesms.routinems.model.Status;
import com.bodysoftmanage_routinesms.routinems.model.UserRoutine;
import com.bodysoftmanage_routinesms.routinems.pojo.ChangeStatusPOJO;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterUserRoutinePOJO;
import com.bodysoftmanage_routinesms.routinems.service.RoutineService;
import com.bodysoftmanage_routinesms.routinems.service.StatusService;
import com.bodysoftmanage_routinesms.routinems.service.UserRoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserRoutineController {
    private UserRoutineService userRoutineService;
    private RoutineService routineService;
    private StatusService statusService;
    private static Boolean defaultQualified=false;
    public UserRoutineController(UserRoutineService userRoutineService, RoutineService routineService, StatusService statusService) {
        this.userRoutineService = userRoutineService;
        this.routineService = routineService;
        this.statusService = statusService;
    }

    @GetMapping(value={"/routine-ms/user-routine/getAvailable/{idUser}"})//permite ver las rutinas que un usuario ha comprado y estan disponibles
    public ResponseEntity<List<UserRoutine>> getAvailableByIdUser(@PathVariable Integer idUser){//get routines wich a user bougth
        return new ResponseEntity(userRoutineService.getAvailableByIdUser(idUser), HttpStatus.OK);
    }
    @PostMapping(value={"/routine-ms/user-routine/register"})
    public ResponseEntity register(@RequestBody RegisterUserRoutinePOJO userRoutine){//permite a usuario comprar una rutina
        Routine routine=routineService.getById(userRoutine.getIdRoutine());
        Status status=statusService.getById(userRoutine.getIdStatus());
        if(routine==null||status==null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if(routine.getIdOwner()!=userRoutine.getIdOwner()){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        UserRoutine newuserRoutine=new UserRoutine();
        newuserRoutine.setIdUser(userRoutine.getIdUser());
        newuserRoutine.setRoutine(routine);
        newuserRoutine.setStatus(status);
        newuserRoutine.setQuailified(defaultQualified);
        userRoutineService.save(newuserRoutine);
        return new ResponseEntity(HttpStatus.CREATED);
    }
        @PutMapping(value={"/routine-ms/user-routine/changeStatus/{idRoutine}"})
        public ResponseEntity changeStatus(@PathVariable Integer idRoutine, @RequestBody ChangeStatusPOJO changeStatus){

            Status status=statusService.getById(changeStatus.getIdStatus());
            Routine routine=routineService.getById(idRoutine);
            if(!userRoutineService.isCorrectChangeStatus(changeStatus)||status==null||routine==null){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            UserRoutine userRoutine=userRoutineService.getByIdUserAndIdRoutine(changeStatus.getIdUser(),idRoutine);
            if(userRoutine==null){
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
            userRoutine.setStatus(status);
            userRoutineService.save(userRoutine);
            return new ResponseEntity(HttpStatus.OK);


        }

    @GetMapping(value={"/routine-ms/user-routine/get/{idUser}"})//permite ver las rutinas que un usuario ha comprado(archivadas o no)
    public ResponseEntity<List<UserRoutine>> getByIdUser(@PathVariable Integer idUser){//get routines wich a user bougth
        return new ResponseEntity(userRoutineService.getByIdUser(idUser), HttpStatus.OK);
    }



}
