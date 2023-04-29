package com.shoom.ordersystem.controller;
import com.shoom.ordersystem.cons.Consts;
import com.shoom.ordersystem.entity.*;
import com.shoom.ordersystem.model.Order;
import com.shoom.ordersystem.model.OrderDetail;
import com.shoom.ordersystem.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
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


    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("hello world");
    }


    /**
     * 增加订单
     * 1，保存订单信息到orders表
     * 2，保存订单详情到orderdetail
     * 3，将桌子的available改为0
     * <p>
     * 需要开启事务
     * <p>
     * 临时先用map接收参数，后面再改
     *
     * @param @RequestBody RequestOrderParam param
     * @return
     */
    @Transactional
    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody Map<String, Object> map) {
        String deskNumber = (String) map.get("deskNumber");
        Order existOrder=orderService.getOrderByTableID(deskNumber);
        if(existOrder!=null){// 加菜
            updateOrder(map,existOrder);
            Integer orderid=existOrder.getId();
            insertOrderDetails(map, orderid);
        }else{ //新开桌
            Order order= createOrder(map);
            Integer orderid=order.getId();
            insertOrderDetails(map, orderid);
        }
        return ResponseEntity.ok().build();
    }

    public Order createOrder(Map<String, Object> map){
        Order order = new Order();
        order.setTableId((String) map.get("deskNumber"));
        order.setWaiterId("8");
        order.setIsfinished(Consts.FALSE);
        order.setTotalPrice(new BigDecimal(map.get("totalPrice").toString()));
        orderService.saveOrder(order);
        return order;
    }

    public void insertOrderDetails(Map<String, Object> map,Integer orderid){
        List<Map<String, Object>> items = (List<Map<String, Object>>) map.get("items");
        for (Map<String, Object> item : items) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderid);
            orderDetail.setProductId((int) item.get("id"));
            orderDetail.setCount((int) item.get("quantity"));
            orderDetail.setProductName((String) item.get("name"));
            double price = Double.valueOf(item.get("price").toString());
            orderDetail.setProductPrice(price);
            orderDetail.setStatus(Consts.ORDERED);
            orderService.saveOrderDetail(orderDetail);
        }
    }

    public void updateOrder(Map<String, Object> map,Order existOrder){
        BigDecimal totalPrice=  new BigDecimal(map.get("totalPrice").toString());
        existOrder.setTotalPrice(totalPrice.add(existOrder.getTotalPrice()));
        orderService.updateOrder(existOrder);
    }


    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id) {
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
    public ResponseEntity getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    /**
     * 获取所有订单
     *
     * @return
     */
    @GetMapping("/order")
    public ResponseEntity getAllOrders() {
        System.out.println("获取所有订单");
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            List<OrderDetail> orderDetails = orderService.getOrderDetailByOrderId(order.getId());
            order.setOrderDetails(orderDetails);
        }
        return ResponseEntity.ok(orders);
    }


    /**
     * 获取所有进行中的订单（按照每桌为最小单元）
     * @return
     */
    @GetMapping("/allProcessOrder")
    public ResponseEntity getAllProcessOrder() {
 //String
        System.out.println("获取所有进行中的订单");
        List<Order> orders = orderService.getAllProcessOrder();
        for (Order order : orders) {
            List<OrderDetail> orderDetails = orderService.getOrderDetailByOrderId(order.getId());
            order.setOrderDetails(orderDetails);
        }
        return ResponseEntity.ok(orders);
    }



    /**
     * 获取所有进行中的订单（按照每桌为最小单元）
     * @return
     */
    @GetMapping("/compleatedProcessdOrder")
    public ResponseEntity allCompleatedProcessdOrder() {
        //String
        System.out.println("获取所有前台当天处理的订单");
        List<Order> orders = orderService.allCompleatedProcessdOrder();
        for (Order order : orders) {
            List<OrderDetail> orderDetails = orderService.getCompleteOrderDetailByOrderId(order.getId());
            order.setOrderDetails(orderDetails);
        }
        return ResponseEntity.ok(orders);
    }


    /**
     * 更新单个订单记录状态
     * 0，已下单
     * 1，待取餐
     * 2，已取餐
     *
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/orderDetail/{id}")
    public ResponseEntity updateOrderDetailStatus(@PathVariable int id, @RequestParam int status) {
        OrderDetail orderDetail = orderService.getOrderDetailById(id);
        if(orderDetail.getStatus()==0){
            orderDetail.setStatus(status);
            orderService.updateOrderDetail(orderDetail);
        }
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
    public ResponseEntity finishOrder(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        if(order.getIsfinished()==false){
            order.setIsfinished(Consts.TRUE);
            orderService.updateOrder(order);
            List<OrderDetail> orderDetails = orderService.getOrderDetailByOrderId(order.getId());
            for (OrderDetail orderdetail : orderDetails) {
                orderdetail.setStatus(2);
                orderService.updateOrderDetail(orderdetail);
            }
        }
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

    @GetMapping("/getUnfinishedOrders")
    public ResponseEntity getUnfinishedOrders() {
        List<UnfinishedOrder> unfinishedOrderlist = orderService.getUnfinishedOrders();
        return ResponseEntity.ok(unfinishedOrderlist);
    }


    @GetMapping("/getAllFinishedOrders")
    public ResponseEntity getAllFinishedOrders() {
        List<FinishedOrder> finishedOrderlist =orderService.getAllFinishedOrders();
        return ResponseEntity.ok(finishedOrderlist);
    }




}
