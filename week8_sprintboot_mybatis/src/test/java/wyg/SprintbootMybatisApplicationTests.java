package wyg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wyg.entity.Account;
import wyg.service.AccountService;

@SpringBootTest
class SprintbootMybatisApplicationTests {
    private AccountService accountService = new AccountService();

    @Test
    void contextLoads() {
        Account account = new Account();
        account.setId("10");
        account.setMoney(200);
        account.setName("name");
        accountService.insert(account);
    }

}
