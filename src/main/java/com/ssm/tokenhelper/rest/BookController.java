package com.ssm.tokenhelper.rest;

import com.fasterxml.jackson.databind.node.TextNode;
import com.ssm.tokenhelper.business.inf.BookService;
import com.ssm.tokenhelper.model.Book;
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
        System.out.println("-----start addBook-------");
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Object updBook(@RequestBody Book book, @PathVariable("id") String id) throws Exception
    {
        System.out.println("-----start updBook-------");
        return bookService.updBook(id, book);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Object delBook(@PathVariable("id") String id) throws Exception
    {
        System.out.println("-----start delBook-------");
        bookService.delBook(id);
        return new TextNode("Delete Success.");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object queryBookById(@PathVariable("id") String id) throws Exception
    {
        System.out.println("-----start queryBookById-------");
        return bookService.queryBookById(id);
    }

    @GetMapping
    @ResponseBody
    public Object queryBooks()
    {
        System.out.println("-----start queryBooks-------");
        return bookService.queryBooks();
    }
}
