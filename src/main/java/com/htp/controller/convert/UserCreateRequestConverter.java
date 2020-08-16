package com.htp.controller.convert;


import com.htp.domain.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
@RequiredArgsConstructor
public class UserCreateRequestConverter extends UserRequestConverter<HttpServletRequest, HibernateUser> {

    @Override
    public HibernateUser convert(HttpServletRequest request) {
        HibernateUser user = new HibernateUser();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setMail(request.getParameter("mail"));
        return doConvert(user);
    }
}