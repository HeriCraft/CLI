package tv.nosy.cli.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tv.nosy.cli.models.LoginModel;
import tv.nosy.cli.models.RegisterModel;
import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.utilities.LoginInfo;
import tv.nosy.cli.models.utilities.RegisterSubmission;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        model.addAttribute("loginInfo", new LoginInfo());
        return "login";
    }
    @RequestMapping(value = {"/", "/auth"}, method = RequestMethod.POST)
    public String authentification(@ModelAttribute("loginInfo") LoginInfo info){
        try{
            System.out.println("************************************************************");
            System.out.println("Getting Admin");
            System.out.println("************************************************************");
            
            Admin a = LoginModel.auth(info.getUname(), info.getPass());
            if(a != null){
                System.out.println("==================================");
                System.out.println(a.getMail());
                System.out.println(a.getUsername());
                System.out.println("Loggin Mety");
                System.out.println("==================================");
                return "redirect:/home";
            }
        }catch(Exception e){

        }
        return "redirect:/";
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
