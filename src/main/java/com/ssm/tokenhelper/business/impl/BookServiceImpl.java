package com.ssm.tokenhelper.business.impl;

import com.ssm.tokenhelper.business.inf.BookService;
import com.ssm.tokenhelper.utils.ValidatorUtils;
import com.ssm.tokenhelper.dao.inf.BookDao;
import com.ssm.tokenhelper.model.Book;
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
    public Book updBook(String id, Book book) throws Exception {
        ValidatorUtils.checkUuid(id);
        Book book2 = bookDao.queryBookById(id);
        if (null == book2)
        {
            System.out.println("Not Found, id is " + id);
            throw new Exception("Not Found, id is " + id);
        }
        book.setId(id);
        bookDao.updBook(book);
        book2.setNum(book.getNum());
        return book2;
    }

    @Override
    public void delBook(String id) throws Exception {
        ValidatorUtils.checkUuid(id);
        bookDao.delBook(id);
    }

    @Override
    public Book queryBookById(String id) throws Exception {
        ValidatorUtils.checkUuid(id);
        return bookDao.queryBookById(id);
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
        if (StringUtils.isEmpty(book.getName()) || book.getNum() < 0)
        {
            System.out.println("name is empty or num is less than 0.");
            throw new Exception("name is empty or num is less than 0.");
        }
    }

}
