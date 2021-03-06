package wyg.mapper;
//xml-->mapper-->service-->controller-->app

import org.apache.ibatis.annotations.Mapper;
import wyg.entity.Account;

import java.sql.Date;
import java.util.List;

@Mapper
public interface AccountMapper {
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
    int addById(String id, int money);

    //扣钱
    int reduceById(String id, int money);

    //更新时间
    int updatetimeById(String id, Date date);
}
