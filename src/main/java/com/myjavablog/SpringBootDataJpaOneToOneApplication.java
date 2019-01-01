package com.myjavablog;

import com.myjavablog.dao.StudentRepository;
import com.myjavablog.model.Address;
import com.myjavablog.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootDataJpaOneToOneApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDataJpaOneToOneApplication.class);

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        List<Student> studentList = new ArrayList<>();
        Student student = new Student( "Anup", 98884, new Address("Pune"));
        Student student1 = new Student( "Archu", 4384, new Address("UK"));
        Student student2 = new Student( "Ram", 3484, new Address("Chennai"));
        Student student3 = new Student( "Yuvraj", 9854, new Address("Baramati"));

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);

        studentRepository.saveAll(studentList);
        logger.info("Students saved successfully");

        Student s1 = studentRepository.findByName("Anup");
        System.out.println("Find by Name: "+ s1);

        for(Student s : studentRepository.findAll()){
            System.out.println("Student : "+ s +"Address : "+ s.getAddress());
            logger.info("Student : "+ s +"Address : "+ s.getAddress());
        }
	}
}

