package org.learn.blog;

import com.jfinal.core.Controller;
import org.learn.base.BaseController;
import org.learn.user.User;

import java.util.List;

/**
 * Created by imafan_work on 2015/11/5 0005.
 */
public class BlogController extends Controller {

    private BlogService blogService = new BlogService();

    public void index(){

        List<Blog> list = blogService.findAll();

        setAttr("blogs", list);

        renderFreeMarker("blog/list.html");
    }

    public void addBlog() {
        renderFreeMarker("blog/add.html");
    }

    public void add() {
        renderJson("success", true);
    }
}
