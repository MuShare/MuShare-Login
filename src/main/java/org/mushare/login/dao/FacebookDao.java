package org.mushare.login.dao;

import org.mushare.login.domain.Facebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookDao extends JpaRepository<Facebook, Long> {
}
