package org.learn.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * Created by imafan_work on 2015/10/8 0008.
 */
public class HelloController extends Controller {

    public void index() {
        renderText("Hello JFinal World.11");
    }

    public void test(){
        renderText("test");
    }

    @ActionKey("/test")
    public void test2(){
        renderText("test2");
    }

    public void jsonTest(){
       renderJson("a","1");
    }
}
