package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public class TeamLead extends Handler {

    public TeamLead() {
        super(DeveloperRole.TEAM_LEAD);
    }

    @Override
    public boolean process(Request request) {
        System.out.println("Запрос \"" + request.name() + "\" успешно обработан " + developerRole.name());
        return true;
    }
}
