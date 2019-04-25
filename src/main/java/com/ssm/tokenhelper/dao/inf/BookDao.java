package com.ssm.tokenhelper.dao.inf;

import com.ssm.tokenhelper.model.Book;

import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 22:42
 */
public interface BookDao {
    void addBook(Book book);

    void updBook(Book book);

    void delBook(String id);

    Book queryBookById(String id);

    List<Book> queryBooks();

    void healthCheck();
}
