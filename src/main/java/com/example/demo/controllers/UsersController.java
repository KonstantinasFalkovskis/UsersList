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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UsersController {

    //suite to the repository Jpa;
    @Autowired
    private UsersDao usersDao;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    //method for users list viewing + pagination. Default is 6 items per page;
    @GetMapping("/")
    public String showListOfUsers(Model model, @RequestParam(defaultValue = "0") int page) {
            model.addAttribute("data", usersDao.findAll(new PageRequest(page, 6)));
            model.addAttribute("currentPage", page);
        return "index";
    }

    //method persist() for save item to Jpa virtual data base;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User users) {
        usersDao.save(users);
        logger.info("New user was created " + users);
        return "redirect:/";
    }

    //method update for find & edit item by item Id;
    @GetMapping("/edit")
    @ResponseBody
    public Optional<User> update(Integer id) {
        logger.info("User has been updated. Users id: " + id);
        return usersDao.findById(id);
    }

    //methode delete for removing item from Jpa data base. Item finding implements also by item id;
    @GetMapping("/delete")
    public String delete(Integer id) {
        usersDao.deleteById(id);
        logger.info("User has been removed. Users id: " + id);
        return "redirect:/";
    }

}
