/**
 * 
 */
package com.idbi.pmo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbi.pmo.service.model.Product;

/**
 * @author avinash
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM product T1,product_client T2 WHERE t2.CLIENT_ID = :clientID AND T1.ID=T2.PRODUCT_ID", nativeQuery = true)
	List<Product> findByClient(@Param("clientID") Long clientID);

}
