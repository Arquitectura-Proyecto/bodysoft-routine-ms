package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.UserRoutine;
import com.bodysoftmanage_routinesms.routinems.pojo.ChangeStatusPOJO;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterUserRoutinePOJO;
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
    public boolean isRigthUserRoutine(RegisterUserRoutinePOJO registerUserRoutinePOJO){
        boolean correct=registerUserRoutinePOJO.getIdUser()!=null&&registerUserRoutinePOJO.getIdRoutine()!=null
                        &&registerUserRoutinePOJO.getIdStatus()!=null&&registerUserRoutinePOJO.getIdOwner()!=null;
        if(correct){
            correct=registerUserRoutinePOJO.getIdUser()>0&&registerUserRoutinePOJO.getIdRoutine()>0
                    &&registerUserRoutinePOJO.getIdStatus()>0&&registerUserRoutinePOJO.getIdOwner()>0;
        }
        return correct;
    }


    public List<UserRoutine>getAvailableByIdUser(Integer idUser){
       return userRoutineRepository.findAllByIdUserAndStatusId(idUser,idStatusAvailable);
    }
    public void save(UserRoutine userRoutine){
        this.userRoutineRepository.save(userRoutine);
    }

    public UserRoutine getByIdUserAndIdRoutine(Integer idUser,Integer idRoutine){
        return  this.userRoutineRepository.findFirstByIdUserAndRoutineId(idUser,idRoutine);
    }
    public boolean canBeQualified(UserRoutine userRoutine){
        return userRoutine.getQuailified()==false;
    }
    public boolean isCorrectChangeStatus(ChangeStatusPOJO changeStatus){
        return changeStatus.getIdStatus()!=null&&changeStatus.getIdUser()!=null
                &&changeStatus.getIdStatus()>0&&changeStatus.getIdUser()>0;
    }
    public List<UserRoutine>getByIdUser(Integer idUser){
        return this.userRoutineRepository.findAllByIdUser(idUser);
    }

}
