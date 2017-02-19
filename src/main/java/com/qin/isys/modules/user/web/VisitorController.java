package com.qin.isys.modules.user.web;

import com.qin.isys.modules.base.web.BaseController;
import com.qin.isys.modules.user.entity.User;
import com.qin.isys.modules.user.exception.JustWantException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    public String signUp(String username, String password, HttpServletRequest request){
        request.getSession().setAttribute("username",username);
        System.out.println("{username:"+username+",password:"+password+"}");
        return "redirect:welcome";
    }

    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String toWelcomePage(){
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
    public Result upload(@RequestPart("file")MultipartFile file){

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
