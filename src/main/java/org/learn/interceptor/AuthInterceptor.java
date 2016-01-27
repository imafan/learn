package org.learn.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import org.apache.commons.lang.StringUtils;
import org.learn.user.User;
import org.learn.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class AuthInterceptor implements Interceptor {


    public void intercept(Invocation invocation) {
        HttpServletRequest request = invocation.getController().getRequest();

        String path = request.getServletPath();
        boolean isAjax = false;

        Controller controller = invocation.getController();
        if(StringUtils.isNotBlank(path) && path.startsWith("/admin")){

            //判断是否ajax请求
            String header = request.getHeader("X-Requested-With");
            isAjax = "XMLHttpRequest".equalsIgnoreCase(header);

            HttpSession session = invocation.getController().getSession();
            User loginUser = (User)session.getAttribute(Constants.SESSION_LOGIN_USER);
            if(loginUser == null){
                if(!isAjax){
                    controller.redirect("/admin/login");
                }else{
                    JSONObject error = new JSONObject();
                    error.put("success",false);
                    error.put("codeMsg", "nologin");
                    controller.renderJson(error);
                }

                return;
            }
        }

        invocation.invoke();
    }
}
