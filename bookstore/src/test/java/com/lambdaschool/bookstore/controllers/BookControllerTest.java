package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.services.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
//**********
// Note security is handled at the controller, hence we do not need to worry about security here!
//**********
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;
//
//    @Autowired
//    private SectionService sectionService;


    @Before
    public void setUp() throws
            Exception {
        MockitoAnnotations.initMocks(this);
        List<Book> myList = bookService.findAll();
        for (Book b : myList) {
            System.out.println(b.getBookid() + " " + b.getTitle());
        }

        @After
        public void tearDown ()
        Exception {
        }

        @Test
        public void findAll ()
    {
            assertEquals(5, bookService.findAll().size());
        }


        @Test
        public void findBookById ()
    {
            assertEquals("test Digital Fortess", bookService.findBookById(27).getTitle());
        }

        @Test(expected = ResourceNotFoundException.class)
        public void notFindBookById ()
    {
            assertEquals("test Digital Fortess", bookService.findBookById(37).getTitle());
        }

        @Test
        public void delete ()
    {
            bookService.delete(30);
            assertEquals(4, bookService.findAll().size());
        }

        @Test
        public void save ()
    {
            Book b2;
            bookService.save(b2);
            Book addBook = bookService.save(b2);
            assertNotNull(addBook);
            assertEquals(addBook.getTitle(), addBook.getTitle());
        }

        @Test
        public void deleteAll ()
        {
            bookService.deleteAll();
            assertEquals(0, bookService.findAll().size());
        }
    }
}
