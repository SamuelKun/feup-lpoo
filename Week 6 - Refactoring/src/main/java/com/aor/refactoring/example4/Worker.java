package com.aor.refactoring.example4;

import java.util.HashSet;
import java.util.Set;

public class Worker extends Person{
    private final String username;
    private final String password;

    public Worker(String name, String phone, String username, String password) {
        super(name, phone);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
