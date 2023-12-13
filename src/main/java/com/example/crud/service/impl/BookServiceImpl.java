package com.example.crud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.crud.dao.BookDao;
import com.example.crud.domain.Book;
import com.example.crud.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

/**
 * @author lyx
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        return bookDao.selectPage(new Page(currentPage, pageSize), null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        return bookDao.selectPage(new Page(currentPage, pageSize), lqw);
    }
}