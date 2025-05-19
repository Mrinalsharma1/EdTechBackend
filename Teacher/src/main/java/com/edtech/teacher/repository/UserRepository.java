package com.edtech.teacher.repository;


import com.edtech.teacher.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Users findByUsername(String name);
    boolean existsByUsername(String username);

//    Optional<Users> findByUsernameOrEmailOrPhone(String username, String email, String phone);


//    @Query
//    Select * from users where users.username=$1 or users.email=$2 or users.phone=$3;
}

