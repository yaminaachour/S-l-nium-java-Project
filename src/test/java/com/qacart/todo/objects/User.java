package com.qacart.todo.objects;

public class User {
    // Déclaration des attributs de la classe

    private String email;
    private String password;
    private String firstName;
    private String lastName;
// cliquer sur le 4 puis droit puis 'Generate'  puid getters et setters

// CONSTRACTEUT
public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
}

//  getters et setters
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

















}