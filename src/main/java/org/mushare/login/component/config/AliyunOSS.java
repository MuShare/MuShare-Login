package org.mushare.login.component.config;

import org.mushare.login.component.config.common.ConfigUnit;
import org.mushare.login.dao.ConfigDao;

public class AliyunOSS extends ConfigUnit {

    public String endpoint;
    public String bucket;
    public String accessKeyId;
    public String accessKeySecret;
    public String baseUrl;

    public AliyunOSS(ConfigDao configDao) {
        super(configDao);
    }
}
