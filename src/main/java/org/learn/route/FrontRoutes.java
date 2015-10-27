package org.learn.route;

import com.jfinal.config.Routes;
import org.learn.controller.IndexController;
import org.learn.controller.LoginController;
import org.learn.user.UserController;


/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class FrontRoutes extends Routes{

    public void config() {
        add("/", IndexController.class);
        add("/user", UserController.class);
        add("/login", LoginController.class);
    }
}
