package org.learn.controller;

import com.jfinal.core.Controller;

/**
 * Created by imafan on 2016/1/27 0027.
 */
public class AngularJSController extends Controller {


    public void hello(){

        renderFreeMarker("/angular_learn/hello.html");
    }
}
