package org.learn.user;

import cn.dreampie.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import org.learn.annotation.Table;

/**
 * Created by imafan_work on 2015/10/10 0010.
 */
//@Table(tableName = "user")
@TableBind(tableName = "user")
public class User extends Model<User> {
    public static final User dao = new User();

    public User getDao(){
        return dao;
    }
}
