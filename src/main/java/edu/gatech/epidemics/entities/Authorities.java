package edu.gatech.epidemics.entities;

import javax.persistence.*;

/**
 * @author atalati
 */
@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "authority", nullable = false)
    private String authority;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Role{" +
                "username=" + username +
                ", authority='" + authority + '\'' +
                '}';
    }
}
