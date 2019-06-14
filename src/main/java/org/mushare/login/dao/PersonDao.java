package org.mushare.login.dao;

import org.mushare.login.domain.Email;
import org.mushare.login.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    Person getByEmail(Email email);

}
