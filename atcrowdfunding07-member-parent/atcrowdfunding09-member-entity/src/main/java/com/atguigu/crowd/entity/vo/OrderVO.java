package com.atguigu.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    //    主键
    private Integer id;

    //    订单号
    private String orderNum;

    //    支付宝流水单号
    private String payOrderNum;

    //    订单金额
    private Double orderAmount;

    //    是否开发票   （收集得来的）
    private Integer invoice;

    //    发票抬头   （收集得来的）
    private String invoiceTitle;

    //    备注    （收集得来的）
    private String orderRemark;

    //    地址id     （收集得来的）
    private String addressId;

    //    订购项目vo      （收集得来的）
    private OrderProjectVO orderProjectVO;

}

