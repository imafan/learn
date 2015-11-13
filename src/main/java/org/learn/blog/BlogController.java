package org.learn.blog;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import org.learn.base.BaseController;
import org.learn.user.User;
import org.learn.util.Constants;

import java.util.Date;
import java.util.List;

/**
 * Created by imafan_work on 2015/11/5 0005.
 */
public class BlogController extends BaseController {

    private BlogService blogService = new BlogService();

    public void index(){

        int page = getParaToInt("page", 0);
        int pageSize = getParaToInt("pageSize", 0);

        if(page <= 0){
            page = DEFAULT_PAGE;
        }
        if(pageSize <= 0){
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<Blog> list = blogService.findByPage(page, pageSize , true);

        setAttr("blogs", list);

        renderFreeMarker("blog/list.html");
    }

    public void addBlog() {
        renderFreeMarker("blog/add.html");
    }

    public void add() {
        Blog blog = getModel(Blog.class);

        User loginUser = getSessionAttr(Constants.SESSION_LOGIN_USER);
        blog.set("userId",loginUser.get("id"));
        blog.set("createTime",new Date());

        blog.save();
        renderJson("success", true);
    }

    public void editBlog(){
        String blogId = getPara("blogId");
        Blog blog = blogService.findById(blogId);
        setAttr("blog",blog);
        renderFreeMarker("blog/edit.html");
    }

    public void edit(){
        Blog blog = getModel(Blog.class);

        blog.update();
        renderJson("success", true);

    }

    public void detail(){

        String blogId = getPara("blogId");
        Blog blog = blogService.findById(blogId);
        setAttr("blog",blog);
        renderFreeMarker("blog/detail.html");
    }

    public void del(){
        String blogId = getPara("blogId");
        Blog blog = blogService.findById(blogId);
        if(blog != null){
            blog.delete();
            setAttr("success",true);
        }else{
            setAttr("success",false);
            setAttr("errorMsg","找不到该数据");
        }

        renderJson();
    }
}
