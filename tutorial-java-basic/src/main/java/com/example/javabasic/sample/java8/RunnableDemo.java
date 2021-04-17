package com.example.javabasic.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author chenpenghui
 * @date 2020/7/19
 */
public class RunnableDemo {
    public static void main(String[] args) {

        final List<Book> list = Arrays.asList(new Book(1, "Ramayan"), new Book(2, "Mahabharat"));
        Runnable r1 = () -> list.forEach(Book::print);
        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = () -> {
            Consumer<Book> style = (Book b) -> System.out.println("Book Id: " + b.getId() + ", Book Name: " + b.getName());
            list.forEach(style);
        };
        Thread t2 = new Thread(r2);
        t2.start();

    }

    static class Book {
        private long id;
        private String name;

        public Book(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println("id: " + id + ", name: " + name);
        }
    }
}
