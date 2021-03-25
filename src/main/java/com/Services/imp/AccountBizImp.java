package com.Services.imp;

import com.Services.AccountBiz;
import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.entity.ComputerRoom;
import com.mapper.AccountMapper;
import com.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service("accountBiz")
public class AccountBizImp implements AccountBiz {

    @Autowired
    private AccountMapper accountDao;

    /*
    * 教师登录函数
    * 如果不满足教师权限返回-1（能查询到账号但不是教师或查询不到账号）
    * 如果账号密码不匹配返回-2
    * 如果登录成功返回1
    * */
    public int teacherLogin(String aid, String password) throws IOException {

//        InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        Account account =new Account();
        account.setAid(aid);
        account.setPassword(password);
        Account account2 = accountDao.login(account);
        if(account2!=null){
            if(account2.getClasses().equals("T")){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -2;
        }
    }
    /*
     * 管理员登录函数
     * 如果不满足管理员权限返回-1（能查询到账号但不是管理员或查询不到账号）
     * 如果账号密码不匹配返回-2
     * 如果登录成功返回1
     * */

    public int superLogin(String aid, String password) throws IOException {
        Account account =new Account();
        account.setAid(aid);
        account.setPassword(password);
        Account account2 = accountDao.login(account);
        if(account2!=null){
            if(account2.getClasses().equals("S")){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -2;
        }
    }

    public int administerLogin(String aid, String password) throws IOException {

//        InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        Account account =new Account();
        account.setAid(aid);
        account.setPassword(password);
        Account account2 = accountDao.login(account);
        if(account2!=null){
            if(account2.getClasses().equals("A")){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -2;
        }
    }

    @Override
    public int setAdminister(String aid, String classes) throws IOException {
        Account account = new Account();
        account.setAid(aid);
        account.setClasses(classes);
        Account account1 = accountDao.findAccount(account);
        if(account1!=null){
            if(account1.getClasses().equals(classes)){
                return -2;//无需修改
            }else{
                return accountDao.updateAccount(account);//尝试修改
            }
        }else{
            return -1;//输入账号有误
        }
    }

    @Override
    public List<Account> findAllUser() throws IOException {
        return accountDao.findAllUser();
    }

    @Override
    public int ManualImport(String aid, String password, String name, String classes,String tel, String academic) throws IOException{
        Account account=new Account();
        account.setAid(aid);
        account.setPassword(password);
        account.setName(name);
        account.setClasses(classes);
        account.setTel(tel);
        account.setAacademic(academic);
        return accountDao.ManualImport(account);
    }
}
