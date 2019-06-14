package org.mushare.login.dao;

import org.mushare.login.domain.App;
import org.mushare.login.domain.Person;
import org.mushare.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User getByAppAndPerson(App app, Person person);
}
