package com.cmbc.liquibase.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;

public class DBUtils {
	/*
	 * 数据连接获取器
	 * 参数：dbType ： MYSQL ORACLE DB2 
	 * 参数：uname
	 * 参数：passwd
	 * 参数：url
	 */
	public static Connection openConnection(String dbType,String uname, String passwd,String url) {
		String drivertype = null;
		if(dbType == null ){
			System.out.println("dbType is null , please check !!!");
		}else if(dbType == "MYSQL"){
			drivertype = "com.mysql.jdbc.Driver";		
		}else if(dbType == "DB2"){
			drivertype = "";
		}else if(dbType == "ORACLE"){
			drivertype = "";		
		}
		 //声明Connection对象
	    Connection con;
	    try {
	        //加载驱动程序
	        Class.forName(drivertype);
	        //1.getConnection()方法，连接数据库！！
	        con = DriverManager.getConnection(url,uname,passwd);
	        if(!con.isClosed()){
	        	System.out.println("Succeeded connecting to the Database!");
	        	return con;
	        }else{
	        	System.out.println("faild connecting to the Database!");
	        	return null ;
	        }
	    	} catch(ClassNotFoundException e) {   
	        //数据库驱动类异常处理
	        System.out.println("Sorry,can`t find the Driver!");   
	        e.printStackTrace();   
	        } catch(SQLException e) {
	        //数据库连接失败异常处理
	        e.printStackTrace();  
	        }catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	    }
		return null;
	}

	public static Database getDatabaseInstance(Connection connection) {
		try {
			if (!connection.isClosed()){
			Database database;
			database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
			return database ;
			}else {
				return null ;
			}
		} catch (DatabaseException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
