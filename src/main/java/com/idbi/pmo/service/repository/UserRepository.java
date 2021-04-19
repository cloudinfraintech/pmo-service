/**
 * 
 */
package com.idbi.pmo.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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

}
