package de.intagau.pfeifmaus.service.impl;

import de.intagau.pfeifmaus.dto.ProductDto;
import de.intagau.pfeifmaus.entity.Product;
import de.intagau.pfeifmaus.exception.ResourceNotFoundException;
import de.intagau.pfeifmaus.mapper.ProductMapper;
import de.intagau.pfeifmaus.repository.ProductsRepository;
import de.intagau.pfeifmaus.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductsRepository productsRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        ProductDto savedProductDto = ProductMapper.mapToProductDto(productsRepository.save(product));
        return savedProductDto;
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("product with id = %d not found", productId)));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getProductFindAll() {
        List<Product> products = productsRepository.findAll(
                Sort.by(Sort.Direction.ASC, "id"));
        return products.stream()
                .map(aProduct -> ProductMapper.mapToProductDto(aProduct))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(ProductDto updatedProduct) {
        Product product = productsRepository.findById(updatedProduct.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("product with id = %d not found", updatedProduct.getId())));
        if (updatedProduct.getName() != null)
            product.setName(updatedProduct.getName());
        if (updatedProduct.getDescription() != null)
            product.setDescription(updatedProduct.getDescription());
        ProductDto savedProductDto = ProductMapper.mapToProductDto(productsRepository.save(product));
        return savedProductDto;
    }

    @Override
    public void deleteProduct(ProductDto productDto) {
        Product product = productsRepository.findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("product with id = %d not found", productDto.getId())));
        productsRepository.delete(product);
    }
}
