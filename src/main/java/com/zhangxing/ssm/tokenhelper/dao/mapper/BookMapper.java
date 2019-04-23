package com.zhangxing.ssm.tokenhelper.dao.mapper;

import com.zhangxing.ssm.tokenhelper.model.Book;
import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/21 23:48
 */
public interface BookMapper {

    void addBook(Book book);

    void updBook(Book book);

    void delBook(String bookId);

    List<Book> queryBookByUserId(String userId);

    List<Book> queryBooks();

    void healthCheck();
}
