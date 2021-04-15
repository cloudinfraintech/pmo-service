/**
 * 
 */
package com.idbi.pmo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.idbi.pmo.service.model.User;

/**
 * @author avinash
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);

	User findById(Long projectManager);

	//@Query("select NM from Egenempmst e where e.NM like :name%")
	//List<User> findByProduct(@Param("productId") Long productId);
}
