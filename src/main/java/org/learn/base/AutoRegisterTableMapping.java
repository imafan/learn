package org.learn.base;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import org.apache.commons.lang.StringUtils;
import org.learn.annotation.Table;
import org.learn.util.ClassScanUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by imafan_work on 2015/10/19 0019.
 */
public class AutoRegisterTableMapping {

    protected static final Logger LOG = Logger.getLogger(AutoRegisterTableMapping.class);

    public static final AutoRegisterTableMapping me = new AutoRegisterTableMapping();

    private ActiveRecordPlugin arp;

    private AutoRegisterTableMapping() {
    }

    public AutoRegisterTableMapping setArp(ActiveRecordPlugin arp) {
        this.arp = arp;
        return this;
    }

    public void doScan(){
        try{
            String packname = this.getClass().getPackage().getName();
            Set<Class<?>> classes = ClassScanUtil.doScanPackage(packname.substring(0, packname.lastIndexOf(".")));
            Iterator<Class<?>> iterator = classes.iterator();
            while (iterator.hasNext()){
                register(iterator.next());
            }
        }catch (Exception e){
            LOG.error("自动扫描table失败");
            e.printStackTrace();
        }

    }

    public void register(Class modelClazz) throws Exception{
        Annotation anno = modelClazz.getAnnotation(Table.class);
        if(anno != null){
            Method method = anno.getClass().getMethod("tableName", null);
            String tablename = (String) method.invoke(anno);
            method = anno.getClass().getMethod("pkName", null);
            String pk = (String)method.invoke(anno);
            if(arp != null){
                if(StringUtils.isBlank(pk)){
                    arp.addMapping(tablename,modelClazz);
                }else{
                    arp.addMapping(tablename,pk,modelClazz);
                }
            }
        }
    }




//    public static void main(String[] args) {
//        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
//        findAndAddClassesInPackageByFile("core","org.cqh.jfinal.core",true,classes);
//        Iterator<Class<?>> it = classes.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next().getSimpleName());
//        }
//    }
}
