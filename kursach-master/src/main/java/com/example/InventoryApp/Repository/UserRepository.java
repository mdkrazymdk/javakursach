package com.example.InventoryApp.Repository;

import com.example.InventoryApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserNameContainingIgnoreCase(String userName);
}
