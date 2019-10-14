package com.wkl.isien.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	Admin findFirstByLoginAndPassword(String login,String password);
	Admin findFirstByLogin(String login);	
}
