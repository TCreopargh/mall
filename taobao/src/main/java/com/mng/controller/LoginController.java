package com.mng.controller;

import com.alibaba.fastjson.JSONObject;
import com.mng.Repository.UserRepository;
import com.mng.bean.LoginBody;
import com.mng.entity.User;
import com.mng.exception.LoginFailedException;
import com.mng.exception.LoginFailedException.ErrorType;
import com.mng.util.JsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;
    List<User> usersList;
    String phone;
    String password;
    String usertype;
    String username;
    String mail;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public JSONObject login(HttpServletRequest request, @ModelAttribute("login") LoginBody loginbody) {
        phone = loginbody.getPhone();
        password = loginbody.getPassword();
        try {
            if (phone.isEmpty() || password.isEmpty()) {
                throw new LoginFailedException(ErrorType.FIELD_MISSING);
            } else if ((usersList = userRepository.findByPhone(phone)).isEmpty()) {
                throw new LoginFailedException(ErrorType.ACCOUNT_NOT_FOUND);
            } else if (usersList.size() > 1) {
                throw new LoginFailedException(ErrorType.ACCOUNT_NOT_FOUND);
            } else if (!usersList.get(0).getPassword().equals(password)) {
                throw new LoginFailedException(ErrorType.PASSWORD_INCORRECT);
            } else {
                username = usersList.get(0).getUsername();
                mail = usersList.get(0).getMail();
                usertype = usersList.get(0).getUsertype();
                request.getSession().setAttribute("phone", phone);
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("usertype", usertype);
                request.getSession().setAttribute("mail", mail);
                return JsonBuilder.newObject()
                        .put("error_type", "0")
                        .buildAsJsonObject();
                /*
                json.put("username",username);
                json.put("usertype",usertype);
                json.put("phone",phone);
                json.put("mail",mail);*/
            }
        } catch (LoginFailedException e) {
            return JsonBuilder.newObject()
                    .put("error_type", String.valueOf(e.getErrorType().ordinal()))
                    .buildAsJsonObject();
        }
    }
}

