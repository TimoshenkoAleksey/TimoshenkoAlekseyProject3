package ru.aston.timoshenko.aleksey.project3.decorator;

public class UnderlineDecorator extends TextDecorator {

    public UnderlineDecorator(Text text) {
        super(text);
    }

    @Override
    public String render() {
        return "<u>" + text.render() + "</u>";
    }
}
