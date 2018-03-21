/**
 * @Author Falco Constantine
 * @Project Users list
 * @Version 1.0
 * @Date 2018.03.17
 *
*/
package com.example.demo.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Class User
 * Entity for data model
 */
@Entity
public class User {

    /**
     * Variables defining
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;

    /**
     * User constructors
     */
    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Getters & Setters

    /**
     * @getter getId
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter getUsername
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Username setUsername
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter getPassword
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Username setPassword
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter getEmail
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Username setEmail
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * toString() method
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
