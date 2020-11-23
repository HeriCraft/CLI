package tv.nosy.cli.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tv.nosy.cli.models.LoginModel;
import tv.nosy.cli.models.RegisterModel;
import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.dao.custom.Box;
import tv.nosy.cli.models.services.custom.BoxImp;
import tv.nosy.cli.models.utilities.LoginInfo;
import tv.nosy.cli.models.utilities.RegisterSubmission;

@Controller
public class MainController {

    protected BoxImp bi;
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String getLoginPage(Model model, HttpSession session) {
        if(session.getAttribute("admin") != null){
            return "redirect:/home";
        }
        model.addAttribute("loginInfo", new LoginInfo());
        return "login";
    }
    @RequestMapping(value = {"/", "/auth"}, method = RequestMethod.POST)
    public String authentification(@ModelAttribute("loginInfo") LoginInfo info, HttpSession session){

        try{            
            Admin a = LoginModel.auth(info.getUname(), info.getPass());
            if(a != null){
                session.setAttribute("admin", a);
                return "redirect:/home";
            }
        }catch(Exception e){

        }
        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model, HttpSession session) {
        if(session.getAttribute("admin") != null){
            return "redirect:/home";
        }
        model.addAttribute("registerInfo", new RegisterSubmission());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegistrationProcess(@ModelAttribute("registerInfo") RegisterSubmission info, HttpSession session)
            throws NoSuchAlgorithmException {
        
        if(session.getAttribute("admin") != null){
            return "redirect:/home";
        }
        // Eto aloha d essais
        Admin a = new Admin();
        Cd c = new Cd();
        
        a.setMail(info.getMail());
        a.setUsername(info.getUname());
        c.setCode(info.getPass());
        
        RegisterModel.register(a, c);

        return "redirect:/";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model, HttpSession session){
        if(session.getAttribute("admin")==null){
            return "redirect:/";
        }
        model.addAttribute("admin", (Admin) session.getAttribute("admin"));
        return "home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/";
    }

}
