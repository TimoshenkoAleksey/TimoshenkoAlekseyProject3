package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public abstract class Handler {
    private Handler next;
    protected DeveloperRole developerRole;

    public Handler(DeveloperRole developerRole) {
        this.developerRole = developerRole;
    }

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(Request request) {
        if (process(request)) {
            return;
        }
        if (next != null) {
            next.handle(request);
        } else {
            throw new HandlerNotExistException("No such handler");
        }
    }

    public abstract boolean process(Request request);
}
