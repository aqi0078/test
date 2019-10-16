package com.zdz.test.web.service.impl;

import com.zdz.test.web.bean.Info;
import com.zdz.test.web.mapper.HelloRepository;
import com.zdz.test.web.service.HelloService;
import com.zdz.test.web.tool.aspect.logTrace.LogTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Autowired
    HelloRepository helloRepository;
    @Transactional
    @Override
    @LogTrace
    public void sayHi() {
        Info info=helloRepository.findByIdEquals(1L);
        System.out.println("====say hi====="+info.getName());
        helloRepository.addOrUpdate(4,"000",new Date());
        System.out.println("====say hi====="+info.getName());

    }
    @Transactional
    @Override
    public void updateNameList(){
        System.out.println("==updateNameList===");
        List<Long> ids=new ArrayList<>();
        ids.add(11L);
        ids.add(23L);
        ids.add(33L);
        int joinList=helloRepository.updateNameList("zdz",ids);

        System.out.println("====="+joinList);
    }
    @Override
    public void join(){
        List<Object[]> joinList=helloRepository.findJoin();
        for (int i = 0; i < joinList.size(); i++) {
            Object[] obj=joinList.get(i);
            System.out.println("----"+obj[0]);
        }
    }
    //转换实体类
    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
        List<T> returnList = new ArrayList<T>();
        if(CollectionUtils.isEmpty(list)){
            return returnList;
        }
        Object[] co = list.get(0);
        Class[] c2 = new Class[co.length];
        //确定构造方法
        for (int i = 0; i < co.length; i++) {
            if(co[i]!=null){
                c2[i] = co[i].getClass();
            }else {
                c2[i]=String.class;
            }
        }
        for (Object[] o : list) {
            Constructor<T> constructor = clazz.getConstructor(c2);
            returnList.add(constructor.newInstance(o));
        }
        return returnList;
    }
    @Override
    public void findList(){
        List<Long> ids=new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        List<Info> list=helloRepository.findList(ids);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Override
    public void updateName(){
        sayHi();
        helloRepository.updateName("zdz1123",1L);
        sayHi();
    }

    @Override
    public void insert(){
        Info info=new Info();
        info.setName("11");
        helloRepository.save(info);
        List<Info> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Info in=new Info();
            in.setName(String.valueOf(i));
            list.add(in);
        }
     //   helloRepository.saveAll(list);
    }

    @Override
    public void page() {
        int page = 0; //page:当前页的索引。注意索引都是从 0 开始的。
        int size = 3;// size:每页显示 3 条数据
//        PageRequest pageable= new PageRequest(page, size);
        Pageable pageable = PageRequest.of(0, 3);
        Page<Info> p = helloRepository.findAll(pageable);
        System.out.println("数据的总条数："+p.getTotalElements());
        System.out.println("总页数："+p.getTotalPages());
        List<Info> list = p.getContent();
        for (Info users : list) {
            System.out.println(users);
        }
    }

    /**
     * 动态sql➕分页
     * @param name
     * @param id
     */

    @Override
    public void getSomeWherePage(String name, Integer id) {
        Pageable pageable = PageRequest.of(1, 2);
        Specification<Info> authorityQuery=new Specification<Info>() {
            @Override
            public Predicate toPredicate(Root<Info> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates=new ArrayList<>();
                if(name!=null) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
                }
                if(id!=null) {
                    predicates.add(criteriaBuilder.equal(root.get("id"), id));
                }
                //1.
                query.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
                query.orderBy(criteriaBuilder.asc(root.get("id")),criteriaBuilder.asc(root.get("dateTime")));
                return query.getRestriction();
               //2 return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Page<Info> p = helloRepository.findAll(authorityQuery,pageable);
        System.out.println("数据的总条数："+p.getTotalElements());
        System.out.println("总页数："+p.getTotalPages());
        List<Info> list = p.getContent();
        for (Info users : list) {
            System.out.println(users);
        }
    }

    /**
     * 多添件连接，or,等复杂连接
     */

    @Override
    public void getSomeWhere(){
        Specification<Info> specification=new Specification<Info>() {
            @Override
            public Predicate toPredicate(Root<Info> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1=criteriaBuilder.equal(root.get("id"),1);
                Predicate predicate2=criteriaBuilder.equal(root.get("name"),"1");
                return criteriaBuilder.and(predicate1,predicate2);
            }
        };
        List<Info> list =helloRepository.findAll(specification);
        for (Info users : list) {
            System.out.println(users);
        }
        System.out.println("+==================");
        Specification<Info> specification1=new Specification<Info>() {
            @Override
            public Predicate toPredicate(Root<Info> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1=criteriaBuilder.equal(root.get("id"),1);
                Predicate predicate2=criteriaBuilder.equal(root.get("name"),"1");
                return criteriaBuilder.or(predicate1,predicate2);
            }
        };
        List<Info> list1 =helloRepository.findAll(specification1);
        for (Info users : list1) {
            System.out.println(users);
        }
//        1 and 2,也可以 or
//        helloRepository.findAll(Specification.where(specification).and(specification1));
    }







}
