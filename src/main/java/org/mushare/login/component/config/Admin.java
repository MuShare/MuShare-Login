package org.mushare.login.component.config;

import org.mushare.login.component.config.common.ConfigUnit;
import org.mushare.login.dao.ConfigDao;

public class Admin extends ConfigUnit {

    public String username;
    public String password;

    public Admin(ConfigDao configDao) {
        super(configDao);
    }

}
