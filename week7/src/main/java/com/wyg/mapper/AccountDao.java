package com.wyg.mapper;

import com.wyg.entity.Account;

import java.util.Date;
import java.util.List;

/**
 * @me function-->id      <abstract  param and return ></abstract>   void f();
 * param-->jinjia
 */
public interface AccountDao {
    // 1查询所有记录
    List<Account> findAll();

    // 2通过id删除记录
    int deleteByPrimaryKey(String id);

    // 3插入记录
    int insert(Account record);

    // 4通过id查找对象
    Account selectByPrimaryKey(String id);

    // 5更新Account
    int updateByPrimaryKey(Account record);

    // 价钱
    void addById(String id, int money);

    //扣钱
    void reduceById(String id, int money);

    //更新时间
    void updatetimeById(String id, Date date);
}
