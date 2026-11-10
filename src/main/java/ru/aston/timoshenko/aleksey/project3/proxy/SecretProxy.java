package ru.aston.timoshenko.aleksey.project3.proxy;

public class SecretProxy implements Secret {

    private final Secret secret = new SecretKeeper();
    private final AccessLevel level;

    public SecretProxy(AccessLevel level) {
        this.level = level;
    }

    @Override
    public String sayPassword() {
        if (level == AccessLevel.ADMIN) {
            return secret.sayPassword();
        } else {
            return "Доступ запрещен: информация недоступна!";
        }
    }
}
