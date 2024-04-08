package com.example.controller;

import com.example.model.*;
import com.example.repo.AuthorsRepo;
import com.example.repo.GenreRepo;
import com.example.repo.PublicationRepo;
import com.example.service.BookService;
import com.example.service.BookRequestService;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("library")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    MemberService memberService;
    @Autowired
    BookRequestService bookRequestService;
    @Autowired
    AuthorsRepo authorsRepo;
    @Autowired
    PublicationRepo publicationRepo;
    @Autowired
    GenreRepo genreRepo;

    @PostMapping("book")
    public Books addBook(@RequestBody Books bookDetails){
        return bookService.addBook(bookDetails);
    }
    @GetMapping("book")
    public List<Books> getAllBooks(){

        List<Books> li= bookService.getAllBooks();
        if(li.isEmpty()){
            return null;
        }
        return li;
    }
    @PostMapping("user")
    public Members addMember(@RequestBody Members members){

        return memberService.addMember(members);
    }
    @GetMapping("user")
    public List<Members> getAllUsers(){
        return memberService.getAllUsers();
    }
    @PostMapping("bookrequest")
    public Transactions getBook(@RequestBody BookRequest br){
        return bookRequestService.getBook(br);
    }
    @GetMapping("requests")
    public List<Transactions> getAllTransactions(){
        return bookRequestService.getAllTransactions();
    }
    @GetMapping("authors")
    public List<Authors> getAllAuthors(){
        return authorsRepo.findAll();
    }
    @GetMapping("publishers")
    public List<Publishers> getAllPublishers(){
        return publicationRepo.findAll();
    }
    @GetMapping("requests/users")
    public List<Transactions> getTransactionByUser(@RequestParam UUID id){
        //UUID Id=UUID.fromString(id);
        return bookRequestService.getTransactionByUser(id);
    }
    @GetMapping("requests/books")
    public List<Transactions> getTransactionByBook(@RequestParam UUID id){
        return bookRequestService.getTransactionByBook(id);
    }
    @GetMapping("genres")
    public List<Genres> getAllGenres(){
        return genreRepo.findAll();
    }



}
