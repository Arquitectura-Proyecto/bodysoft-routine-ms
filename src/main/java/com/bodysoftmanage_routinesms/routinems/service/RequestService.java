package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.Request;
import com.bodysoftmanage_routinesms.routinems.pojo.RegisterRequestPOJO;
import com.bodysoftmanage_routinesms.routinems.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void save(Request request){
        this.requestRepository.save(request);
    }

    public boolean isRigthRequest(RegisterRequestPOJO registerRequestPOJO){
        boolean correct=registerRequestPOJO.getIdRoutine()!=null
                        &&registerRequestPOJO.getIdUser()!=null;
        if(correct){
            correct=registerRequestPOJO.getIdRoutine()>0&&registerRequestPOJO.getIdUser()>0;
        }
        return correct;
    }

}
