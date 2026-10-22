package ru.aston.timoshenko.aleksey.project3.decorator;

public class PlaneText implements Text {
    private String planeText;

    public PlaneText(String planeText) {
        this.planeText = planeText;
    }

    @Override
    public String render() {
        return planeText;
    }
}
