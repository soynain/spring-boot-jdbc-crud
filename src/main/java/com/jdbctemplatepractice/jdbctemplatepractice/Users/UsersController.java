package com.jdbctemplatepractice.jdbctemplatepractice.Users;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jdbctemplatepractice.jdbctemplatepractice.Login.LoginForm;
import com.jdbctemplatepractice.jdbctemplatepractice.Login.LoginFormServiceImpl;

@Controller
public class UsersController {
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    UsersService usersService;
    @Autowired
    LoginFormServiceImpl loginFormServiceImpl;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView view = new ModelAndView("loginview");
        view.addObject("loginCredentials", new LoginForm());
        return view;
    }

    @GetMapping("/users/home")
    public ModelAndView getCrudLandingPage() {
        ModelAndView landingPageObj = new ModelAndView("dashboard-view");
        landingPageObj.addObject("listaUsuarios", usersService.getUsers());
        return landingPageObj;
    }

    @PostMapping("/users/login")
    public RedirectView loginPost(@ModelAttribute LoginForm loginCredentials,HttpServletRequest request) {
        RedirectView redirect = new RedirectView();
        log.info(loginCredentials.toString());
        try{
            LoginForm credentialsInDatabase = loginFormServiceImpl.getCredentials(
                loginCredentials.getUsername(),
                loginCredentials.getPassword()
            );
            request.getSession().setAttribute("ID_USER", loginCredentials.getUsername());
            redirect.setUrl("/users/home");
        }catch(Exception e){
            e.printStackTrace();
            redirect.setUrl("/login");
        }        
        return redirect;
    }

    @GetMapping("/users/new")
    public ModelAndView saveNewUser(){
       ModelAndView editView=new ModelAndView("save-data");
       editView.addObject("userEntity",new UsersEntity());
       return editView;
    }

    @PostMapping(path="/users/new/save",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public RedirectView saveNewUser(@RequestParam("file") MultipartFile file, @ModelAttribute UsersEntity usersEntity){
        log.info(file.getOriginalFilename());
        RedirectView backToHome=new RedirectView();
        backToHome.setUrl("/users/home");
        usersEntity.setId_file_credential(file.getOriginalFilename());
        int saveUserStatus=usersService.saveUser(usersEntity);
        return backToHome;
    }

    @GetMapping("/users/edit/{id}")
    public ModelAndView editUser(@PathVariable int id){
       ModelAndView editView=new ModelAndView("edit-data");
       editView.addObject("id",id);
       editView.addObject("userEntity",new UsersEntity());
       return editView;
    }

    @PostMapping("/users/edit/save/{id}")
    public RedirectView saveUpdatedUser(@RequestBody MultipartFile file,@PathVariable int id, @ModelAttribute UsersEntity userEntity){
        log.info(file.getOriginalFilename());
        RedirectView backToHome=new RedirectView();
        backToHome.setUrl("/users/home");
        userEntity.setId_file_credential(file.getOriginalFilename());
        int statusSave=usersService.updateUser(userEntity, id);
        return backToHome;
    }

    @GetMapping("/users/delete/{id}")
    public RedirectView deleteUser(@PathVariable int id){
        RedirectView backToHome = new RedirectView();
        int statusDelete=usersService.deleteUser(id);
        backToHome.setUrl("/users/home");
        return backToHome;
    }

}
