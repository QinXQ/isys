package com.qin.isys.modules.user.web;

import com.qin.isys.global.Constant;
import com.qin.isys.global.Util;
import com.qin.isys.modules.base.web.BaseController;
import com.qin.isys.modules.user.entity.User;
import com.qin.isys.modules.user.exception.JustWantException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Q on 2017/2/19.
 */
@Controller
public class VisitorController extends BaseController{

    @RequestMapping(value = "signin",method = RequestMethod.GET)
    public String toSignInPage(){
        //this page will Sign in,return last visited page.
        return "visitor/signIn";
    }

    @RequestMapping(value = "signin",method = RequestMethod.POST)
    public String signIn(){
        return "";
    }

    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String toSignUpPage(){
        //this page will Sign up and sign in,return last visited page.
        return "visitor/signUp";
    }

    @RequestMapping(value = "signup",method = RequestMethod.POST)
    public String signUp(String username, String password, HttpServletRequest request, RedirectAttributes model){
        request.getSession().setAttribute("username",username);
        System.out.println("{username:"+username+",password:"+password+"}");
        model.addFlashAttribute("list",new ArrayList<String>());
        return "redirect:welcome";
    }

    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String toWelcomePage(Model model){
        Boolean f=model.containsAttribute("list");
        Object o = model.asMap().get("list");
        return "welcome";
    }


    @RequestMapping(value = "test")
    @ResponseBody
    public Result test(){
        Result result=new Result(State.OK,new User(),"you'll see this line if there have no problem occurred.");
        System.out.println(result.getState());
        return result;
    }

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestPart("file") MultipartFile[] files, HttpServletRequest request){
        try {
            for(MultipartFile file:files){
                File target=new File(Math.round(Math.random()*100000)+file.getOriginalFilename());
                file.transferTo(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result();
    }


    /**
     * throw exception and forward to page 'stopAndLook'.
     */
    @RequestMapping(value = "soLong",method = RequestMethod.GET)
    @ResponseBody
    public Result soLong(){
        throw new JustWantException();
    }
}
