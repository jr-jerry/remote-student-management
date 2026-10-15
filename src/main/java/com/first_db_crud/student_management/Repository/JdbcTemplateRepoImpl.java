package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Config.Beans;
import com.first_db_crud.student_management.Entity.Student;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateRepoImpl  {
    private   DataSource dataSource;
    private   Connection connection;
    public JdbcTemplateRepoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public Student save(Student student)  {
        dataSource= Beans.getDataSource();
        try{
            connection= dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(
                    "insert into student_tb (name,age) values (?,?)"
            );
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            int rowUpdate=preparedStatement.executeUpdate();
            Student student1=new Student();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return findByName(student.getName()).get();

    }


    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }


    public List<Student> findAll() {
        dataSource= Beans.getDataSource();

        List<Student> list=new ArrayList<>();
        try{
            connection= dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("select * from student_tb");
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student=new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public void deleteById(Integer id) {

    }


    public Optional<Student> findByName(String name) {
        List<Student> list=findAll();
        for(Student student:list){
            if(student.getName().equals(name)){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
}
