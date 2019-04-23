package com.zhangxing.ssm.tokenhelper.rest;

import com.zhangxing.ssm.tokenhelper.business.inf.BookService;
import com.zhangxing.ssm.tokenhelper.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangxing
 * @Date: 2019/4/23 0:08
 */
@Controller
@RequestMapping("/app/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseBody
    public Object addBook(@RequestBody Book book) throws Exception
    {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Object updBook(@RequestBody Book book, @PathVariable("id") String id) throws Exception
    {
        return bookService.updBook(book);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delBook(@PathVariable("id") String id) throws Exception
    {
        bookService.delBook(id);
    }

    @GetMapping("/user/{userId}")
    @ResponseBody
    public Object queryBookByUserId(@PathVariable("userId") String userId) throws Exception
    {
        return bookService.queryBookByUserId(userId);
    }

    @GetMapping
    @ResponseBody
    public Object queryBooks()
    {
        return bookService.queryBooks();
    }
}
