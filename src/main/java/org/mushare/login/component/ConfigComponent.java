package org.mushare.login.component;

import org.mushare.login.component.config.Admin;
import org.mushare.login.component.config.AliyunOSS;
import org.mushare.login.component.config.Global;
import org.mushare.login.dao.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;

@Component
public class ConfigComponent implements ApplicationListener<ApplicationReadyEvent> {

    // Limitation of uploaded file.
    public final static int FileMaxSize = 512 * 1024 * 1024;

    @Autowired
    private ConfigDao configDao;

    @Autowired
    private ServletContext context;

    public Global global;
    public AliyunOSS aliyunOSS;
    public Admin admin;

    public String cachePath = null;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        refresh();
        createCacheDirectory();
    }

    private void createCacheDirectory() {
        File cache = new File(context.getRealPath("/") + "/cache");
        cache.mkdir();
        cachePath = cache.getPath() + File.separator;
    }

    public void refresh() {
        global = new Global(configDao);
        aliyunOSS = new AliyunOSS(configDao);
        admin = new Admin(configDao);
    }

}
