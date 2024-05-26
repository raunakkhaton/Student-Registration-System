package com.rounak.hw1.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "staffs", catalog = "college")
public class Staff {
    public Staff() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String department;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private  Staff staff;
}
