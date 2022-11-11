package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {

    @NotNull
    private  String username;


    @NotNull
    private  String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }


    public String getUsername() {
        return username;
    }
}
