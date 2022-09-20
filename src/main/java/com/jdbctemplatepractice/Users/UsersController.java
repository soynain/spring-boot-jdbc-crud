package com.jdbctemplatepractice.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView view=new ModelAndView("login-view");
        return view;
    }

    @GetMapping("/users/home")
    public ModelAndView getCrudLandingPage(){
        ModelAndView landingPageObj=new ModelAndView("dashboard-view");
        landingPageObj.addObject("listaUsuarios", usersService.getUsers());
        return landingPageObj;
    }
    
}
