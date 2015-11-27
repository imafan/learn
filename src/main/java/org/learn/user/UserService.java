package org.learn.user;


import org.learn.base.BaseService;

/**
 * Created by imafan_work on 2015/10/16 0016.
 */
public class UserService extends BaseService<User> {

    private static class SingletonHolder{
        private static final UserService INSTANCE = new UserService();
    }

    public static final UserService getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
