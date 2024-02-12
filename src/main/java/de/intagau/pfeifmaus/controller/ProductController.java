package de.intagau.pfeifmaus.controller;

import de.intagau.pfeifmaus.dto.ProductDto;
import de.intagau.pfeifmaus.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto savedProductDto = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductFindAll() {
        return ResponseEntity.ok(productService.getProductFindAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> udpateProductById(
            @PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        if (id != productDto.getId()) {
            return new ResponseEntity<>(productDto, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }
}
