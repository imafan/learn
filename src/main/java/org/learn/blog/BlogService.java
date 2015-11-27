package org.learn.blog;

import com.jfinal.plugin.activerecord.Page;
import org.learn.base.BaseService;
import org.learn.user.UserService;

/**
 * Created by imafan_work on 2015/11/6 0006.
 */
public class BlogService extends BaseService<Blog> {

    private static class SingletonHolder{
        private static final BlogService INSTANCE = new BlogService();
    }

    public static final BlogService getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public Page<Blog> findByPage(int page, int pageSize, boolean orderBy){
        StringBuffer sb = new StringBuffer();
        sb.append("from " + getInstance().getTableName() + " a");
        sb.append(" left join " + UserService.getInstance().getTableName() + " b on a.userId = b.id");
        sb.append(" where a.status != -1 "  + (orderBy ? " order by a.createTime desc" : ""));
        System.out.println(sb.toString());
        return  Blog.dao.paginate(page, pageSize, "select a.*,b.name as userName",  sb.toString());
    }
}
