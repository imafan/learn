package org.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import org.learn.user.LoginValidator;
import org.learn.user.User;
import org.learn.util.Constants;

/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class IndexBackendController extends Controller {

    public void index(){
        renderFreeMarker("index.html");
    }

    @Clear
    public void login(){
        renderFreeMarker("login.html");
    }

    @Clear
    @Before(LoginValidator.class)
    public void doLogin(){
        String username = getPara("username");
        String pass = getPara("pass");
        if( "admin".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(pass)){
            User user = new User();
            user.set("name",username);
            setSessionAttr(Constants.SESSION_LOGIN_USER,user);
            renderJson("success",true);
        }else{
            JSONObject error = new JSONObject();
            error.put("errorMsg","账号密码不正确");
            error.put("success",false);
            renderJson(error);
        }
    }

    public void logout(){
        setSessionAttr(Constants.SESSION_LOGIN_USER,null);
        redirect("/admin/login");
    }


}
