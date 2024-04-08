package com.example.service;

import com.example.controller.GenerateRandom;
import com.example.model.Books;
import com.example.model.BookRequest;
import com.example.model.Members;
import com.example.model.Transactions;
import com.example.repo.BooksRepo;
import com.example.repo.MembersRepo;
import com.example.repo.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookRequestService {

    @Autowired
    BooksRepo booksRepo;
    @Autowired
    MembersRepo membersRepo;
    @Autowired
    TransactionsRepo transactionsRepo;

    public Transactions getBook(BookRequest br) {

        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusWeeks(2);
        System.out.println(br);
        Optional<Books> books=booksRepo.findById(br.getBook_id());
        Optional<Members> members=membersRepo.findById(br.getMember_id());
        int quant=books.get().getQuantity();
        String type=br.getTrans_type();
        if(type.equals("borrow") && quant>0){
            UUID tid=UUID.randomUUID();
            Transactions transactions=new Transactions(tid,books.get(),members.get(), br.getTrans_type(), dueDate,null);
            transactionsRepo.save(transactions);
            quant-=1;
            books.get().setQuantity(quant);
            booksRepo.save(books.get());
            return transactions;
        }
        else{
            UUID tid=UUID.randomUUID();
            Transactions transactions=new Transactions(tid,books.get(),members.get(), br.getTrans_type(), dueDate,currentDate);
            transactionsRepo.save(transactions);
            quant+=1;
            books.get().setQuantity(quant);
            booksRepo.save(books.get());
            return transactions;
//
//            Transactions transactions = transactionsRepo.findByBookIdAndMemId(br.getBook_id(), br.getMember_id());
//            transactions.setReturn_date(currentDate);
//            transactionsRepo.save(transactions);
        }

    }

    public List<Transactions> getAllTransactions() {
        return transactionsRepo.findAll();
    }

    public List<Transactions> getTransactionByUser(UUID id) {
        List<Transactions> li= transactionsRepo.findByUserId(id);
        if(li.isEmpty()){
            return null;
        }
        return li;
    }

    public List<Transactions> getTransactionByBook(UUID id) {
        List<Transactions> li=transactionsRepo.findByBookId(id);
        if(li.isEmpty()){
            return null;
        }
        return li;
    }
}
