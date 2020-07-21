package com.Sandar.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends AdminBaseController{
	
    @RequestMapping("/home")
    public ModelAndView index(ModelMap model) {
    	 
        return new ModelAndView("home", model);
    }
   
    
    @RequestMapping("/testView")
    public ModelAndView testView() {
        return new ModelAndView("test");
    }
    
    @RequestMapping("/login")
    public ModelAndView login(Model model) {
    	model.addAttribute("name","Sandar Linn");
        return new ModelAndView("loginPage");
    }
    
    @PostMapping("/handleLogin")
    public String loginSubmit(HttpSession session, ModelMap model) {
      return "redirect:/dashboard";
    }
    
    @RequestMapping(value="/dashboard",method = RequestMethod.GET)
    public ModelAndView dashboard(HttpServletRequest request) {
    	 return new ModelAndView("dashboard");
    }
    
    @RequestMapping(value="/adminLayout",method = RequestMethod.GET)
    public ModelAndView adminLayout() {
    	 return new ModelAndView("adminLayout");
    }
    
   
    
}
