package com.htp.controller;

import com.htp.domain.HibernateUser;
import com.htp.repository.HibernateUserDao;
import com.htp.repository.HibernateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final HibernateUserRepository hibernateUserRepository;
    private final HibernateUserDao hibernateUserDao;

    private List<HibernateUser> persons = new ArrayList<>();


    // внедряем значение из application.properties
    /*@Value("${welcome.message:test}")
    private String message = "Hello World";*/

    // Обычно я использую интерфейс Model, но в целом разницы нет,
    // т.к. используется реализация LinkedHashMap(Key, Val)
    @RequestMapping(value = { "/", "/authentication" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
        /*if(hibernateUserRepository.findByLoginAndPassword(login, password)){
            setToken(tokenUtils.generateToken(login));
        } else {
            setToken(null);
        }*/


        return "authentication";
    }
//?token='$token'
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model,  @RequestParam("login") String login, @RequestParam("password") String password) throws UnsupportedEncodingException {
        /*request.setCharacterEncoding("UTF-8");
        String token = request.getParameter("token");*/
        try{
            HibernateUser hibernateUser = hibernateUserRepository.findByLoginAndPassword(login, password);
            if(!hibernateUser.equals(null)){
                if(hibernateUser.getStatus().toString().equals("block")){
                    return "loginError";
                }
                hibernateUserDao.auth(hibernateUser.getId());
                persons = hibernateUserRepository.findAll();
                model.addAttribute("persons", persons);
                return "personList";
            } else {
                return "loginError";
            }

        } catch (NullPointerException npe){
            return "loginError";
        }

    }

    @RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
    @Transactional(rollbackFor = Exception.class)
    public String authentication(Model model) {

        String message = "Hello registration";

        model.addAttribute("message", message);

        return "registration";
    }

    @RequestMapping(value = { "/loginerror" }, method = RequestMethod.GET)
    @Transactional(rollbackFor = Exception.class)
    public String loginError(Model model) {

        String message = "Hello registration";

        model.addAttribute("message", message);

        return "loginError";
    }
}
