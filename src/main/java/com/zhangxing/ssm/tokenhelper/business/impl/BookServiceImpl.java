package com.zhangxing.ssm.tokenhelper.business.impl;

import com.zhangxing.ssm.tokenhelper.ValidatorUtils;
import com.zhangxing.ssm.tokenhelper.business.inf.BookService;
import com.zhangxing.ssm.tokenhelper.dao.inf.BookDao;
import com.zhangxing.ssm.tokenhelper.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zhangxing
 * @Date: 2019/4/22 23:52
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book addBook(Book book) throws Exception {
        checkBook(book);
        book.setId(UUID.randomUUID().toString());
        bookDao.addBook(book);
        return book;
    }

    @Override
    public Book updBook(Book book) throws Exception {
        checkBook(book);
        bookDao.updBook(book);
        return book;
    }

    @Override
    public void delBook(String bookId) throws Exception {
        ValidatorUtils.checkUuid(bookId);
        bookDao.delBook(bookId);
    }

    @Override
    public List<Book> queryBookByUserId(String userId) throws Exception {
        ValidatorUtils.checkUuid(userId);
        return bookDao.queryBookByUserId(userId);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    private void checkBook(Book book) throws Exception
    {
        if (null == book)
        {
            System.out.println("book is null.");
            throw new Exception("book is null");
        }
        if (StringUtils.isEmpty(book.getName()) || StringUtils.isEmpty(book.getUserId()))
        {
            System.out.println("name or userId is empty.");
            throw new Exception("name or userId is empty.");
        }
    }

}
