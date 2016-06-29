/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 * @param <T> Object Type
 * @param <I> Object Id Type
 */
public interface Dao <T,I>{
        
    boolean save(T object);
    
    boolean delete(T object);
    
    boolean update(T object);
    
    T searchById(I id);
    
    List<T> searchByAttribute(String key, String value);
    
    List<T> searchByAttributes(Map<String, String> map);
    
    List<T> listAll();
    
}
