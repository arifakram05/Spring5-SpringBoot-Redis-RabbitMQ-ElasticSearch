package com.learning.spring.spring5.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@NoArgsConstructor
public class Employee {

    @Getter @Setter
    private String id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
    @Getter @Setter @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mmZ", timezone = "CST")
    private Date birthDate;

    public Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String id, String firstName, String lastName, Date hireDate, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
    }
}
