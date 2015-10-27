package org.learn.user;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import org.learn.util.Constants;

/**
 * Created by imafan_work on 2015/10/15 0015.
 */
public class LoginValidator extends Validator {

    @Override
    protected void validate(Controller controller) {
        setShortCircuit(true);
        validateRequiredString("username", "errorMsg", "请输入用户名");
        validateRequiredString("pass", "errorMsg", "请输入密码");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepPara("username");
        controller.keepPara("pass");

//        controller.render(Constants.BACKEND_PATH + "/login.html");
        controller.renderJson();
    }
}
