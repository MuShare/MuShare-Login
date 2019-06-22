package org.mushare.login.component.config;


import org.mushare.login.component.config.common.ConfigUnit;
import org.mushare.login.dao.ConfigDao;

public class Youdao extends ConfigUnit {

    public String appKey;
    public String appSecret;

    public Youdao(ConfigDao configDao) {
        super(configDao);
    }
}
