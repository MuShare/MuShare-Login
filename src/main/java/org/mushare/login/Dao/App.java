package org.mushare.login.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface App extends JpaRepository<App, Long> {
}
