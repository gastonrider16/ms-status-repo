/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.sistemasActivos.msStatus.service;

import com.sistemasActivos.msStatus.model.Base;
import com.sistemasActivos.msStatus.repository.BaseRepository;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    @Autowired
    protected BaseRepository<E, ID> baseRepository;
    
    @Override
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }    
    }

    @Override
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e){
        throw new Exception(e.getMessage());
     } 
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;  
        }
        catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional <E> entityOptional = baseRepository.findById(id);
            E state = entityOptional.get();
            state = baseRepository.save(entity);
            return state;
        }
        catch(Exception e){
           throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }  
    }

    @Override
    @Transactional
    public E updatePatch(ID id, E entity) throws Exception {
        try{
            Optional <E> entityOptional = baseRepository.findById(id);
            E state = entityOptional.get();
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                if (value != null) {
                    Field declaredField = state.getClass().getDeclaredField(field.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(state, value);
                }
            }
            return baseRepository.save(state);
        }
        catch(Exception e){
           throw new Exception(e.getMessage());
        }
    }
}
