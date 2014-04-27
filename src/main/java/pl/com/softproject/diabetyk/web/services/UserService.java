/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.services;

import pl.com.softproject.diabetyk.web.model.UserData;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface UserService {

    UserData loadCurrentUserData();

    void makeAdmin(String username);

    void makeModerator(String username);

    void passwordReset(String username);

    void registerUser(String username, String password, String email);

    boolean isAuthenticated();
}
