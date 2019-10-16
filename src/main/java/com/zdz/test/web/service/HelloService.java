package com.zdz.test.web.service;

public interface HelloService {
    void sayHi();
    void findList();
    void updateName();
    void insert();

    /**
     * 分页
     */
    void page();
    /**
     * 动态sql➕分页
     * @param name
     * @param id
     */
    void getSomeWherePage(String name,Integer id);
    /**
     * 多添件连接，or,等复杂连接
     */
    public void getSomeWhere();

    /**
     * 表连接
     */
    void join();

    void updateNameList();
}
