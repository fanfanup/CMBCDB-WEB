package com.cmbc.liquibase.mapper.provider;


import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.cmbc.liquibase.model.User;

/**
 * @Author  ff 2018-12-20
 * 方法尚未补全 需后续补全
 */
public class UserDynaSqlProvider {
    //动态拼sql

    public String findByLogin(){
        return new SQL(){
            {
                SELECT("*");
                FROM("s_user");
                WHERE("empid = #{empId} and password = #{pwd}");
            }
        }.toString();
    }

    public String insertUsert(final User user){
        return new SQL(){
            {
                INSERT_INTO("s_user");
                VALUES("name","#{name}");
            }
        }.toString();
    }

    public String updateUser(final User user){
        return new SQL(){
            {
                UPDATE("s_user");
                SET("pwd=#{pwd}");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String deleteUser(){
        return new SQL(){
            {
                DELETE_FROM("s_user");
                WHERE("id=#{id}");
            }
        }.toString();
    }
}

