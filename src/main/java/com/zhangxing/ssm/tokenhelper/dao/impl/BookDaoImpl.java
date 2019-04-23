package com.zhangxing.ssm.tokenhelper.dao.impl;

import com.zhangxing.ssm.tokenhelper.dao.inf.BookDao;
import com.zhangxing.ssm.tokenhelper.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhangxing.ssm.tokenhelper.model.Book;
import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 22:43
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookMapper mapper;

    @Override
    public void addBook(Book book) {
        mapper.addBook(book);
    }

    @Override
    public void updBook(Book book) {
        mapper.updBook(book);
    }

    @Override
    public void delBook(String bookId) {
        mapper.delBook(bookId);
    }

    @Override
    public List<Book> queryBookByUserId(String userId) {
        return mapper.queryBookByUserId(userId);
    }

    @Override
    public List<Book> queryBooks() {
        return mapper.queryBooks();
    }

    @Override
    public void healthCheck() {
        mapper.healthCheck();
    }
}
