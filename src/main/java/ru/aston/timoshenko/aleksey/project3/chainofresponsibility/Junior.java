package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public class Junior extends Handler {

    public Junior() {
        super(DeveloperRole.JUNIOR);
    }

    @Override
    public boolean process(Request request) {
        if (request.grade() <= 4) {
            System.out.println("Запрос \"" + request.name() + "\" успешно обработан " + developerRole.name());
            return true;
        }
        return false;
    }
}
