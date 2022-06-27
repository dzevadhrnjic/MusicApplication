package com.example.MusicApplication.user.database;

import com.example.MusicApplication.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User getUserByEmailAndPassword(String email, String password);

}
