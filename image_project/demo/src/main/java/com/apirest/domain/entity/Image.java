package com.apirest.domain.entity;

import com.apirest.infrastructure.dto.PersonDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Document(collection = "images")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Data
@Builder
public class Image {
    @Id
    private String _id;
    private String name;
    private String extension;
    private String url;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    //private int _person;
    private PersonDto _person;

    public Image clone(){
        return Image.builder()
                ._id(_id)
                .name(name)
                .extension(extension)
                .url(url)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                ._person(_person)
                .build();
    }

}
