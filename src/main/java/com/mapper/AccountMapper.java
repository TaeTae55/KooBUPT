package com.mapper;

import com.entity.Account;
import com.entity.ComputerRoom;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

@Mapper
public interface AccountMapper {
    public Account login(Account account1) throws IOException;
    public Account findAccount(Account account1) throws IOException;
    public List<Account> findAllStudent() throws IOException;
    public List<Account> findAllTeacher() throws IOException;
    public int updateAccount(Account account1) throws IOException;
    public List<Account> findAllUser() throws IOException;
    public int ManualImport(Account account) throws IOException;
}
