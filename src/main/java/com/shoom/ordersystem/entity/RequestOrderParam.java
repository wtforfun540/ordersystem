package com.shoom.ordersystem.entity;

import com.shoom.ordersystem.model.OrderDetail;

import java.util.List;

/**
 *
 * 下单请求实体类
 * @author wangtao
 * @date 2023/4/7 16:31
 */
public class RequestOrderParam {

    /**
     * 桌子编号
     */
    private int tableId;

    /**
     * 服务员id
     */
    private int waiterId;

    /**
     * 订单详情
     */
    private List<OrderDetail> orderDetails;

    public RequestOrderParam(int tableId, int waiterId, List<OrderDetail> orderDetails) {
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.orderDetails = orderDetails;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
