package cn.beanbang.malldemo.controller;


import cn.beanbang.malldemo.model.Good;
import cn.beanbang.malldemo.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<Good> list(){
        return goodService.list();
    }

    /**
     * 添加商品
     * @param good 商品 json 对象
     * @return 包含有 Id 的商品对象
     */
    @PostMapping
    public Good add(@RequestBody Good good){
        goodService.save(good);
        return good;
    }

    /**
     * 更改商品信息
     * @param good 商品 json 对象
     * @return 是否修改成功
     */
    @PutMapping
    public boolean update(@RequestBody Good good){
        return goodService.saveOrUpdate(good);
    }

    /**
     * 删除一个商品
     * @param id 商品的主键
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id){
        return goodService.removeById(id);
    }
}

