package com.zhangxing.ssm.tokenhelper.dao.inf;

import com.zhangxing.ssm.tokenhelper.model.Book;
import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 22:42
 */
public interface BookDao {
    void addBook(Book book);

    void updBook(Book book);

    void delBook(String bookId);

    List<Book> queryBookByUserId(String userId);

    List<Book> queryBooks();

    void healthCheck();
}
