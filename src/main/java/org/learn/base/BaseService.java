package org.learn.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import org.apache.commons.lang.StringUtils;
import org.learn.annotation.Table;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by imafan_work on 2015/10/16 0016.
 */
public abstract class BaseService<T extends Model> {

    protected String tableName;
    protected Class<T> entityClass;
    protected T obj;


    public BaseService(){
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

    public List<T> findAll(){
        try{
            return (List<T>)getEntityInstance().find("select * from " + wrap(tableName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Page<T> findByPage(int page, int pageSize){
        try{
            return (Page<T>)getEntityInstance().paginate(page,pageSize,"select *","from " + wrap(tableName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public T findById(Serializable id){
        try{
           return (T)getEntityInstance().findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private T getEntityInstance() throws Exception{
        if(obj == null){
            obj = entityClass.newInstance();
        }

        return obj;
    }

    protected String wrap(String name) {
        return "`" + name + "`";
    }
}
