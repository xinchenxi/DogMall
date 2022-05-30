package com.cdut.Interceptor;



import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * 拦截器注解
 */
@Intercepts({@Signature(type= StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {

    private int page;
    private int size;
    /**
     * 用于抑制编译器产生警告信息
     */
    @SuppressWarnings("unused")
    private String dbType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("plugin is running...");
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        while(metaObject.hasGetter("h")){
            Object object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }
        while(metaObject.hasGetter("target")){
            Object object = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(object);
        }
        MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();
        if(mapId.matches(".+ByPager$")){
            ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
            Map<String, Object> params = (Map<String, Object>)parameterHandler.getParameterObject();
            params.forEach((k,v)->System.out.println("k="+k + "  v="+v));
            Map<String, Object> params1=(HashMap<String, Object>)params.get("params");
            page = (int)params1.get("page");
            size = (int)params1.get("size");
            String sql = (String) metaObject.getValue("delegate.boundSql.sql");
            System.out.println(sql);
            sql += " limit "+(page-1)*size +","+size;
            metaObject.setValue("delegate.boundSql.sql", sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);

    }

    @Override
    public void setProperties(Properties properties) {
        String limit = properties.getProperty("limit","10");
        this.page = Integer.parseInt(limit);
        this.dbType = properties.getProperty("dbType", "mysql");
    }
}
