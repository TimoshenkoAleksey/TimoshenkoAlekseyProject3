package ru.aston.timoshenko.aleksey.project3.decorator;

public class UpperCaseDecorator extends TextDecorator {

    public UpperCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String render() {
        return text.render().toUpperCase();
    }
}
