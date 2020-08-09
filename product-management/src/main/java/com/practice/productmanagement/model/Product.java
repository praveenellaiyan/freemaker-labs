/**
 * 
 */
package com.practice.productmanagement.model;



import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Praveen Ellaiyan
 *
 */
@Entity
@Table(name = "PRODUCT")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {

	@Column(unique = true, nullable = false)
	@Id
	private String name;
	
	@Column
	private int units;
	
	@Column
	private Instant createdAt;
	
	@Column
	private Instant updatedAt;
}
