package de.intagau.pfeifmaus.repository;

import de.intagau.pfeifmaus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
