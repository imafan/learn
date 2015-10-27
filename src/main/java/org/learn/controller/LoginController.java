package org.learn.controller;

import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class LoginController extends Controller {


    @Clear
    public void index(){
        System.out.println("login");
        renderFreeMarker("/login.html");
    }
}
