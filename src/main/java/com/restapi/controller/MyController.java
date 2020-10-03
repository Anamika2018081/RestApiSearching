package com.restapi.controller;

//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import com.restapi.model.Patient;
import com.restapi.service.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MyController {

    @Autowired
    private MyService myService;

   /* @GetMapping("/patient/list")
    public List<Patient> listAll() {
        return myService.listAll();
    }*/

    /* @GetMapping("/patient/list")
    public ResponseEntity<List<Patient>> listAll() {
         return new ResponseEntity<>(myService.listAll(), HttpStatus.OK.valueOf(200));
    }*/
   

    @GetMapping({"/patient/list/{pno}", "/"})
    public ResponseEntity<Page<Patient>> listAll(Model model,@PathVariable String pno) {
        int i = Integer.parseInt(pno);
        Page<Patient> page = myService.listAll(i);
        //List<Patient> patientlist = page.getContent();
        System.out.println(page);
        System.out.println(page.getTotalElements());
        System.out.println(page.getSize());
        System.out.println(page.getNumber());
        System.out.println(page.getTotalPages());
        return new ResponseEntity<>(page, HttpStatus.OK.valueOf(200));
    }
    /* @GetMapping("/patient")
    public List<Patient> searchPatient(@RequestParam(value = "firstname") String name) {
        return myService.getByFnameAndLname(name);
    }
    */
  /*  @GetMapping("/patient")
    public ResponseEntity<List<Patient>> searchPatient(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(myService.getByFnameAndLname(name), HttpStatus.OK.valueOf(200));
    }
    */

    @GetMapping("/patient/{pno}")
    public ResponseEntity<Page<Patient>> searchPatient(@RequestParam(value = "name") String name,@PathVariable String pno) {
        int i = Integer.parseInt(pno);
        Page<Patient> page = myService.getByFnameAndLname(name,i);
        return new ResponseEntity<>(page, HttpStatus.OK.valueOf(200));
    }

    /*@RequestMapping(value = "/test",method = RequestMethod.GET)
    public Page<Patient> fetchByPage(Pageable page){
        return this.myService.findAllByPage(page);
    }*/

    @GetMapping("/test")
    public ResponseEntity<Page<Patient>> fetchByPage(Pageable page) {
         return new ResponseEntity<>(myService.findAllByPage(page), HttpStatus.OK.valueOf(200));
    }
/*  
     @GetMapping("/patient")
    public Optional<Patient> searchPatient(@RequestParam(value = "pid") String pid) {
        return myService.getByPid(pid);
    }
*/

/*
    @PostMapping("/patient")
    public Patient newPatient(@RequestBody Patient patient){
        String pattern = "^([A-Za-z0-9])*$";
       
        if (patient.getFirstname().matches(pattern) && patient.getLastname().matches(pattern) && patient.getDob().isBefore(LocalDate.now()) ) {
           System.out.println("valid");
            return myService.saveOrUpdate(patient);
        } else {
                System.out.println("Input format should be [A-Za-z0-9]");
                return null;
        }
    }
    */


     /*@PostMapping("/patient")
    public Patient newPatient(@RequestBody Patient patient){
           return myService.saveOrUpdate(patient);
    }*/

    
}