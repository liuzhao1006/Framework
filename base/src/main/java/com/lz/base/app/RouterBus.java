package com.lz.base.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;

import com.lz.base.BuildConfig;
import com.lz.base.annotation.RouterParam;
import com.lz.base.annotation.RouterUri;
import com.lz.base.exception.LzException;
import com.lz.base.factory.ContextFactory;
import com.lz.base.factory.GsonFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午2:31
 * 描述     :
 */
public class RouterBus {

    //静态map存储代理接口的实例
    private static HashMap<Class, Object> sRounterMap = new HashMap<>();

    /**
     * 得到动态代理路由接口的实例
     *
     * @param c   接口类
     * @param <T>
     * @return
     */
    public static <T> T getRounter(Class<T> c) {
        T rounter = (T) sRounterMap.get(c);
        if (rounter == null) {
            rounter = (T) Proxy.newProxyInstance(c.getClassLoader(), new Class[]{c}, (proxy, method, args) -> {
                //从方法注解的获取uri
                RouterUri routerUri = method.getAnnotation(RouterUri.class);
                if (routerUri == null || TextUtils.isEmpty(routerUri.value())) {
                    throw new LzException(
                            "invoke a rounter method, bug not assign a rounterUri");
                }
                Uri.Builder uriBuilder = Uri.parse(routerUri.value()).buildUpon();

                //从参数值和参数注解，获取信息，拼入uri的query
                Annotation[][] annotations = method.getParameterAnnotations();
                if (annotations != null && annotations.length > 0) {
                    for (int i = 0, n = annotations.length; i < n; i++) {
                        Annotation[] typeAnnotation = annotations[i];
                        if (typeAnnotation == null || typeAnnotation.length == 0) {
                            throw new LzException("method " + method.getName() + ", args at " + i + " lack of annotion RouterUri");
                        }
                        boolean findAnnotaion = false;
                        for (Annotation a : typeAnnotation) {
                            if (a != null && (a.annotationType() == RouterParam.class)) {
                                uriBuilder.appendQueryParameter(((RouterParam) a).value(), GsonFactory.getInstance().toJson(args[i]));
                                findAnnotaion = true;
                                break;
                            }
                        }
                        if (!findAnnotaion) {
                            throw new LzException("method " + method.getName() + " args at " + i + ", lack of annotion RouterUri");
                        }
                    }
                }

                Context context = ContextFactory.get();
                PackageManager pm = context.getPackageManager();
                Uri uri = uriBuilder.build();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //查询这个intent是否能被接收用来进行跳转
                List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
                if (activities != null && !activities.isEmpty()) {
                    return intent;
                } else {
                    if (BuildConfig.IS_DEBUG) {
                        Toast.makeText(context, "子模块作为独立程序启动时，跳不到其他模块哟", Toast.LENGTH_SHORT).show();
                    } else {
                        throw new LzException("can't resolve uri with " + uri.toString());
                    }
                }
                return null;
            });
            sRounterMap.put(c, rounter);
        }
        return rounter;
    }
}
