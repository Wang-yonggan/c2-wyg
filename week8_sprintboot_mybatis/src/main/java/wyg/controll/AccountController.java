package wyg.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wyg.entity.Account;
import wyg.service.AccountService;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //不用Rest风格
    //查询所有
    @RequestMapping("/account/all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    //保存account对象
    @RequestMapping("/account/save")
    public void saveAccount(@RequestBody Account account) {
        accountService.insert(account);
    }

    @RequestMapping("/account/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId,
                         @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money) {
        accountService.transfer(remitterId, remitteeId, money);
    }


}