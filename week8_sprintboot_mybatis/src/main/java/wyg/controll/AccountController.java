package wyg.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wyg.entity.Account;
import wyg.service.AccountService;

import java.sql.Date;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //查询所有
    @RequestMapping("/account/all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    //保存account对象
    @RequestMapping("/account/save")
    //暂时没看requestBody
    public void saveAccount(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam
            ("money") Integer money) {
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date(new java.util.Date().getTime());
        Account account = new Account(id, name, money, d1, d1);
        accountService.insert(account);
    }

    @RequestMapping("/account/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId,
                         @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money) {
        accountService.transfer(remitterId, remitteeId, money);
    }


}