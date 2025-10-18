package com.example.school.entities;

import java.util.Objects;

public final class SignUp {
    private final String username;

    private final String password;

    private final String confirmPassword;

    private final String email;

    public SignUp(String username, String password, String confirmPassword, String email) {
        if(username.isBlank() || password.isBlank() || confirmPassword.isBlank() || email.isBlank()){
            throw new IllegalArgumentException("fields can not be empty!");
        }
        if(!password.equals(confirmPassword)){
            throw new IllegalArgumentException("passwords do not match!");
        }
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;

    }

    @Override
    public int hashCode() {
        return Objects.hash(username,password,confirmPassword,email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||  getClass() != o.getClass()) return false;
        SignUp signUp = (SignUp) o;
        return username.equals(signUp.username) && password.equals(signUp.password)
                && confirmPassword.equals(signUp.confirmPassword) && email.equals(signUp.email);
    }
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}
