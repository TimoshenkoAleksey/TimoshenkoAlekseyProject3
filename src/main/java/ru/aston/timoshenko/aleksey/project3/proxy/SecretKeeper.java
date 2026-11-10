package ru.aston.timoshenko.aleksey.project3.proxy;

public class SecretKeeper implements Secret {

    @Override
    public String sayPassword() {
        return "password";
    }
}
