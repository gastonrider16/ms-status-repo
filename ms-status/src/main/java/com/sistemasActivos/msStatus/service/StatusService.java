/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasActivos.msStatus.service;

import com.sistemasActivos.msStatus.model.Status;

public interface StatusService extends BaseService<Status, Long>{
    public Status saveStatus(Status statusEntity) throws Exception;
}
