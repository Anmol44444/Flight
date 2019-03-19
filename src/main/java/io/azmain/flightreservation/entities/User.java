package io.azmain.flightreservation.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class User extends AbstractEntity {

    @NotEmpty(message = "Please provide first name.")
    @Length(min = 1,max = 20)
    private String firstName;

    @NotEmpty(message = "Please provide last name.")
    @Length(min = 1,max = 20)
    private String lastName;

    @NotEmpty(message = "Please provide email address.")
    @Email
    private String email;

    @Length(min = 4,message = "Password length must be greater than 4.")
    @NotEmpty(message = "Please provide a password.")
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
