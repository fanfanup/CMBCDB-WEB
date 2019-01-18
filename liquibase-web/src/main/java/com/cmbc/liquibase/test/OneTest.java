package com.cmbc.liquibase.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.cmbc.liquibase.Utils.DBUtils;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;



public class OneTest {
	


public static void main(String[] args) {
	
	String urlaa = "jdbc:mysql://127.0.0.1:3306/liqui?useSSL=false&useUnicode=true&characterEncoding=utf-8";

java.sql.Connection connection = DBUtils.openConnection("MYSQL","root","123456",urlaa); //your openConnection logic here
try {
	//Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
	Database database = DBUtils.getDatabaseInstance(connection);
	Liquibase liquibase = new liquibase.Liquibase("liquibase/changelog4.xml", new ClassLoaderResourceAccessor(), database);
	liquibase.update(new Contexts(), new LabelExpression());
	
	
	
} catch (DatabaseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (LiquibaseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

private static Connection openConnection(String dbType,String uname, String passwd) {
	String urlType = null ;
	String drivertype = null;
	if(dbType == null ){
		System.out.println("dbType is null , please check !!!");
	}else if(dbType == "MYSQL" || dbType.equalsIgnoreCase("mysql")){
		urlType = "jdbc:mysql://127.0.0.1:3306/liqui?useSSL=false&useUnicode=true&characterEncoding=utf-8";
		drivertype = "com.mysql.jdbc.Driver";		
	}else if(dbType == "DB2" || dbType.equalsIgnoreCase("db2")){
		urlType = "";
		drivertype = "";
	}else if(dbType == "ORACLE" || dbType.equalsIgnoreCase("oracle")){
		urlType = "";
		drivertype = "";		
	}
	 //声明Connection对象
    Connection con;
    try {
        //加载驱动程序
        Class.forName(drivertype);
        //1.getConnection()方法，连接数据库！！
        con = DriverManager.getConnection(urlType,uname,passwd);
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
    }finally{
        System.out.println("数据库链接成功！！");
    }
	return null;

}

private static Connection openConnection() {
	
    //声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://127.0.0.1:3306/liqui?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "123456";
    //遍历查询结果集
    try {
        //加载驱动程序
        Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        return con;
//        //2.创建statement类对象，用来执行SQL语句！！
//        Statement statement = con.createStatement();
//        //要执行的SQL语句
//        String sql = "select * from emp";
//        //3.ResultSet类，用来存放获取的结果集！！
//        ResultSet rs = statement.executeQuery(sql);
//        System.out.println("-----------------");
//        System.out.println("执行结果如下所示:");  
//        System.out.println("-----------------");  
//        System.out.println("姓名" + "\t" + "职称");  
//        System.out.println("-----------------");  
//         
//        String job = null;
//        String id = null;
//        while(rs.next()){
//            //获取stuname这列数据
//            job = rs.getString("job");
//            //获取stuid这列数据
//            id = rs.getString("ename");
//
//            //输出结果
//            System.out.println(id + "\t" + job);
//       }
//        rs.close();
//        con.close();
//    } catch(ClassNotFoundException e) {   
//        //数据库驱动类异常处理
//        System.out.println("Sorry,can`t find the Driver!");   
//        e.printStackTrace();   
        } catch(SQLException e) {
        //数据库连接失败异常处理
        e.printStackTrace();  
        }catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally{
        System.out.println("数据库数据成功获取！！");
    }
	return null;

}

	





	

}
