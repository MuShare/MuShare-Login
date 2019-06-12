package org.mushare.login.dao;

import org.mushare.login.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppDao extends JpaRepository<App, Long> {

    App getBySdkSecret(String sdkSecret);

}
