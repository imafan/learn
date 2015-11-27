package org.learn.blog;

import cn.dreampie.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by imafan_work on 2015/11/6 0006.
 */
@TableBind(tableName = "t_blog")
public class Blog extends Model<Blog> {
    public static final Blog dao = new Blog();


}
