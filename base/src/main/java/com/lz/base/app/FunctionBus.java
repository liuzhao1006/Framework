package com.lz.base.app;

import android.widget.Toast;

import com.lz.base.exception.LzException;
import com.lz.base.factory.ContextFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午8:49
 * 描述     :
 */
public class FunctionBus {

    /**
     * 方法总线，缓存的map
     */
    public static Map<Class, Object> sFunctionBus = new HashMap<>();


    /**
     * 设置方法接口的实现
     * @param o
     */
    public static void setFunction(Object o){
        Class[] interfaces = o.getClass().getInterfaces();
        for (Class c :
                interfaces) {
            if (sFunctionBus.containsKey(c)){
                throw new LzException("duplicate set function:" + c.getName());
            }
            sFunctionBus.put(c,o);
        }
    }


    /**
     * 获取方法的实现类
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T getFunction(Class<T> c){
        T f = (T)sFunctionBus.get(c);
        if(f == null){
            Toast.makeText(ContextFactory.get(),"you have not register function:" + c.getName(), Toast.LENGTH_SHORT).show();
            return null;
        }
        return f;
    }
}
