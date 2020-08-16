package com.htp.repository;

import com.htp.domain.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@RequiredArgsConstructor
@Repository
@Persistent
@Qualifier("hibernateUserDao")
public class HibernateUserDaoImpl implements HibernateUserDao{
    private final HibernateUserRepository hibernateUserRepository;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public void block(String[] mass) {
        for(int i = 0; i<mass.length;i++)
            hibernateUserRepository.block(Long.parseLong(mass[i]));
    }

    @Override
    @Transactional
    public void unblock(String[] mass) {
        for(int i = 0; i<mass.length;i++)
           hibernateUserRepository.unblock(Long.parseLong(mass[i]));
    }

    @Override
    @Transactional
    public void delete(String[] mass) {
        for(int i = 0; i<mass.length;i++)
            hibernateUserRepository.deleteById(Long.parseLong(mass[i]));
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void insert(HttpServletRequest request) {

        hibernateUserRepository.saveAndFlush(conversionService.convert(request, HibernateUser.class));
    }

    @Override
    @Transactional
    public void auth(Long id) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        hibernateUserRepository.isAuth(id,timestamp);
    }
}
