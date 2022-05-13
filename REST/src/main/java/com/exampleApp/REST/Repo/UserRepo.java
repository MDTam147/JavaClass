package com.exampleApp.REST.Repo;

import com.exampleApp.REST.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
