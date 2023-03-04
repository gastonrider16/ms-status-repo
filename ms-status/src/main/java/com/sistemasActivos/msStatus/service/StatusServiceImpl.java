/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasActivos.msStatus.service;

import org.springframework.stereotype.Service;
import com.sistemasActivos.msStatus.model.Status;
import com.sistemasActivos.msStatus.repository.StatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StatusServiceImpl extends BaseServiceImpl<Status, Long> implements StatusService {
    
   @Autowired
   private StatusRepository statusRepository;
   
   @Override
   @Transactional
    public Status saveStatus(Status statusEntity) throws Exception {
        try{
            Status statusName = statusRepository.findByStatusName(
                    statusEntity.getStatusName());
            if(statusName != null){
                 throw new Exception("Registro duplicado");
            } 
            return statusRepository.save(statusEntity);
        }
        catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }
}
