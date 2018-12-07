package com.demo.boot_pro.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库工具类
 * Created by DIAN on 2018/9/11.
 */
public  class DatabaseUtils {
    //声明Connection对象
    private Connection  con;
    //驱动程序名
    private String driver = "com.mysql.cj.jdbc.Driver";
    private static LogUtils logUtils = new LogUtils(DatabaseUtils.class);

    /**
     * 构建数据库连接
     * */
    public  List<Map<String,String>>  buildConnectionPoolT(String url, String user,String password,String SQL ,List<String> params){
        List<Map<String,String>> resultList  =  new ArrayList<>();
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            PreparedStatement ps = con.prepareStatement(SQL);
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet ret = statement.executeQuery(SQL);
            while (ret.next()) {
                Map<String,String> map = new HashMap<>();
                for(int x =0;x<params.size();x++){
                    map.put(params.get(x),ret.getString(x+1));
                }
                resultList.add(map);
            }//显示数据
            ret.close();
            con.close();
            return resultList;
        }catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            e.printStackTrace();
            logUtils.info("数据库驱动类异常处理: "+e.getMessage());
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
            logUtils.info("数据库连接失败异常处理: "+e.getMessage());
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            logUtils.info("数据库访问失败"+e.getMessage());
        }
        return resultList;
    }

    public  List<Map<String,String>>  buildConnectionPool(String url, String user,String password,String SQL ,List<Object> requestParams,List<String> returnParams){
        List<Map<String,String>> resultList  =  new ArrayList<>();
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.PreparedStatement，用来执行SQL语句！！
            PreparedStatement ps = con.prepareStatement(SQL);
            for(int x =0;x<requestParams.size();x++){
             ps.setObject(x+1,requestParams.get(x));
            }
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet ret = ps.executeQuery();
            while (ret.next()) {
                Map<String,String> map = new HashMap<>();
                for(int x =0;x<returnParams.size();x++){
                    map.put(returnParams.get(x),ret.getString(x+1));
                }
                resultList.add(map);
            }//显示数据
            ret.close();
            con.close();
            return resultList;
        }catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            e.printStackTrace();
            logUtils.info("数据库驱动类异常处理: "+e.getMessage());
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
            logUtils.info("数据库连接失败异常处理: "+e.getMessage());
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            logUtils.info("数据库访问失败"+e.getMessage());
        }
        return resultList;
    }

    public static void main(String[] args) {
        DatabaseUtils  databaseUtils = new DatabaseUtils();
        List<String> params = new ArrayList<>();
        params.add("config_id");
        params.add("param_name");
        params.add("param_value");
        params.add("param_desc");
        List<Map<String,String>> result = databaseUtils.buildConnectionPoolT("jdbc:mysql://127.0.0.1:3306/test_demo?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                "root","zxc123%#","SELECT config_id, param_name, param_value, param_desc FROM test_demo.system_config",
                params);
        System.out.println("success");
    }
}
