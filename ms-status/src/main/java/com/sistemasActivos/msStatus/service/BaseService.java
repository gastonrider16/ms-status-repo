/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasActivos.msStatus.service;
import com.sistemasActivos.msStatus.model.Base;
import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable>{
    public List<E> findAll() throws Exception;
    public E findById(ID id)throws Exception;
    public E save(E entity)throws Exception;
    public E update(ID id, E entity)throws Exception;
    public E updatePatch(ID id, E entity)throws Exception;
    public boolean delete(ID id)throws Exception;
}
