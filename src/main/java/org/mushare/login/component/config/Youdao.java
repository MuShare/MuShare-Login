package org.mushare.login.component.config;

import org.mushare.easyjapanese.component.config.common.ConfigUnit;
import org.mushare.easyjapanese.dao.ConfigDao;

public class Youdao extends ConfigUnit {

    public String appKey;
    public String appSecret;

    public Youdao(ConfigDao configDao) {
        super(configDao);
    }
}
