package wyg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyg.entity.Account;
import wyg.mapper.AccountMapper;

import java.sql.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    // 更新时间
    public void updatetimenow(String id) {
        accountMapper.updatetimeById(id, new Date(new java.util.Date().getTime()));
    }

    // 1查询所有记录
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    // 2通过id删除记录
    public void deleteByPrimaryKey(String id) {
        accountMapper.deleteByPrimaryKey(id);
    }

    // 3插入记录
    public void insert(Account record) {
        accountMapper.insert(record);
    } // 4通过id查找对象

    public Account selectByPrimaryKey(String id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    // 5更新Account
    public void updateByPrimaryKey(Account record) {
        accountMapper.updateByPrimaryKey(record);
        updatetimenow(record.getId());
    }


    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    public void transfer(String remitterId, String remitteeId, int money) {
        if (reduce_money(remitterId, money) == 1)
            add_money(remitteeId, money);
    }

    // 存钱
    public void add_money(String id, int money) {
        accountMapper.addById(id, money);
        updatetimenow(id);
    }

    // 取钱
    public int reduce_money(String id, int money) {
        int money_remitter = selectByPrimaryKey(id).getMoney();
        if (money_remitter < money) {
            System.out.println("余额不足，操作失败");
            return 0;
        }
        accountMapper.reduceById(id, money);
        updatetimenow(id);
        return 1;
    }
}