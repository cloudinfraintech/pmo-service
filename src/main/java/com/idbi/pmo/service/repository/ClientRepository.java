package com.idbi.pmo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbi.pmo.service.model.Client;

/****
 * 
 * @author avinash
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
