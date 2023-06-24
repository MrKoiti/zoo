package com.example.zoo.service;

import com.example.zoo.repos.adminRep;
import com.example.zoo.models.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class adminService {
    private final adminRep adminRep;

    @Autowired
    public adminService(adminRep adminRep) {
        this.adminRep = adminRep;
    }

    public List<admin> getAllAdmin() {
        List<admin> admin = new ArrayList<>();
        adminRep.findAll().forEach(admin::add);
        return admin;
    }

    public admin getAdmin(Integer id) {
        return adminRep.findById(id).orElse(null);
    }

    public void addAdmin(admin admin) {
        adminRep.save(admin);
    }

    public void updateAdmin(admin admin) {
        adminRep.save(admin);
    }

    public void deleteAdmin(Integer id) {
        adminRep.deleteById(id);
    }
}
