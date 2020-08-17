package com.htp.controller;

import com.htp.repository.HibernateUserDao;
import com.htp.repository.HibernateUserRepository;
import lombok.RequiredArgsConstructor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@WebServlet("/regservlet")
public class RegistrationServlet extends HttpServlet {
    private final HibernateUserDao hibernateUserDao;
    private final HibernateUserRepository hibernateUserRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");

        if(!hibernateUserRepository.findByLogin(login).isPresent()){
            if(login.equals("")){
                request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp").forward(request, response);
            } else {
                if(password.equals("")){
                    request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp").forward(request, response);
                } else {
                    if(mail.equals("")){
                        request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp").forward(request, response);
                    } else {
                        char[] mass = mail.toCharArray();
                        for(int i=0;i<mass.length;i++){
                            if(mass[i]=='@'){
                                hibernateUserDao.insert(request);
                                request.getRequestDispatcher("/WEB-INF/jsp/authentication.jsp").forward(request, response);
                                break;
                            }
                            if(i==mass.length-1){
                                request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp").forward(request, response);
                            }
                        }

                    }
                }
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp").forward(request, response);
        }
    }
}
