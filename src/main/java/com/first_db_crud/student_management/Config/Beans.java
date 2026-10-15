package com.first_db_crud.student_management.Config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class Beans {

//    private final static  String username;
//
//    private final static String password;

//    public Beans(@Value("${username}") String username,@Value("${password}")String password){
//         username = username;
//         password = password;
//    }
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public static DataSource getDataSource(){
        DataSourceBuilder<?> dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/user_db");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("admin112233admin");
        return dataSourceBuilder.build();
    }
}
