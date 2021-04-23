/**
 * 
 */
package com.idbi.pmo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbi.pmo.service.model.User;

/**
 * @author avinash
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	User findById(Long projectManager);

	@Query(value = "SELECT * FROM user u,user_role ur WHERE u.id =?1 AND  ur.role_id =?2 and ur.user_id=u.id", nativeQuery = true)
	User findByUserIdAndRoleId(Long userId, Long roleId);

	@Query(value = "SELECT * FROM user u,product p,role r WHERE p.id = :productId AND p.pm=u.id AND r.id=2", nativeQuery = true)
	User findByPMByProductId(@Param("productId") Long productId);

	@Query(value = "SELECT * FROM user u,product p,role r WHERE p.id = :productId AND p.im=u.id AND r.id=3 and p.pm = :prodctMgrId", nativeQuery = true)
	User findByIMByProductId(@Param("productId") Long productId, @Param("prodctMgrId") Long prodctMgrId);

	@Query(value = "SELECT * FROM user u,product p,role r WHERE p.id = :productId AND p.rm=u.id AND r.id=4 and p.pm = :prodctMgrId  AND p.im = :implMgrId", nativeQuery = true)
	User findByRMByProductId(@Param("productId") Long productId, @Param("prodctMgrId") Long prodctMgrId,
			@Param("implMgrId") Long implMgrId);

	@Query(value = "SELECT * FROM user u,user_role r where r.role_id= :roleId AND u.id=r.user_id;", nativeQuery = true)
	List<User> findByRole(@Param("roleId") Long roleId);

}
