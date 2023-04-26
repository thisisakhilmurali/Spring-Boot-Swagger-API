package com.example.springboottest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "The Column Name Should Not Be Blank")
    @Column(name = "student_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "roll_number")
    private String rollNumber;

}
