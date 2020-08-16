package com.htp.controller.convert;

import com.htp.domain.HibernateUser;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@RequiredArgsConstructor
public abstract class UserRequestConverter<S, T> extends EntityConverter<S, T> {

    protected HibernateUser doConvert(HibernateUser user) {

        user.setCreate(new Timestamp(new Date().getTime()));
        user.setLogged(new Timestamp(new Date().getTime()));
        user.setStatus("unblock");

        return user;
    }
}

