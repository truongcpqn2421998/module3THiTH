package service.studentService;

import library.config.ConnectionSingleton;
import library.model.Book;
import library.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    Connection connection= ConnectionSingleton.getConnection();
    @Override
    public List<Student> findAllStudent() {
        List<Student> studentList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select *from student");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                String className=rs.getString("class");
                Student student=new Student(id,name,className);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(String id) {
        Student student=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select*from student where id=?;");
            preparedStatement.setString(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                String className=rs.getString("class");
                student=new Student(id,name,className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
