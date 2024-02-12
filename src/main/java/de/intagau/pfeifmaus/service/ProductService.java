package de.intagau.pfeifmaus.service;

import de.intagau.pfeifmaus.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getProductFindAll();

    ProductDto updateProduct(ProductDto updatedProduct);

    void deleteProduct(ProductDto productDto);
}
