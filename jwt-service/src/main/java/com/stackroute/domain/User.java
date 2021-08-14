package com.stackroute.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * to define an entity
 */
@Entity
@Table(name = "User")
public class User {

    /**
     * @Id annotation to make id variable as Primary key
     */
    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "password")
    private String password;


    /**
     * default constructor
     */
    public User() {
        super();
    }

    /**
     * parameterized constructor
     */
    public User(String id, String password) {
        super();
        this.id = id;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
