/**
 * 
 */
package com.idbi.pmo.service.repository;

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

	//@Query(value = "SELECT * FROM user u,user_role ur WHERE u.id = :userId AND  ur.role_id = :roleId",nativeQuery = true)
	//User findByUserIdAndRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);
	@Query(value = "SELECT * FROM user u,user_role ur WHERE u.id =?1 AND  ur.role_id =?2 and ur.user_id=u.id",nativeQuery = true)
	User findByUserIdAndRoleId(Long userId,  Long roleId);

	// @Query("select NM from Egenempmst e where e.NM like :name%")
	// List<User> findByProduct(@Param("productId") Long productId);
}
