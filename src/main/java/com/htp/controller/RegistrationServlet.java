package com.htp.controller;

import com.htp.controller.convert.UserRequestConverter;
import com.htp.domain.HibernateUser;
import com.htp.repository.HibernateUserDao;
import com.htp.repository.HibernateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@WebServlet("/regservlet")
public class RegistrationServlet extends HttpServlet {
    private final HibernateUserDao hibernateUserDao;
    private final HibernateUserRepository hibernateUserRepository;
    private final UserRequestConverter userRequestConverter;
    private final ConversionService conversionService;
    /*private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }*/

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
                        hibernateUserDao.insert(request);
                        request.getRequestDispatcher("/WEB-INF/jsp/authentication.jsp").forward(request, response);
                    }
                }
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp").forward(request, response);
        }

    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        dispatcher.forward(request, response);
    }*/
}
