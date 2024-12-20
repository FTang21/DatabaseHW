package springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import springboot.entity.Student;
import springboot.entity.Teacher;

@Service
public interface SchoolService {
    public List<Student> getAllStudents(List<Integer> age);
    public List<Teacher> getTeacherInfoByStudentId(int studentId);
    public Student createStudent(Student student);
    public Student updateStudent(int id, Student student);
    public Student deleteStudent(int id);
}
