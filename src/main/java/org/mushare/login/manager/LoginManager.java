package org.mushare.login.manager;

import org.mushare.login.domain.*;
import org.mushare.login.enums.OS;
import org.mushare.login.manager.common.BaseManager;
import org.mushare.login.manager.common.Result;
import org.mushare.login.manager.common.ResultCode;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginManager extends BaseManager {

    public Result<String> loginWithEmail(String address, String password, String identifier,
                                  String os, String version, String ip, String language, String sdkSecret) {
        if (OS.fromIdentifer(os) == OS.unkonwn) {
            return ResultCode.UnknownOS.result();
        }
        App app = appDao.getBySdkSecret(sdkSecret);
        if (app == null) {
            return ResultCode.SdkSecrectError.result();
        }
        Email email = emailDao.getByAddress(address);
        if (email == null) {
            return ResultCode.EmailNotExist.result();
        }
        if (!email.getPassword().equals(password)) {
            return ResultCode.PasswordError.result();
        }
        Person person = personDao.getByEmail(email);
        if (person == null) {
            return ResultCode.PersonNotExsit.result();
        }
        long now = System.currentTimeMillis();
        User user = userDao.getByAppAndPerson(app, person);
        if (user == null) {
            user = User.builder()
                    .createdAt(now)
                    .updatedAt(now)
                    .app(app)
                    .person(person)
                    .build();
            userDao.save(user);
        }
        Device device = deviceDao.getByUserAndIdentifier(user, identifier);
        if (device == null) {
            device = Device.builder()
                    .createdAt(now)
                    .identifier(identifier)
                    .user(user)
                    .build();
        }
        device.setUpdatedAt(now);
        device.setOs(OS.fromIdentifer(os).getCode());
        device.setVersion(version);
        device.setLanguage(language);
        device.setIp(ip);
        device.setAccessToken(UUID.randomUUID().toString());
        deviceDao.save(device);
        return Result.data(device.getAccessToken());
    }

}
