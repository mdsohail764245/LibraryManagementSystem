package com.example.service;

import com.example.model.ExceptionResponse;
import com.example.model.Members;
import com.example.repo.MembersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    MembersRepo membersRepo;

    public Members addMember(Members members) {
        UUID id=UUID.randomUUID();
        members.setMember_id(id);
        membersRepo.save(members);
        return members;
    }

    public List<Members> getAllUsers() {
        try{
            List<Members> li=membersRepo.findAll();
            return li;
        }
        catch (Exception e){
            ExceptionResponse er=new ExceptionResponse("no members found","lms404");
            System.out.println(er);
            return null;
        }


    }
}
