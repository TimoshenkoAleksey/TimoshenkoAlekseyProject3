package ru.aston.timoshenko.aleksey.project3;

import ru.aston.timoshenko.aleksey.project3.adapter.OldPrinter;
import ru.aston.timoshenko.aleksey.project3.adapter.Printer;
import ru.aston.timoshenko.aleksey.project3.adapter.PrinterToOldPrinterAdapter;
import ru.aston.timoshenko.aleksey.project3.builder.Book;
import ru.aston.timoshenko.aleksey.project3.chainofresponsibility.*;
import ru.aston.timoshenko.aleksey.project3.decorator.*;
import ru.aston.timoshenko.aleksey.project3.proxy.AccessLevel;
import ru.aston.timoshenko.aleksey.project3.proxy.Client;
import ru.aston.timoshenko.aleksey.project3.proxy.SecretProxy;
import ru.aston.timoshenko.aleksey.project3.strategy.Cart;
import ru.aston.timoshenko.aleksey.project3.strategy.Discount;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Паттерн проектирования "Билдер"
        System.out.println("Паттерн проектирования Билдер");
        Book book = Book.builder()
                .pages(200)
                .title("Jungle book")
                .year(1890)
                .author("Редьярд Киплинг")
                .build();
        System.out.println(book);
        System.out.println();

        // Паттерн проектирования "Адаптер"
        System.out.println("Паттерн проектирования Адаптер");
        OldPrinter printer = new PrinterToOldPrinterAdapter(new Printer());
        printer.print("Hello World!");
        System.out.println();
        System.out.println();

        // Паттерн проектирования "Декоратор"
        System.out.println("Паттерн проектирования Декоратор");
        Text planeText = new PlaneText("Это простой текст.");
        System.out.println(planeText.render());
        // Декоратор, делающий текст жирным
        Text text = new BoldDecorator(planeText);
        System.out.println(text.render());
        // Декоратор, делающий текст подчеркнутым, курсивным, делающий все буквы большими и текст жирным
        // (последовательно добавляются эти изменения текста)
        Text text2 = new BoldDecorator(new UpperCaseDecorator(new ItalicDecorator(new UnderlineDecorator(text))));
        System.out.println(text2.render());
        // Другая последовательность декораторов
        Text text3 = new ItalicDecorator(new UnderlineDecorator(new BoldDecorator(new UpperCaseDecorator(planeText))));
        System.out.println(text3.render());

        // Паттерн проектирования "Цепочка обязанностей"
        System.out.println();
        System.out.println("Паттерн проектирования Цепочка обязанностей");
        List<Request> requests = getRequests();
        Handler handler = new Trainee();
        handler.setNext(new Junior())
                .setNext(new Middle())
                .setNext(new Senior())
                .setNext(new TeamLead());
        for (Request request : requests) {
            handler.handle(request);
        }

        // Паттерн роектирования "Стратегия"
        System.out.println();
        System.out.println("Паттерн роектирования Стратегия");
        Cart cart = new Cart();
        for (Discount discount : Discount.values()) {
            System.out.println("Ваша скидка - " + discount);
            System.out.println("Ваша цена, с учётом скидки составляет: " + cart.showPriceWithDiscount(discount)
                    + " денег");
        }

        // Паттерн проектирования "Прокси"
        System.out.println();
        System.out.println("Паттерн проектирования Прокси");
        Client client1 = new Client(new SecretProxy(AccessLevel.ADMIN));
        Client client2 = new Client(new SecretProxy(AccessLevel.ANOTHER));
        System.out.println("Информация, когда её запрашивает админ: " + client1.sayPassword());
        System.out.println("Информация, когда её запрашивает кто то, кроме админа: " + client2.sayPassword());
    }

    private static List<Request> getRequests() {
        return List.of(
                new Request("Невероятно сложная задача", 100),
                new Request("Задача средней сложности", 5),
                new Request("Самая лёгкая задача", 1),
                new Request("Простая задача", 3),
                new Request("Сложная задача", 9)
        );
    }
}