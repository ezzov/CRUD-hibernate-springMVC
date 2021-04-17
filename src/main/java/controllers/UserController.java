package controllers;

import dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserDAOImpl userDAO;

    @Autowired
    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userDAO.getAllUsers());
        return "users/allusers";
    }

    @GetMapping("user/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDAO.getUser(id));
        return "users/user";
    }
}
