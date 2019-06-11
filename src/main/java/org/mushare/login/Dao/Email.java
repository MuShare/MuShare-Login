package org.mushare.login.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Email extends JpaRepository<Email, Long> {
}
