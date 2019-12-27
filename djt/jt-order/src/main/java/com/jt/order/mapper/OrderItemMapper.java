package com.jt.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.order.pojo.Order;
import com.jt.order.pojo.OrderItem;
//订单商品  一个订单对应多个商品
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
