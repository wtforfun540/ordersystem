package com.shoom.ordersystem.entity;

import java.util.Date;

/**
 * @author wangtao
 * @date 2023/4/12 21:04
 */
public class FinishedOrder {

    /**
     * 订单id
     */
    private int id;

    /**
     * 桌子id
     */
    private String tableId;

    /**
     * 下单时间
     */
    private Date createTime;


    private Date confirmTime;



    /**
     * 产品名称
     */
    private String name;



    /**
     * 数量
     */
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }
}
