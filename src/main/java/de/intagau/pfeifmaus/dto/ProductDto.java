package de.intagau.pfeifmaus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private String barcode;

    private String serial;

    private String tags;

    private String htmlLink;

    private String picture;

    private String description;

}
