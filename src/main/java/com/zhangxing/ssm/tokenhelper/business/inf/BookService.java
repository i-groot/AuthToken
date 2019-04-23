package com.zhangxing.ssm.tokenhelper.business.inf;

import com.zhangxing.ssm.tokenhelper.model.Book;

import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:52
 */
public interface BookService {
    Book addBook(Book book) throws Exception;

    Book updBook(Book book) throws Exception;

    void delBook(String bookId) throws Exception;

    List<Book> queryBookByUserId(String userId) throws Exception;

    List<Book> queryBooks();
}
