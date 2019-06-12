package org.mushare.login.manager;

import lombok.extern.slf4j.Slf4j;
import org.mushare.login.domain.App;
import org.mushare.login.domain.Email;
import org.mushare.login.domain.Person;
import org.mushare.login.spec.request.RegisterEmailRequest;
import org.mushare.login.spec.response.OperationResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class RegisterManager extends BaseManager {

    public OperationResponse registerByEmail(RegisterEmailRequest registerEmailRequest, String sdkSecret) {
        App app = appDao.getBySdkSecret(sdkSecret);
        if (app == null) {
            return OperationResponse.builder()
                    .succeed(false)
                    .code(2001)
                    .message("App secret key error")
                    .build();
        }
        long now = System.currentTimeMillis();
        try {
            Email email = Email.builder()
                    .createdAt(now)
                    .updatedAt(now)
                    .address(registerEmailRequest.getEmail())
                    .password(registerEmailRequest.getPassword())
                    .build();
            emailDao.save(email);
            Person person = Person.builder()
                    .createdAt(now)
                    .updatedAt(now)
                    .email(email)
                    .name(registerEmailRequest.getName())
                    .build();
            personDao.save(person);
        } catch (Exception e) {
            log.error("create user error", e);
            return OperationResponse.success();
        }

        return OperationResponse.success();
    }

}
