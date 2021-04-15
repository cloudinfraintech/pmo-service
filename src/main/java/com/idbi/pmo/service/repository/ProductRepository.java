/**
 * 
 */
package com.idbi.pmo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbi.pmo.service.model.Client;
import com.idbi.pmo.service.model.Product;

/**
 * @author avinash
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByClient(Client client);

}
