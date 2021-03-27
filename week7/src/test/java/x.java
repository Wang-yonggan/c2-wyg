import com.wyg.entity.Account;
import com.wyg.service.AccountService;

import java.util.List;

/**
 * @ClassName : x
 * @Author : wang-yonggan
 * @Date: 2021-03-27 16:06
 */


public class x {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
//        accountService.insert(new Account("1", "a", 200, new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime())));
//        accountService.insert(new Account("2", "b", 200, new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime())));
//        accountService.insert(new Account("3", "c", 200, new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime())));
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        accountService.transfer("1", "2", 410);
    }


}
