package tv.nosy.cli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tv.nosy.cli.models.utilities.RegisterSubmission;

@Controller
public class MainController {
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String getLoginPage(){
        return "login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model){
        model.addAttribute("registerInfo", new RegisterSubmission());
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegistrationProcess(@ModelAttribute("registerInfo") RegisterSubmission info){



        return "redirect:/";
    }
}
