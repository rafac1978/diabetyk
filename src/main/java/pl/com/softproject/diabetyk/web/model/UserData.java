/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.model;

import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@Cacheable(true)
public class UserData {

    @Column(length = 50)
    @NotEmpty
    @Id
    private String login;

    @Column(length = 256)
    @Email
    @NotEmpty
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoggedIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public UserData() {
    }

    public UserData(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "UserData{" + "login=" + login + ", email=" + email + ", lastLoggedIn=" + lastLoggedIn + ", created=" + created + '}';
    }
}
