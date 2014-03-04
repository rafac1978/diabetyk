/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.dao;

import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.diabetyk.web.model.UserData;

/**
 *
 * @author Adrian Lapierre
 */
public interface UserDataDAO extends CrudRepository<UserData, String> {
    
}
