package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//注意：将对象存入Session，且Session再放到redis里，则对象要进行系列化
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginVO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String email;
}

