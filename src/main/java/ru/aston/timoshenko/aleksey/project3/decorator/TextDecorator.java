package ru.aston.timoshenko.aleksey.project3.decorator;

public abstract class TextDecorator implements Text {
    public Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }
}
