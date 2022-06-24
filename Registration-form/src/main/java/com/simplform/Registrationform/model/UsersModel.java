package com.simplform.Registrationform.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_table")
public class UsersModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer Id;
    String login;
    String password;
    String email;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(Id, that.Id) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, login, password, email);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "Id=" + Id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
