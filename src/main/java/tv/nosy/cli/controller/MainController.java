package tv.nosy.cli.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tv.nosy.cli.models.RegisterModel;
import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.dao.HL;
import tv.nosy.cli.models.utilities.RegisterSubmission;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("registerInfo", new RegisterSubmission());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegistrationProcess(@ModelAttribute("registerInfo") RegisterSubmission info)
            throws NoSuchAlgorithmException {

        // Eto aloha d essais
        Admin a = new Admin();
        Cd c = new Cd();
        
        a.setMail(info.getMail());
        a.setUsername(info.getUname());
        c.setCode(info.getPass());
        
        RegisterModel.register(a, c);

        return "redirect:/";
    }
}
