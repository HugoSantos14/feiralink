package com.hugosantos.feiralink.repositories;

import com.hugosantos.feiralink.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
