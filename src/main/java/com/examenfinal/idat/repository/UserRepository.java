package com.examenfinal.idat.repository;

import com.examenfinal.idat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User validate(String username, String password);

}
