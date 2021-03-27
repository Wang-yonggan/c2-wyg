package com.wyg.service;

import com.wyg.entity.Account;
import com.wyg.mapper.AccountDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * @wyg entity(s)-->mapper(sDao)-->service(sDao)
 */
public class AccountService {

    private AccountDao accountDao;


    public AccountService() {
        InputStream in = Resources.class.getResourceAsStream("/mybatis-config.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession(true);//自动提交事务
        //5.使用 SqlSession 创建 dao 接口的代理对象
        accountDao = session.getMapper(AccountDao.class);
    }

    // 更新时间
    public void updatetimenow(String id) {
        accountDao.updatetimeById(id, new Date(new java.util.Date().getTime()));
    }

    // 1查询所有记录
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    // 2通过id删除记录
    public void deleteByPrimaryKey(String id) {
        accountDao.deleteByPrimaryKey(id);
    }

    // 3插入记录
    public void insert(Account record) {
        accountDao.insert(record);
    } // 4通过id查找对象

    public Account selectByPrimaryKey(String id) {
        return selectByPrimaryKey(id);
    }

    // 5更新Account
    public void updateByPrimaryKey(Account record) {
        accountDao.updateByPrimaryKey(record);
        updatetimenow(record.getId());
    }

    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    public void transfer(String remitterId, String remitteeId, int money) {
        int money_remitter = selectByPrimaryKey(remitteeId).getMoney();
        if (money_remitter < money) {
            System.out.println("余额不足，转账失败");
            return;
        }
        accountDao.reduceById(remitterId, money);
        updatetimenow(remitterId);
        accountDao.addById(remitteeId, money);
        updatetimenow(remitteeId);
    }
}