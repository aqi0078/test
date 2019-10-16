package com.zdz.test.web.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "info")
public class Info {
    @Id
    @Column(name = "id")
    //主键自增模式
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_time")
    private Date dateTime;

    
//    @PrePersist
//    public void prePersist() {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        createdAt = timestamp;
//        updatedAt = timestamp;
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        updatedAt = new Timestamp(System.currentTimeMillis());
//    }
}
