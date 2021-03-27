import com.wyg.entity.Account;
import com.wyg.service.AccountService;

import java.sql.Date;

/**
 * @ClassName : AccountsTest
 * @Author : wang-yonggan
 * @Date: 2021-03-27 16:06
 */

public class AccountsTest {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Account account = new Account("a", "b", 2, new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()));
        System.out.println(account);
        accountService.insert(account);
    }
}
