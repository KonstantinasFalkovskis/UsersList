package com.example.demo.controllers;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @GetMapping("/")
    public String showListOfUsers(Model model, @RequestParam(defaultValue = "0") int page) {
            model.addAttribute("data", usersDao.findAll(new PageRequest(page, 6)));
            model.addAttribute("currentPage", page);
        return "return:/";
    }

    @PostMapping("/save")
    public String persist(User users) {
        usersDao.save(users);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String update(Integer id) {
        usersDao.findById(id);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Integer id) {
        usersDao.deleteById(id);
        return "redirect:/";
    }

}
