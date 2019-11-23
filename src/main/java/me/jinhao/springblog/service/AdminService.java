package me.jinhao.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.jinhao.springblog.model.Admin;
import me.jinhao.springblog.model.AdminRepository;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public boolean isEmpty(){
        if(adminRepository.count() == 0){
            return true;
        }else return false;
    }

    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }
}