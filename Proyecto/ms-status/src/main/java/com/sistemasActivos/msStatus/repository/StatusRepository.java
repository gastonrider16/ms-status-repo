/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.sistemasActivos.msStatus.repository;

import com.sistemasActivos.msStatus.model.Status;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends BaseRepository<Status, Long> {
    Status findByStatusName(String statusName);
}
