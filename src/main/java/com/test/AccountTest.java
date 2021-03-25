//package com.test;
//
//import com.dao.AccountMapper;
//import com.dao.ComputerRoomMapper;
//import com.dao.imp.AccountMapperImp;
//import com.dao.imp.ComputerRoomMapperImp;
//import com.entity.Account;
//import com.entity.ComputerRoom;
//
//import java.io.IOException;
//import java.util.List;
//
//public class AccountTest {
//    public static void main(String[] args) throws IOException {
//        AccountMapper accountMapper=new AccountMapperImp();
//        Account account = new Account();
//        account.setAid("2018211912");
//        account.setPassword("2018211912");
//        boolean flag = accountMapper.isManager("2018211912");
//        if(flag){
//            Account account1=accountMapper.login(account);
//            //System.out.println(account);
//
//            //List<Account> l=accountMapper.findAllTeacher();
//            //System.out.println(l);
//
//            //ComputerRoomMapper computerRoomMapper=new ComputerRoomMapperImp();
//            //List<ComputerRoom> rooms=computerRoomMapper.findAllInHaiDian();
//            //List<ComputerRoom> rooms=computerRoomMapper.findAllFitRoomsInShaHe(40);
//            //List<ComputerRoom> rooms=computerRoomMapper.ListAllRoomsOnAFloorInH(3);
//            System.out.println(account1.getClasses());
//        }else{
//            System.out.println("Error");
//        }
//    }
//
//}
