package springboot.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import springboot.entity.Student;
import springboot.entity.Teacher;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final EntityManager entityManager;

    public SchoolServiceImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
        entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public List<Student> getAllStudents(List<Integer> ages) {
        entityManager.getTransaction().begin();
        String query;
        List<Student> students;
        if (ages.isEmpty()) {
            query = "select s from Student s";
            students = entityManager.createQuery(query, Student.class).getResultList();
        } else {
            query = "select s from Student s where s.age in :ages";
            students = entityManager.createQuery(query, Student.class).setParameter("ages", ages).getResultList();
        }
        entityManager.getTransaction().commit();
        return students;
    }

    @Override
    public List<Teacher> getTeacherInfoByStudentId(int studentId) {
        entityManager.getTransaction().begin();
        String query = "select st.teacher from StudentTeacher st where st.student.id = :studentId";
        List<Teacher> teachers = entityManager.createQuery(query, Teacher.class).setParameter("studentId", studentId).getResultList();
        entityManager.getTransaction().commit();
        return teachers;
    }

    @Override
    public Student createStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public Student updateStudent(int id, Student student) {
        entityManager.getTransaction().begin();
        student.setId(id);
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public Student deleteStudent(int id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        return student;
    }
}
