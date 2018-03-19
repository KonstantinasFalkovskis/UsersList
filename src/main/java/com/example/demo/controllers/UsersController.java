/**
 * @Author Falco Constantine
 * @Project Users list
 * @Version 1.0
 * @Date 2018.03.17
 *
 */
package com.example.demo.controllers;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    //suite to the repository Jpa;
    @Autowired
    private UsersDao usersDao;

    //method for users list viewing + pagination. Default is 6 items per page;
    @GetMapping("/")
    public String showListOfUsers(Model model, @RequestParam(defaultValue = "0") int page) {
            model.addAttribute("data", usersDao.findAll(new PageRequest(page, 6)));
            model.addAttribute("currentPage", page);
        return "return:/";
    }

    //method persist() for save item to Jpa virtual data base;
    @PostMapping("/save")
    public String persist(User users) {
        usersDao.save(users);
        return "redirect:/";
    }

    //method update for find & edit item by item Id;
    @RequestMapping("/edit/{id}")
    public String update(Integer id) {
        usersDao.findById(id);
        return "redirect:/";
    }

    //methode delete for removing item from Jpa data base. Item finding implements also by item id;
    @RequestMapping("/delete/{id}")
    public String delete(Integer id) {
        usersDao.deleteById(id);
        return "redirect:/";
    }

}
