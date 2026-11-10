package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public class Trainee extends Handler {

    public Trainee() {
        super(DeveloperRole.TRAINEE);
    }

    @Override
    public boolean process(Request request) {
        if (request.grade() <= 2) {
            System.out.println("Запрос \"" + request.name() + "\" успешно обработан " + developerRole.name());
            return true;
        }
        return false;
    }
}
