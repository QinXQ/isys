package com.qin.isys.modules.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Q on 2017/2/18.
 */
@Controller
@RequestMapping(value = {"{userName}"})
public class UserController {

    @RequestMapping(value = {"center"},method = RequestMethod.GET)
    public String personalCenter(@PathVariable("userName") String userName){
        System.out.println("to "+userName+"'s personal page.");
        return "user/personalCenter";
    }
}
