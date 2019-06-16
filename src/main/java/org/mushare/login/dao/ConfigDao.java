package org.mushare.login.dao;

import org.mushare.login.domain.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigDao extends JpaRepository<Config, Long> {

    List<Config> findByClazz(String clazz);

}
