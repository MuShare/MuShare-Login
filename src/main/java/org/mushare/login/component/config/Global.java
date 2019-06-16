package org.mushare.login.component.config;

import org.mushare.login.component.config.common.ConfigUnit;
import org.mushare.login.dao.ConfigDao;

public class Global extends ConfigUnit {

    public String url;
    public Global(ConfigDao configDao) {
        super(configDao);
    }

}
