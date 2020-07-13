package cn.beanbang.malldemo.controller;


import cn.beanbang.malldemo.model.Order;
import cn.beanbang.malldemo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  订单控制器
 * </p>
 *
 * @author Lazyb0x
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public List<Order> list(){
        return orderService.list();
    }


}

