package com.mkj.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.AppUsers;

@Repository
public interface AppUserRepository extends JpaRepository<AppUsers, Integer> {

	@Query("from AppUsers where username = :username")
	public AppUsers getUsersByUsername(String username);
}
