package ru.aston.timoshenko.aleksey.project3.proxy;

public class Client {
    private final Secret secret;

    public Client(Secret secret) {
        this.secret = secret;
    }

    public String sayPassword() {
        return secret.sayPassword();
    }
}
