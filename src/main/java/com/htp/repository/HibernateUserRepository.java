package com.htp.repository;

import com.htp.domain.HibernateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface HibernateUserRepository extends CrudRepository<HibernateUser, Long>, JpaRepository<HibernateUser,Long> {
    Optional<HibernateUser> findByLogin(String login);
    Optional<HibernateUser> findById(Long id);

    @Override
    List<HibernateUser> findAll();

    HibernateUser findByLoginAndPassword(String login, String password);

    @Modifying
    @Query("UPDATE HibernateUser hu SET hu.status='unblock' WHERE hu.id=:id")
    void unblock(Long id);

    @Modifying
    @Query("UPDATE HibernateUser hu SET hu.status='block' WHERE hu.id=:id")
    void block(Long id);

    void deleteById(Long id);

    @Modifying
    @Query("UPDATE HibernateUser hu SET hu.logged=:logged WHERE hu.id=:id")
    void isAuth(Long id, Timestamp logged);
}
