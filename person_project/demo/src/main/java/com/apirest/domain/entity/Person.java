package com.apirest.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "person")
@AllArgsConstructor @NoArgsConstructor @Setter @Getter @ToString
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "age")
    private int age;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_document_id", insertable = true, updatable = true, nullable = false)
    private TypeDocument type_document = new TypeDocument();

    public String getType_document() {
        return type_document.getId();
    }

    public TypeDocument getType_document_all() {
        return type_document;
    }

    public void setType_document(TypeDocument type_document) {
        this.type_document = type_document;
    }

    public Person clone(){
        return Person.builder()
                .id(id)
                .email(email)
                .cedula(cedula)
                .age(age)
                .type_document(type_document)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }


}
