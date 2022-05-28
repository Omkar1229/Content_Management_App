package com.example.contentApp.repository;

import com.example.contentApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public abstract User findByUserIdAndPassword(int userId,String password);
}
