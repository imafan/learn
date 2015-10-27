package org.learn.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import org.apache.commons.lang.StringUtils;
import org.learn.annotation.Table;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by imafan_work on 2015/10/16 0016.
 */
public abstract class BaseService<T extends Model> {

    protected String tableName;
    protected Class<T> entityClass;
    protected Object obj;

    public BaseService() {
        entityClass =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Table table = entityClass.getAnnotation(Table.class);
        if (table != null && StringUtils.isNotBlank(table.tableName()))
        {
            tableName = table.tableName();
        }
        else
        {
            tableName = entityClass.getSimpleName();
        }
        System.out.println("tableName:" + tableName);
    }

    public List<T> findAll() {
        try{
            Method method = entityClass.getMethod("find",String.class);
            return (List<T>)method.invoke(getEntityInstance(),"select * from " + wrap(tableName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Page<T> findByPage(int page, int pageSize){
        try{
            Method method = entityClass.getMethod("paginate",int.class,int.class,String.class,String.class);
            return (Page<T>)method.invoke(getEntityInstance(),page,pageSize,"select *","from " + wrap(tableName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

//    public Serializable save(T model){
//        if(model != null){
//            model.save();
//            return  model.getStr("id");
//        }
//
//        return -1;
//    }
//
//    public boolean update(T model){
//        if(model != null){
//            return model.update();
//        }
//        return false;
//    }
//
//    public boolean deleteById(Serializable id){
//        return Db.deleteById(tableName,id);
//    }


    private Object getEntityInstance() throws Exception{
        if(obj == null){
            obj = entityClass.newInstance();
        }

        return obj;
    }

    private String wrap(String name) {
        return "`" + name + "`";
    }
}
