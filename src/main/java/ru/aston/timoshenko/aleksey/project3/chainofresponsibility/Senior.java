package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public class Senior extends Handler {

    public Senior() {
        super(DeveloperRole.SENIOR);
    }

    @Override
    public boolean process(Request request) {
        if (request.grade() <= 9) {
            System.out.println("Запрос \"" + request.name() + "\" успешно обработан " + developerRole.name());
            return true;
        }
        return false;
    }
}
