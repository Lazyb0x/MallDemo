package cn.beanbang.malldemo.controller;

import cn.beanbang.malldemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 购物车控制器
 *
 * @author Lazyb0x
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public Object list(){
        return cartService.list();
    }

    @PostMapping
    public boolean add(Long goodId){
        return cartService.add(goodId);
    }

    @PutMapping
    public boolean edit(Long goodId, int num){
        return cartService.add(goodId, num);
    }

    @DeleteMapping
    public boolean remove(Long goodId){
        return cartService.remove(goodId);
    }

    /**
     * 把购物车的内容保存到订单
     * @return 保存的订单id
     */
    @PostMapping("/settle")
    public Long settle(){
        return cartService.settle();
    }
}
