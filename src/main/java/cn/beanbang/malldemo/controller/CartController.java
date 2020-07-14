package cn.beanbang.malldemo.controller;

import cn.beanbang.malldemo.domain.to.Result;
import cn.beanbang.malldemo.service.ICartService;
import cn.beanbang.malldemo.service.impl.CartServiceImpl;
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
    ICartService cartService;

    @GetMapping
    public Result list(){
        return Result.success(cartService.list());
    }

    @PostMapping
    public Result add(Long goodId){
        boolean res = cartService.add(goodId);
        return Result.isSuccess(res);
    }

    @PutMapping
    public Result edit(Long goodId, int num){
        boolean res = cartService.add(goodId, num);
        return Result.isSuccess(res);
    }

    @DeleteMapping
    public Result remove(Long goodId){
        boolean res = cartService.remove(goodId);
        return Result.isSuccess(res);
    }

    /**
     * 把购物车的内容保存到订单
     * @return 保存的订单id
     */
    @PostMapping("/settle")
    public Result settle(){
        Long res = cartService.settle();
        return Result.success(res);
    }

}
