package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.UserRoutine;
import com.bodysoftmanage_routinesms.routinems.repository.UserRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoutineService {
    private UserRoutineRepository userRoutineRepository;
    private static Integer idStatusAvailable=1;
    public UserRoutineService(UserRoutineRepository userRoutineRepository) {
        this.userRoutineRepository = userRoutineRepository;
    }


    public List<UserRoutine>getAvailableByIdUser(Integer idUser){
       return userRoutineRepository.findAllByIdUserAndStatusId(idUser,idStatusAvailable);
    }
    public void save(UserRoutine userRoutine){
        this.userRoutineRepository.save(userRoutine);
    }
}
