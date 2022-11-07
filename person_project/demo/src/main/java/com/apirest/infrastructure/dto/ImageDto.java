package com.apirest.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private String id_image;
    private String name_image;
    private String extension_image;
    private String url_image;
    private Date createdAt_image;
    private Date updatedAt_image;
}
