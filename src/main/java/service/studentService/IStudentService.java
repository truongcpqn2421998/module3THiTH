package service.studentService;

import library.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudent();
    Student findById(String id);
}
