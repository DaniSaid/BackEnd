package com.portafoliodg.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min = 4, max=15, message="minimo tienen que ser 4 caracteres y maximo 15")
    private String user;
    
    @Size(min = 8, max=15, message="minimo tienen que ser 4 caracteres y maximo 15")
    private String password;

    public User() {
    }

    public User(Long id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
