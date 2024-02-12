package de.intagau.pfeifmaus.mapper;

import de.intagau.pfeifmaus.dto.ProductDto;
import de.intagau.pfeifmaus.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getBarcode(),
                productDto.getSerial(),
                productDto.getTags(),
                productDto.getHtmlLink(),
                productDto.getPicture(),
                productDto.getDescription()
        );
    }

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getBarcode(),
                product.getSerial(),
                product.getTags(),
                product.getHtmlLink(),
                product.getPicture(),
                product.getDescription()
        );
    }
}
