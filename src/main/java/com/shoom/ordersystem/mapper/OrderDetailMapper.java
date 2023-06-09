package com.shoom.ordersystem.mapper;

import com.shoom.ordersystem.model.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Fri Apr 07 19:38:52 PDT 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Fri Apr 07 19:38:52 PDT 2023
     */
    int insert(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Fri Apr 07 19:38:52 PDT 2023
     */
    int insertSelective(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Fri Apr 07 19:38:52 PDT 2023
     */
    OrderDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Fri Apr 07 19:38:52 PDT 2023
     */
    int updateByPrimaryKeySelective(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Fri Apr 07 19:38:52 PDT 2023
     */
    int updateByPrimaryKey(OrderDetail row);

    List<OrderDetail> getOrderDetailByOrderId(Integer id);

    List<OrderDetail> getCompleteOrderDetailByOrderId(Integer id);
}
