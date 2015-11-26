package org.learn.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
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
        if(StringUtils.isNotBlank(path) && path.startsWith("/admin")){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HttpSession session = invocation.getController().getSession();
            User loginUser = (User)session.getAttribute(Constants.SESSION_LOGIN_USER);
            if(loginUser == null){
                invocation.getController().redirect("/admin/login");
                return;
            }
        }

        invocation.invoke();
    }
}
