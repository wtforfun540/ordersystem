package com.shoom.ordersystem.controller;

import com.shoom.ordersystem.entity.RequestOrderParam;
import com.shoom.ordersystem.model.Order;
import com.shoom.ordersystem.model.OrderDetail;
import com.shoom.ordersystem.model.TableInfo;
import com.shoom.ordersystem.service.OrderServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtao
 * @date 2023/4/7 14:17
 */
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    /**
     * 增加订单
     * 1，保存订单信息到orders表
     * 2，保存订单详情到orderdetail
     * 3，将桌子的available改为0
     * <p>
     * 需要开启事务
     *
     * @param param
     * @return
     */
    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody RequestOrderParam param) {

        Order order = new Order();
        order.setTableId(param.getTableId());
        order.setWaiterId(param.getWaiterId());
        order.setIsfinished(0);

        orderService.saveOrder(order);

        List<OrderDetail> orderDetails = param.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(order.getId());
        }

        orderService.batchSaveOredrDetail(orderDetails);

        orderService.updateTableAvailability(param.getTableId(), 0);

        System.out.println("下单");
        return null;
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        System.out.println("删除订单" + id);
        return null;
    }

    /**
     * 获取某个订单
     *
     * @param id
     * @return
     */
    @GetMapping("/order/{id}")
    public ResponseEntity getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    /**
     * 获取所有订单
     *
     * @return
     */
    @GetMapping("/order")
    public ResponseEntity getAllOredrs() {
        System.out.println("获取所有订单");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    /**
     * 结束某个订单（用餐结束）
     * 桌子回到可用状态
     *
     * @param id
     * @return
     */
    @GetMapping("/finishOrder/{id}")
    public ResponseEntity finishOrder(@PathVariable Integer id) {


        Order order = orderService.getOrderById(id);
        order.setIsfinished(1);
        orderService.updateOrder(order);

        orderService.updateTableAvailability(order.getTableId(), 1);

        return null;
    }

    /**
     * 获取某个服务员服务的所有订单（包括进行中的和已结束的）
     *
     * @param waiterId
     * @return
     */
    @GetMapping("/orders/waiters/{waiterId}")
    public ResponseEntity getAllOrdersByWaiterId(@PathVariable Integer waiterId, Integer isFinished) {
        System.out.println("获取服务员的所有订单" + waiterId + " " + isFinished);
        if (isFinished == null) {
            return ResponseEntity.ok(orderService.getOrdersByWaiterId(waiterId));
        } else {
            return ResponseEntity.ok(orderService.getOrdersByWaiterIdAndIsFinished(waiterId, isFinished));
        }
    }


}
