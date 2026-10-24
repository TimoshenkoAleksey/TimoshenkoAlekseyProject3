package ru.aston.timoshenko.aleksey.project3.adapter;

import java.util.Objects;

public class PrinterToOldPrinterAdapter implements OldPrinter {
    private final Printer printer;

    public PrinterToOldPrinterAdapter(Printer printer) {
        this.printer = Objects.requireNonNull(printer,  "printer must not be null");
    }

    @Override
    public void print(String text) {
        printer.printSomething(text);
    }
}
