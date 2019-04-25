package com.ssm.tokenhelper.dao.mapper;

import com.ssm.tokenhelper.model.Book;
import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/21 23:48
 */
public interface BookMapper {

    void addBook(Book book);

    void updBook(Book book);

    void delBook(String id);

    Book queryBookById(String id);

    List<Book> queryBooks();

    void healthCheck();
}
