package com.example.zoo.mvc;


import com.example.zoo.repos.adminRep;
import com.example.zoo.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.admin;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class adminController {
    private final adminRep adminRep;
    private final adminService adminService;

    @Autowired
    public adminController(adminService adminService, adminRep adminRep) {
        this.adminService = adminService;
        this.adminRep = adminRep;
    }

    @GetMapping("/getall")
    public List<admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    @GetMapping("/{id}")
    public admin getAdmin(@PathVariable Integer id) {
        return adminService.getAdmin(id);
    }

    @PostMapping("")
    public void createAdmin(@RequestBody admin admin) {
        adminService.updateAdmin(admin);
    }

    @PutMapping("")
    public void updateAdmin(@RequestBody admin admin) {
        adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
    }
}

