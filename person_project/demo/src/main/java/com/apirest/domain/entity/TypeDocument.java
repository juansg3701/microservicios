package com.apirest.domain.entity;

import com.apirest.domain.entity.Person;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TypeDocument")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class TypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "type_name")
    private String type_name;

    @OneToMany(mappedBy = "type_document", cascade = CascadeType.ALL)
    private List<Person> persons = new ArrayList<>();

}
