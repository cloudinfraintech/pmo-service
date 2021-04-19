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

	@Query(value = "SELECT * FROM user u,user_role ur WHERE u.id =?1 AND  ur.role_id =?2 and ur.user_id=u.id", nativeQuery = true)
	User findByUserIdAndRoleId(Long userId, Long roleId);

	@Query(value = "SELECT u.* FROM user u,product p,role r WHERE p.id = :productId AND p.pm=u.id AND r.id=2", nativeQuery = true)
	User findByPMByProductId(@Param("productId") Long productId);

	/**@Query(value = "SELECT * FROM user u,product p,role r WHERE p.id = :productId AND p.pm=u.id AND r.id=3", nativeQuery = true)
	User findByIMgrByProductId(@Param("productId") Long productId);

	@Query(value = "SELECT * FROM user u,product p,role r WHERE p.id = :productId AND p.pm=u.id AND r.id=4", nativeQuery = true)
	User findByRMgrByProductId(@Param("productId") Long productId);*/

}
