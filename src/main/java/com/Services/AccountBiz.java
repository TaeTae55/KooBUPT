package com.Services;

import com.entity.Account;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;

public interface AccountBiz {
    int superLogin(String aid, String password) throws IOException;
    int administerLogin(String aid, String password) throws IOException;
    int setAdminister(String aid, String classes) throws IOException;
    List<Account> findAllUser() throws IOException;
//3.9
    public int ManualImport(String aid, String password, String name, String classes,String tel,String academic) throws IOException;
}
