//package com.zdz.test.web.tool.mybatisInterceptor;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.ParameterMap;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
//import org.apache.ibatis.reflection.factory.ObjectFactory;
//import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
//import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//
//import java.lang.reflect.Method;
//import java.util.Properties;
//
///**
// * @Author: ZhangDeZhi
// * @Date: 2019-10-23
// */
//
//@Intercepts({@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
//public class MyPageInterceptor implements Interceptor {
////    private static final Logger logger= LoggerFactory.getLogger(MyPageInterceptor.class);
//private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
//    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
////        logger.warn(invocation.toString());
////        Statement statement;
////        //获取方法参数
////        Object firstArg = invocation.getArgs()[0];
////        if (Proxy.isProxyClass(firstArg.getClass())) {
////            statement = (Statement) SystemMetaObject.forObject(firstArg).getValue("h.statement");
////        } else {
////            statement = (Statement) firstArg;
////        }
////        MetaObject stmtMetaObj = SystemMetaObject.forObject(statement);
////        //获取Statement对象（sql语法已经构建完毕）
////        statement = (Statement) stmtMetaObj.getValue("stmt.statement");
////        //获取sql语句
////        String originalSql = statement.toString();
////        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
////        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
////        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
////        Object parameterObject = metaStatementHandler.getValue("delegate.boundSql.parameterObject");
////        doSplitTable(metaStatementHandler,parameterObject);
//
//        // TODO Auto-generated method stub
//        System.out.println("拦截的对象是1："+invocation.getTarget());
//        System.out.println("拦截方法是1："+invocation.getMethod().toString());
//        System.out.println("拦截参数是1："+invocation.getArgs().length);
//
//        if(invocation.getTarget() instanceof StatementHandler) {
//            StatementHandler delegate = (StatementHandler) invocation.getTarget();
//            BoundSql boundSql = delegate.getBoundSql();
//            Object obj = boundSql.getParameterObject();
//            System.out.println("========================intercept============================="+obj.toString());
//        }
//        System.out.println("========================intercept============================="+invocation.toString());
//
//        return invocation.proceed();
//    }
//    @Override
//    public Object plugin(Object target) {
//        System.out.println("========================plugin=============================");
//
//        // TODO Auto-generated method stub
//        System.out.println("插件方法2--将要包装的目标对象2："+target);
//        //为当前对象创建代理对象
//        Object o=Plugin.wrap(target, this);
//        return o;
//    }
//    @Override
//    public void setProperties(Properties properties) {
//        System.out.println("========================setProperties=============================");
//        String prop1 = properties.getProperty("prop1");
//        String prop2 = properties.getProperty("prop2");
//        System.out.println(prop1 + "------" + prop2);
////        logger.warn(properties.toString());
//    }
//
//    private void doSplitTable(MetaObject metaStatementHandler,Object param ) throws Exception {
//        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
//        if (originalSql != null && !originalSql.equals("")) {
//            System.out.println("==========================="+"分表前的SQL：\n" + originalSql);
//            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
//            String id = mappedStatement.getId();
//            String className = id.substring(0, id.lastIndexOf("."));
//            String methodName = id.substring(id.lastIndexOf(".") + 1);
//            Class<?> clazz = Class.forName(className);
//            ParameterMap paramMap = mappedStatement.getParameterMap();
//            System.out.printf(paramMap.toString());
//            Method method = findMethod(clazz.getDeclaredMethods(), methodName);
////            // 根据配置自动生成分表SQL
////            TableSplit tableSplit = null;
////            if (method != null) {
////                tableSplit = method.getAnnotation(TableSplit.class);
////            }
////
////            if (tableSplit == null) {
////                tableSplit = clazz.getAnnotation(TableSplit.class);
////            }
////            System.out.printf(JsonUtil.toString(paramMap));
////            if (tableSplit != null && tableSplit.split() && StringUtils.isNotBlank(tableSplit.strategy())) {
////                StrategyManager strategyManager = ContextHelper.getBean(StrategyManager.class);
////                String convertedSql = "";
////                String[] strategies = tableSplit.strategy().split(",");
////                for (String str : strategies) {
////                    ResourceProperties.Strategy strategy = strategyManager.getStrategy(str);
////                    Map<String,Object> params =new HashMap<String,Object>();
////                    params.put(Strategy.TABLE_NAME, tableSplit.value());
////                    params.put(Strategy.SPLIT_FIELD, tableSplit.field());
////                    params.put(Strategy.EXECUTE_PARAM_DECLARE, paramMap);
////                    params.put(Strategy.EXECUTE_PARAM_VALUES, param);
////
////                    convertedSql = originalSql.replaceAll(tableSplit.value(), strategy.convert(params));
////                }
////                metaStatementHandler.setValue("delegate.boundSql.sql", convertedSql);
////
////                log.info("分表后的SQL：\n" + convertedSql);
////            }
//        }
//    }
//    private Method findMethod(Method[] methods, String methodName) {
//        for (Method method : methods) {
//            if (method.getName().equals(methodName)) {
//                return method;
//            }
//        }
//        return null;
//    }
//
//}