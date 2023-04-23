package com.shoom.ordersystem.service;

import com.shoom.ordersystem.entity.*;
import com.shoom.ordersystem.mapper.OrderDetailMapper;
import com.shoom.ordersystem.mapper.OrderMapper;
import com.shoom.ordersystem.mapper.TableInfoMapper;
import com.shoom.ordersystem.model.Order;
import com.shoom.ordersystem.model.OrderDetail;
import com.shoom.ordersystem.model.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtao
 * @date 2023/4/7 19:05
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private TableInfoMapper tableInfoMapper;


    public void saveOrder(Order order) {
        orderMapper.insertSelective(order);
    }

    public void updateOrder(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.insertSelective(orderDetail);
    }

    public void batchSaveOredrDetail(List<OrderDetail> orderDetails) {
        for (OrderDetail orderDetail : orderDetails) {
            saveOrderDetail(orderDetail);
        }
    }

    public OrderDetail getOrderDetailById(int id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }

    public List<OrderDetail> getOrderDetailByOrderId(String id) {
        return orderDetailMapper.getOrderDetailByOrderId(id);
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    public List<UnfinishedOrder> getUnfinishedOrders(){
        return orderMapper.getUnfinishedOrders();
    }

    public List<FinishedOrder> getAllFinishedOrders(){

        return orderMapper.getAllFinishedOrders();
    }

    public Order getOrderById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public List<Order> getAllOrders() {
        return orderMapper.selectAll();
    }


    public List<Order> getAllProcessOrder() {
        return orderMapper.getAllProcessOrder();
    }

    public List<Order> getOrdersByWaiterId(int waiterId) {
        return orderMapper.getOrdersByWaiterId(waiterId);
    }

    public List<Order> getOrdersByWaiterIdAndIsFinished(int waiterId, int isFinished) {
        Map<String, Integer> param = new HashMap<>();
        param.put("waiterId", waiterId);
        param.put("isFinished", isFinished);
        return orderMapper.getOrdersByWaiterIdAndIsFinished(param);
    }


    public void updateTableAvailability(String tableId, boolean available) {

        TableInfo tableInfo = tableInfoMapper.selectByPrimaryKey(tableId);

        tableInfo.setAvailable(available);

        tableInfoMapper.updateByPrimaryKey(tableInfo);

    }


}
