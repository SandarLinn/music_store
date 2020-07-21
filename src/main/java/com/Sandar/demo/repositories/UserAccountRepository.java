package com.Sandar.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sandar.demo.models.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	UserAccount findByEmail (String email);
}
