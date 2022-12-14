package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);
}
