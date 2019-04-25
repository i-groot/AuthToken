package com.ssm.tokenhelper.business.inf;

import com.ssm.tokenhelper.model.Book;

import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:52
 */
public interface BookService {
    Book addBook(Book book) throws Exception;

    Book updBook(String id, Book book) throws Exception;

    void delBook(String id) throws Exception;

    Book queryBookById(String id) throws Exception;

    List<Book> queryBooks();
}
