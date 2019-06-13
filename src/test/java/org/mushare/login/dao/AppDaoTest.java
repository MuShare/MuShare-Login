package org.mushare.login.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mushare.login.domain.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppDaoTest {

    @Autowired
    private AppDao appDao;

    @Test
    public void addTestApp() {
        App app = App.builder()
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .identifier("org.mushare.login.test")
                .name("Test")
                .apiSecret(UUID.randomUUID().toString())
                .sdkSecret(UUID.randomUUID().toString())
                .build();
        appDao.save(app);
    }
}
