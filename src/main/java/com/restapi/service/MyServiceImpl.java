package com.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.restapi.model.Patient;
import com.restapi.repository.MyRepository;

//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    private MyRepository myRepository;

    @Autowired
    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
/*
    @Override
    public List<Patient> getByFnameAndLname(String name) {
        List<Patient> patients = new ArrayList<>();
        myRepository.getByFnameAndLname(name).forEach(patients::add);
        return patients;
    }
*/
    @Override
    public Page<Patient> getByFnameAndLname(String name,int pno) {
        Pageable pageable = PageRequest.of(pno, 50);
        return myRepository.getByFnameAndLname(name,pageable);
    }

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = new ArrayList<>();
        myRepository.findAll().forEach(patients::add);
        return patients;
    }
    @Override
    public Page<Patient> listAll(int pno) {
        Pageable pageable = PageRequest.of(pno, 50);
        return myRepository.findAll(pageable);
    }

    @Override
     public Page<Patient> findAllByPage(Pageable pageable) {
        return  myRepository.findAll(pageable);
    }
    /*
    @Override
    public Patient saveOrUpdate(Patient patient) {
        patient.setPid(RandomStringUtils.randomAlphanumeric(16));
        myRepository.save(patient);
        return patient;
    }
*/
    @Override
    public Optional<Patient> getByPid(String pid) {
        return myRepository.findById(pid);
    }

    
    
}