package com.example.demo;

import javax.persistence.*;

@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name="student_email_unique", columnNames ="email")
})
@Entity(name="Student")
public class Student {
    //tells hibernate that this is the primary key
    @Id
    //Set the auto-generated value strategy
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    @Column(name="id",updatable = false)
    private Long id;
    @Column(name="first_name",nullable = false,length = 50,columnDefinition ="TEXT")
    private String FirstName;
    @Column(name="last_name",nullable = false,length = 50,columnDefinition ="TEXT")
    private String LastName;
    @Column(name="email",nullable = false,length = 100,columnDefinition ="TEXT")
    private String Email;
    @Column(name="phone",nullable = false,length = 3)
    private Integer Age;

    public Student(Long id, String firstName, String lastName, String email, Integer age) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Age = age;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Integer age) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
