package org.learn.blog;

import com.jfinal.plugin.activerecord.Page;
import org.learn.base.BaseService;

/**
 * Created by imafan_work on 2015/11/6 0006.
 */
public class BlogService extends BaseService<Blog> {

    public Page<Blog> findByPage(int page, int pageSize, boolean orderBy){
        String sql = "from " + wrap(tableName) + "where status != -1"  + (orderBy ? " order by createTime desc" : "");
        return  Blog.dao.paginate(page, pageSize, "select *",  sql);
    }
}
