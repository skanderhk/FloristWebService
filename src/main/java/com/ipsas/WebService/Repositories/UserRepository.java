package com.ipsas.WebService.Repositories;

import com.ipsas.WebService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByUsername(String s);
}
