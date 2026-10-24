package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public class Middle extends Handler {

    public Middle() {
        super(DeveloperRole.MIDDLE);
    }

    @Override
    public boolean process(Request request) {
        if (request.grade() <= 6) {
            System.out.println("Запрос \"" + request.name() + "\" успешно обработан " + developerRole.name());
            return true;
        }
        return false;
    }
}
