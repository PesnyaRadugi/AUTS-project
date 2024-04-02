package ua.auts.project.AutsProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ua.auts.project.AutsProject.models.User;
import ua.auts.project.AutsProject.repo.UserRepository;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("about")
    public String viewAboutPage(Model model) {
        model.addAttribute("title", "About Auts");
        return "about";
    }

    @GetMapping("signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @GetMapping("login")
    public String showLoginForm(Model model) {
        return "login_form";
    }

    @PostMapping("process_reg")
    public String processSignUp(User user) {
        userRepository.save(user);

        return "reg_succes";
    }
}
