package sms.service;

import java.util.List;
import sms.dao.StudentDAO;
import sms.model.Student;

public class StudentService {
    private final StudentDAO studentDao = new StudentDAO();

    public boolean register(Student student) {
        return studentDao.registerStudent(student);
    }

    public List<Student> getAll() {
        return studentDao.getAllStudents();
    }

    public Student getById(int id) {
        return studentDao.getStudentById(id);
    }

    public boolean delete(int id) {
        return studentDao.deleteStudent(id);
    }
}