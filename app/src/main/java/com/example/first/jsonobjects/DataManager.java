package com.example.first.jsonobjects;

import java.util.ArrayList;

public class DataManager {

    private static ArrayList<Book> bookList = new ArrayList<>();

    public static ArrayList<Book> getBookList() {
        return bookList;
    }

    public static void setBookList(ArrayList<Book> bookList) {
        DataManager.bookList = bookList;
    }

    public static void addBook(Book book) {
        bookList.add(book);
    }


}
