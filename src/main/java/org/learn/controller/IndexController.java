package org.learn.controller;

import com.jfinal.core.Controller;

/**
 * Created by imafan_work on 2015/10/9 0009.
 */
public class IndexController extends Controller {

    public void index(){
        render("index.html");
    }
}
