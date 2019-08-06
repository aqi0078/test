package com.zdz.test.web.mapper;

import com.zdz.test.web.bean.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangdezhi
 */
@Repository
public interface HelloRepository extends JpaRepository<Info, Long> , JpaSpecificationExecutor<Info>, PagingAndSortingRepository<Info, Long> {
    //https://cloud.tencent.com/developer/article/1429349
    Info findByIdEquals(Long id);
}
