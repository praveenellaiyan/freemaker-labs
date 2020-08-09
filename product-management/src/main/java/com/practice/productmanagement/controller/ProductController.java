/**
 * 
 */
package com.practice.productmanagement.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.productmanagement.model.Product;
import com.practice.productmanagement.repository.ProductRepository;
import com.practice.productmanagement.utils.PathConstant;

/**
 * @author Praveen Ellaiyan
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(path = PathConstant.ADD_PRODUCT)
	public String showAddProduct(Model model) {
		return "add-product";
	}

	@RequestMapping(path = PathConstant.ADD_PRODUCT, method = RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("product") Product product) {
		product.setCreatedAt(Instant.now());
		productRepository.save(product);
		return "redirect:/products";
	}

	@RequestMapping(path = PathConstant.EDIT_PRODUCT)
	public String showEditProduct(Model model, @PathVariable String name) {
		Optional<Product> product = productRepository.findById(name);
		model.addAttribute("product", product.get());
		return "edit-product";
	}

	@RequestMapping(path = PathConstant.EDIT_PRODUCT, method = RequestMethod.POST)
	public String updateProduct(Model model, @PathVariable String name, @ModelAttribute("product") Product product) {
		product.setUpdatedAt(Instant.now());
		productRepository.save(product);
		return "redirect:/products";
	}
	
	@RequestMapping(path = PathConstant.DELETE_PRODUCT)
	public String showDeleteProduct(Model model, @PathVariable String name) {
		Optional<Product> product = productRepository.findById(name);
		model.addAttribute("product", product.get());
		return "delete-product";
	}

	@RequestMapping(path = PathConstant.DELETE_PRODUCT, method = RequestMethod.POST)
	public String deleteProduct(Model model, @PathVariable String name) {
		productRepository.deleteById(name);
		return "redirect:/products";
	}
	
	@RequestMapping(path = PathConstant.PRODUCTS)
	public String getProducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "list-product";
	}

}
