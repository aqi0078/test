package com.zdz.test.web.mapper;

import com.zdz.test.web.bean.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author zhangdezhi
 */
@Repository
public interface HelloRepository extends JpaRepository<Info, Long> , JpaSpecificationExecutor<Info>, PagingAndSortingRepository<Info, Long> {
    //https://cloud.tencent.com/developer/article/1429349
    Info findByIdEquals(Long id);

    @Query(nativeQuery = true,value = "select * from info where id in(?1)")
    List<Info> findList(List<Long> ids);

    @Modifying
    @Query(value = "update info set name=?1 where id=?2  ", nativeQuery = true)
    void updateName(String name,Long id);

    @Query(nativeQuery = true,value = "select i.name,i.id,tp.pay_order_no as payOrderNo from  info i join third_party_pay_order tp on i.id=tp.id")
    List<Object[]> findJoin();

    @Query(nativeQuery = true,
            value = "INSERT INTO info (id,name,date_time) VALUES " +
                    "(?1,?2,?3) ON DUPLICATE KEY UPDATE name = name+1"
//                    "status = CASE WHEN count >= ?5 THEN 2 ELSE 0 END"
    )
    @Modifying
    void addOrUpdate(int id, String name, Date date);
}
