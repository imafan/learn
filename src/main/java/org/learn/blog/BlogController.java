package org.learn.blog;

import com.jfinal.core.Controller;
import org.learn.base.BaseController;

/**
 * Created by imafan_work on 2015/11/5 0005.
 */
public class BlogController extends Controller {

    public void index(){
        renderFreeMarker("blog/list.html");
    }
}
