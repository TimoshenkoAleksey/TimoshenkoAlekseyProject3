package ru.aston.timoshenko.aleksey.project3.decorator;

public class BoldDecorator extends TextDecorator{

    public BoldDecorator(Text text) {
        super(text);
    }
    @Override
    public String render() {
        return "<b>" + text.render() + "</b>";
    }
}
