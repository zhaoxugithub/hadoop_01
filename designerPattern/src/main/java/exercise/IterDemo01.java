package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/5/7 22:43
 * FileName: IterDemo01
 * Description: exercise
 * <p>
 * 迭代器模式
 */
public class IterDemo01 {

    private interface Iterator {
        boolean hasNext();

        Object next();
    }

    private interface Aggregate {
        Iterator iterateor();
    }

    private static class BookSelfIterator implements Iterator {

        private BookSelf bookSelf;
        private int index;

        public BookSelfIterator(BookSelf bookSelf) {
            this.bookSelf = bookSelf;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < bookSelf.Length();
        }

        @Override
        public Object next() {
            return bookSelf.getBookByIndex(index++);
        }
    }


    private static class Book {
        private String name;

        public Book(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    public static class BookSelf implements Aggregate {

        List<Book> list = null;


        public BookSelf() {
            list = new ArrayList<>();
        }

        public BookSelf addBook(Book book) {
            list.add(book);
            return this;
        }

        public void removeBook() {

        }

        public Book getBookByIndex(int index) {
            return list.get(index);
        }

        public int Length() {
            return list.size();
        }


        @Override
        public Iterator iterateor() {
            return new BookSelfIterator(this);
        }
    }


    public static void main(String[] args) {
        BookSelf bookSelf = new BookSelf();
        bookSelf.addBook(new Book("1"))
                .addBook(new Book("2"))
                .addBook(new Book("3"))
                .addBook(new Book("4"))
                .addBook(new Book("5"));

        Iterator iterateor = bookSelf.iterateor();
        while (iterateor.hasNext()) {
            Book next = (Book) iterateor.next();
            System.out.println(next);
        }

    }


}
