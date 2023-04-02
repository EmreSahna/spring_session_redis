package com.emresahna.sessionmanagmentwithredis.repository;

import com.emresahna.sessionmanagmentwithredis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
