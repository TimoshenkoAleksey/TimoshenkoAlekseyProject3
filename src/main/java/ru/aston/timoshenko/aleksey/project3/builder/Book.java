package ru.aston.timoshenko.aleksey.project3.builder;

import java.time.LocalDate;

public record Book (String title, String author, int year, int pages){

    public Book {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги должно быть указано");
        }
        if (author == null ||  author.isBlank()) {
            throw new IllegalArgumentException("Автор должен быть указан");
        }
        if (year < 1440 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Год выхода книги не может быть раньше, чем начало эпохи книгопечатания " +
                    "и не может быть в будущем: " + year);
        }
        if (pages < 1) {
            throw new IllegalArgumentException("В книге не может быть ноль или меньше страниц: " + pages);
        }
    }

    private Book (Builder builder) {
        this(builder.title, builder.author, builder.year, builder.pages);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String author;
        private int year;
        private int pages;


        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build(){
            return new Book(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", pages=" + pages +
                    '}';
        }
    }
}
