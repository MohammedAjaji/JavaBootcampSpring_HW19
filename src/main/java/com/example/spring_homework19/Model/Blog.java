package com.example.spring_homework19.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cant be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "category cant be empty")
    @Column(columnDefinition = "varchar(20) not null check ( category = 'health' or category = 'education' or category = 'programming')")
    private String category;

    @NotEmpty(message = "body cant be empty")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;

    @Column(columnDefinition = "bool default false")
    private Boolean isPublished = false;
}
