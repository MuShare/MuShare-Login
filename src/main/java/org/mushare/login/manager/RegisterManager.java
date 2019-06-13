package org.mushare.login.manager;

import lombok.extern.slf4j.Slf4j;
import org.mushare.login.domain.App;
import org.mushare.login.domain.Email;
import org.mushare.login.domain.Person;
import org.mushare.login.manager.common.BaseManager;
import org.mushare.login.manager.common.Result;
import org.mushare.login.manager.common.ResultCode;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterManager extends BaseManager {

    public Result registerByEmail(String address, String password, String name, String sdkSecret) {
        App app = appDao.getBySdkSecret(sdkSecret);
        if (app == null) {
            return ResultCode.SdkSecrectError.result();
        }
        Email email = emailDao.getByAddress(address);
        if (email != null) {
            return ResultCode.EmailExist.result();
        }
        long now = System.currentTimeMillis();
        email = Email.builder()
                .createdAt(now)
                .updatedAt(now)
                .address(address)
                .password(password)
                .build();
        emailDao.save(email);
        Person person = Person.builder()
                .createdAt(now)
                .updatedAt(now)
                .email(email)
                .name(name)
                .rev(0L)
                .build();
        personDao.save(person);

        return Result.success();
    }

}
