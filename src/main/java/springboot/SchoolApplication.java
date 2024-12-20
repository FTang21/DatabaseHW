package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    /* MySQL Script
    create table Student (
        id int auto_increment primary key,
        name varchar(100) not null,
        age int not null
    );

    create table Teacher (
        id int auto_increment primary key,
        name varchar(100)
    );

    create table Student_Teacher (
        student_id int not null,
        teacher_id int not null,
        primary key (student_id, teacher_id),
        foreign key (student_id) references student(id),
        foreign key (teacher_id) references teacher(id)
    );

    insert into student (name, age)
        values ("Abby", 17), ("Bob", 15), ("Charlie", 15), ("Diana", 16);

    insert into teacher (name) values ("Zander"), ("Ymir");

    insert into student_teacher (student_id, teacher_id)
        values (1, 1), (1, 2), (2, 2), (3, 1), (4, 1), (4, 2);
     */

}
