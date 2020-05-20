package com.demo.controller;

import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 *
 * @author biubiu
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView toIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("users", userService.findAll());
        return mv;
    }
}
