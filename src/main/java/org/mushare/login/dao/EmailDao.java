package org.mushare.login.dao;

import org.mushare.login.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao extends JpaRepository<Email, Long> {
}
