package com.aor.refactoring.example4;

import java.util.HashSet;
import java.util.Set;

public class Supervisor extends Person {
    Set<Person> supervisee;
    private final String username;
    private final String password;
    
    public Supervisor(String name, String phone, String username, String password) {
        super(name, phone);
        this.username = username;
        this.password = password;
        supervisee = new HashSet<>();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public void addSupervisee(Person person) {
        supervisee.add(person);
    }

    public boolean isSupervisee(Person person) {
        return supervisee.contains(person);
    }
}
