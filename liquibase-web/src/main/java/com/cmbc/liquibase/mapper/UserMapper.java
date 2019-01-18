package com.cmbc.liquibase.mapper;


import org.apache.ibatis.annotations.*;

import com.cmbc.liquibase.Utils.BaseMapper;
import com.cmbc.liquibase.mapper.provider.UserDynaSqlProvider;
import com.cmbc.liquibase.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //Dao类

    @SelectProvider(type=UserDynaSqlProvider.class,method="findByLogin")
    @Results({
            @Result(property="userType",column="user_type")
    })
    User findUserByPhoneByLogin(@Param("empId") String empId, @Param("pwd") String pwd);


}

