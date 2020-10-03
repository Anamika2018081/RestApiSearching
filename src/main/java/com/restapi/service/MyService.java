package com.restapi.service;

import java.util.List;
import java.util.Optional;

import com.restapi.model.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyService {
    
    List<Patient> listAll();
    //Page<Patient> listAll();
    Page<Patient> listAll(int pno);
    //List<Patient> getByFnameAndLname(String name);
    Page<Patient> getByFnameAndLname(String name,int page);
    //Patient saveOrUpdate(Patient patient);
    Optional<Patient> getByPid(String pid);
    public Page<Patient> findAllByPage(Pageable pageable);

}