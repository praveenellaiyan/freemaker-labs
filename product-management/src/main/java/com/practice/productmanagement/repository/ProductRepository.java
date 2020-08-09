/**
 * 
 */
package com.practice.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.productmanagement.model.Product;

/**
 * @author Praveen Ellaiyan
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
