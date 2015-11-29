package org.learn.controller;

import com.jfinal.core.Controller;

/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class IndexController extends Controller {

    public void index(){
        render("index.html");
    }

    public void learn_1(){
        render("learn_1.html");
    }

    public void learn_2(){
        render("learn_2.html");
    }
}
