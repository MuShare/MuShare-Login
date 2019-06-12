package org.mushare.login.manager;

import org.mushare.login.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseManager {

    @Autowired
    protected AppDao appDao;

    @Autowired
    protected EmailDao emailDao;

    @Autowired
    protected FacebookDao facebookDao;

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected PersonDao personDao;

}
