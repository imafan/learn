package org.learn.handler;

import com.jfinal.handler.Handler;
import com.jfinal.render.RenderFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by imafan on 2016/1/27 0027.
 */
public class AngularJSHandler extends Handler {

    @Override
    public void handle(String target, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleans) {
        if (target.startsWith("/angular")) {
            RenderFactory.me().getFreeMarkerRender(target + ".html").setContext(httpServletRequest, httpServletResponse).render();
            booleans[0] = true;
        }else{
            nextHandler.handle(target, httpServletRequest, httpServletResponse, booleans);
        }
    }

    private String getView(String target){
        if(target == null) return target;
        return target.substring(getBeginIndex(target));
    }

    private int getBeginIndex(String url){
        if(StringUtils.isNotBlank(url)){
            String[] params = url.split("/");
            if(params.length > 1){
                return params[1].length();
            }
        }

        return 0;
    }
}
