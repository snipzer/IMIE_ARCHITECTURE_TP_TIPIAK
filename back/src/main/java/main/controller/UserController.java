package main.controller;

import main.dao.UserDao;
import main.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserDao userDao;

    @RequestMapping("/login")
    public void login() {
        LOG.debug("TOTO");
        User user = new User();
        user.setFirstname("titi");
        user.setLastname("tutu");
        userDao.save(user);

        for (User recuperateUser : userDao.findAll()) {
            LOG.error(recuperateUser.getFirstname());
        }
    }


    @Bean
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
