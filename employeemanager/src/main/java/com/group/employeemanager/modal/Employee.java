package com.group.employeemanager.modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,
            updatable = false)
    private Long id;
    private String name;
    private String email;
    private String job_title;
    private String phone;
    private String imageURL;
    @Column(nullable = false,
            updatable = false)
    private String employeeID;

    public Employee(String name,
                    String email,
                    String job_title,
                    String phone,
                    String imageURL,
                    String employeeID) {
        this.name = name;
        this.email = email;
        this.job_title = job_title;
        this.phone = phone;
        this.imageURL = imageURL;
        this.employeeID = employeeID;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", job_title='" + job_title + '\'' +
                ", phone='" + phone + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }
}
