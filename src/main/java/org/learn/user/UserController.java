package org.learn.user;

import com.jfinal.aop.Before;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.ehcache.IDataLoader;
import org.learn.base.BaseController;

import java.util.List;

/**
 * Created by imafan_work on 2015/10/10 0010.
 */
public class UserController extends BaseController {

    private UserService userService = new UserService();

    public void test() {
        renderJson("test", getPara());
    }

    @Before(CacheInterceptor.class)
//    @CacheName("userList")
    public void index() {
//        List<User> userList = userService.findAll();
//        List<User> userList = User.dao.find("select * from user");

        List<User> userList = CacheKit.get("userCache", "userList", new IDataLoader() {
            public Object load() {
                return userService.findAll();
            }
        });
        setAttr("users", userList);
        renderFront("/user/list.html");
    }

    public void addUser() {
        renderFront("/user/add.html");
    }

    public void add() {
        User user = getModel(User.class);
        boolean resutl = user.save();

        renderJson("success", resutl);
    }
}
