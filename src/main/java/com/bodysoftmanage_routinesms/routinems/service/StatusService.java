package com.bodysoftmanage_routinesms.routinems.service;

import com.bodysoftmanage_routinesms.routinems.model.Status;
import com.bodysoftmanage_routinesms.routinems.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    public Status getById(Integer id){
        return this.statusRepository.findById(id).orElse(null);
    }
    public List<Status> getAll(){return this.statusRepository.findAll();}
}
