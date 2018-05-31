package main.dao;

import main.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
