package com.ssm.tokenhelper.dao.impl;

import com.ssm.tokenhelper.dao.mapper.BookMapper;
import com.ssm.tokenhelper.dao.inf.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssm.tokenhelper.model.Book;
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
    public void delBook(String id) {
        mapper.delBook(id);
    }

    @Override
    public Book queryBookById(String id) {
        return mapper.queryBookById(id);
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
