/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import pl.com.softproject.diabetyk.web.dao.UserDataDAO;
import pl.com.softproject.diabetyk.web.model.UserData;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private UserDataDAO userDataDAO;

    @Override
    public void registerUser(String username, String password, String email) {
        List<GrantedAuthority> auth = Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")});

        User user = new User(username, password, auth);
        userDetailsManager.createUser(user);
        UserData userData = new UserData(username, email);
        userData.setCreated(new Date());
        userDataDAO.save(userData);
    }

    @Secured("ROLE_ADMIN")
    @Override
    public void makeModerator(String username) {
    }

    @Secured("ROLE_ADMIN")
    @Override
    public void makeAdmin(String username) {
    }

    @Override
    public void passwordReset(String username) {
    }

    @Override
    public boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    @Secured("ROLE_USER")
    public void changePassword(String oldPassword, String newPassword) {
        userDetailsManager.changePassword(oldPassword, newPassword);
    }

    public UserDetailsManager getUserDetailsManager() {
        return userDetailsManager;
    }

    public void setUserDetailsManager(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public UserData loadCurrentUserData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                String userName = userDetails.getUsername();
                return userDataDAO.findOne(userName);
            }
        }

        return null;
    }
}
