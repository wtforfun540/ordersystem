package com.shoom.ordersystem.controller;

import com.shoom.ordersystem.cons.Consts;
import com.shoom.ordersystem.entity.RequestOrderParam;
import com.shoom.ordersystem.model.Order;
import com.shoom.ordersystem.model.OrderDetail;
import com.shoom.ordersystem.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Transactional
    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody RequestOrderParam param) {

        //封装订单
        Order order = new Order();
        order.setTableId(param.getTableId());
        order.setWaiterId(param.getWaiterId());
        order.setIsfinished(Consts.FALSE);
        //保存订单
        orderService.saveOrder(order);

        //获取订单详情
        List<OrderDetail> orderDetails = param.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(order.getId());
        }

        //保存订单详情
        orderService.batchSaveOredrDetail(orderDetails);

        //更新桌面状态
        orderService.updateTableAvailability(param.getTableId(), Consts.FALSE);

        //// TODO: 2023/4/10  推送订单到后厨
    

        return ResponseEntity.ok().build();
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
        List<Order> orders = orderService.getAllOrders();
        for(Order order : orders){
            List<OrderDetail> orderDetails =orderService.getOrderDetailByOrderId(order.getId());
            order.setOrderDetails(orderDetails);
        }
        return ResponseEntity.ok(orders);
    }

    /**
     *
     * 更新单个订单记录状态
     * 0，已下单
     * 1，待取餐
     * 2，已取餐
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/orderDetail/{id}")
    public ResponseEntity updateOrderDetailStatus(@PathVariable int id, @RequestParam int status) {

        OrderDetail orderDetail = orderService.getOrderDetailById(id);
        orderDetail.setStatus(status);

        orderService.updateOrderDetail(orderDetail);

        return ResponseEntity.ok().build();
    }

    /**
     * 结束某个订单（用餐结束）
     * 桌子回到可用状态
     *
     * @param id
     * @return
     */
    @Transactional
    @GetMapping("/finishOrder/{id}")
    public ResponseEntity finishOrder(@PathVariable Integer id) {

        //获取订单
        Order order = orderService.getOrderById(id);
        order.setIsfinished(Consts.TRUE);
        //更新订单
        orderService.updateOrder(order);
        //更新桌面状态
        orderService.updateTableAvailability(order.getTableId(), Consts.TRUE);

        return ResponseEntity.ok().build();
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
