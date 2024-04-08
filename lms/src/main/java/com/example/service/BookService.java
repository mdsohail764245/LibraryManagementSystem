package com.example.service;

import com.example.controller.GenerateRandom;
import com.example.model.*;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    GenreRepo genreRepo;
    @Autowired
    PublicationRepo publicationRepo;
    @Autowired
    AuthorsRepo authorsRepo;
    @Autowired
    BookAuthorsMapRepo bookAuthorsMapRepo;

    public  List<Books> getAllBooks() {
        return booksRepo.findAll();
    }

    public Books addBook(Books bd) {
        UUID book_id= UUID.randomUUID();
        UUID genre_id=UUID.randomUUID();
        UUID public_id=UUID.randomUUID();
        UUID author_id= UUID.randomUUID();
        bd.setBook_id(book_id);
        String genre_name=bd.getGenres().getGenre_name();
        Genres genre=genreRepo.findByGenreName(genre_name);
        System.out.println(genre);
        if(genre==null){
            bd.getGenres().setGenre_id(genre_id);
        }
        else {
            Genres genres=new Genres(genre.getGenre_id(),genre_name);
            bd.setGenres(genres);
        }
        Publishers p=publicationRepo.findByPublisherName(bd.getPublishers().getName());
        if(p==null){
            bd.getPublishers().setPublic_id(public_id);
        }
        else {
            Publishers publishers=new Publishers(p.getPublic_id(),bd.getPublishers().getName());
            bd.setPublishers(publishers);
        }

        System.out.println(bd);
        Books sb=booksRepo.save(bd);

        Authors check=authorsRepo.findByAuthorName(bd.getAuthor());
        BookAuthorsMap bookAuthorsMap=new BookAuthorsMap();
        if(check==null){
            Authors authors=new Authors(author_id,bd.getAuthor());
            Authors sa=authorsRepo.save(authors);
            bookAuthorsMap.setAuthors(sa);
            bookAuthorsMap.setBooks(sb);
            bookAuthorsMapRepo.save(bookAuthorsMap);
        }
        else{
            bookAuthorsMap.setAuthors(check);
            bookAuthorsMap.setBooks(sb);
            bookAuthorsMapRepo.save(bookAuthorsMap);
        }

        return bd;



    }
}
