/**
 * 
 */
package com.idbi.pmo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbi.pmo.service.model.Role;

/**
 * @author avinash
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findByIsActive(boolean b);

}
