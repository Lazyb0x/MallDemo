package cn.beanbang.malldemo.controller;


import cn.beanbang.malldemo.domain.po.Good;
import cn.beanbang.malldemo.domain.to.Result;
import cn.beanbang.malldemo.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  商品控制器
 * </p>
 *
 * @author Lazyb0x
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/api/good")
public class GoodController {

    @Autowired
    IGoodService goodService;

    /**
     * 列出所有商品
     * @return 商品列表
     */
    @GetMapping
    public Result list(){
        return Result.success(goodService.list());
    }

    /**
     * 添加商品
     * @param good 商品 json 对象
     * @return 包含有 Id 的商品对象
     */
    @PostMapping
    public Result add(@RequestBody Good good){
        return Result.success(goodService.save(good));
    }

    /**
     * 更改商品信息
     * @param good 商品 json 对象
     * @return 是否修改成功
     */
    @PutMapping
    public Result update(@RequestBody Good good){
        boolean res = goodService.saveOrUpdate(good);
        return Result.isSuccess(res);
    }

    /**
     * 删除一个商品
     * @param id 商品的主键
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        boolean res = goodService.removeById(id);
        return Result.isSuccess(res);
    }
}

