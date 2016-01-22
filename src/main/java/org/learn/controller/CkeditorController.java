package org.learn.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

/**
 * Created by imafan_work on 2016/1/22 0022.
 */
public class CkeditorController extends Controller {

    public void uploadImage(){

        String callback = getPara("CKEditorFuncNum");
        UploadFile files = getFile("upload","/_images/ckeditor");

        String html = "<script type=\"text/javascript\"> window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + "img/postImg/test.png" +  "','')";
        render(html);

    }
}
