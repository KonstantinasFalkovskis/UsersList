package com.example.demo.controllers;

import com.example.demo.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @GetMapping("/")
    public String showListOfUsers(Model model, @RequestParam(defaultValue = "0") int page) {
            model.addAttribute("data", usersDao.findAll(new PageRequest(page, 6)));
            model.addAttribute("currentPage", page);
        return "index";
    }




}
