/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasActivos.msStatus.controller;

import com.sistemasActivos.msStatus.model.Status;
import com.sistemasActivos.msStatus.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("ms/status")
public class StatusController extends BaseControllerImpl<Status, StatusServiceImpl>{
    @Autowired
    private StatusServiceImpl statusServiceImpl;
    
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Status statusEntity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(statusServiceImpl.saveStatus(statusEntity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"404\"}");
        }
    }
}
