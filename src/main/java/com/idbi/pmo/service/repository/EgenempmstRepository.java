/**
 * 
 */
package com.idbi.pmo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbi.pmo.service.model.Egenempmst;

/**
 * @author avinash
 *
 */
public interface EgenempmstRepository extends JpaRepository<Egenempmst, Long> {
	@Query("select nm from Egenempmst e where e.nm like :name%")
	List<String> findByNm(@Param("name") String name);

	Egenempmst findByEmplyCd(Long ein);

}
