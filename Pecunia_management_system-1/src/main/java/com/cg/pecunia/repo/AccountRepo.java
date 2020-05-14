package com.cg.pecunia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.pecunia.model.AccountManagement;

@Repository
public interface AccountRepo extends JpaRepository<AccountManagement, Long> {
	
	
	@Query("select a.accountId from AccountManagement a where a.customerId = :customerId")
	public long getId(@Param("customerId") long customerId);
}