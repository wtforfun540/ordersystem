package com.shoom.ordersystem.entity;

import com.shoom.ordersystem.model.OrderDetail;

import java.math.BigDecimal;
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
     * 桌子编号/名字
     */
    private String deskNumber;

    private BigDecimal totalPrice;

    /**
     * 订单详情
     */
    private List<OrderDetail> items;

    public RequestOrderParam(int tableId, int waiterId, List<OrderDetail> orderDetails) {
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.items = orderDetails;
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
        return items;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.items = orderDetails;
    }
}
