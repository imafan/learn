package org.learn.route;

import com.jfinal.config.Routes;
import org.learn.controller.IndexBackendController;
import org.learn.user.UserController;
import org.learn.util.Constants;


/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class BackendRoutes extends Routes{

    public void config() {
        add("/admin", IndexBackendController.class , Constants.BACKEND_PATH);
        add("/admin/user", UserController.class , Constants.BACKEND_PATH);
    }
}
