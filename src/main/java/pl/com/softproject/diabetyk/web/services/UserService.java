/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.services;

import pl.com.softproject.diabetyk.web.model.UserData;

/**
 *
 * @author Adrian Lapierre
 */
public interface UserService {

    UserData loadCurrentUserData();

    void makeAdmin(String username);
    
    void makeModerator(String username);

    void passwordReset(String username);

    void registerUser(String username, String password, String email);
    
}
