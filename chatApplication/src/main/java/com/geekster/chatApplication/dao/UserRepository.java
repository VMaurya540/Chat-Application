package com.geekster.chatApplication.dao;

import com.geekster.chatApplication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {

@Query(value = "Select * from tbl_user where username = :username and status_id = 1",nativeQuery = true)
    public List<Users> findByUserName(String username);

@Query(value = "select * from tbl_user where user_id = :userId and status_id = 1",nativeQuery = true)
public  List<Users> getUserByUserId(int userId);

    @Query(value = "select * from tbl_user where  status_id = 1",nativeQuery = true)
    public  List<Users> getAllUsers();

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set status_id = 2 where user_id = :userId",
            countQuery = "SELECT count(*) FROM tbl_user", nativeQuery = true)
    public void deleteUserByUserId(int userId);


}



