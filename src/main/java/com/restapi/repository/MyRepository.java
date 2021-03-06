package com.restapi.repository;

import java.util.List;

import com.restapi.model.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyRepository extends CrudRepository<Patient, String> , PagingAndSortingRepository<Patient,String> {

    //List<Patient> getByName(String name);
    
    
    //List<Patient> getByFnameAndLname(String name);
    Page<Patient> findAll(Pageable pageable);
    @Query(value = "{$or:[{firstname:{$regex:?0,$options:'i'}},{lastname:{$regex:?0,$options:'i'}}]}")
    Page<Patient> getByFnameAndLname(String name,Pageable page);
    
}