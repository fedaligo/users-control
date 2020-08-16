package com.htp.repository;

import com.htp.domain.HibernateUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface HibernateUserDao {
    public void block(String[] mass);
    public void unblock(String[] mass);
    public void delete(String[] mass);
    public void insert(HttpServletRequest request);
    public void auth(Long id);
}
