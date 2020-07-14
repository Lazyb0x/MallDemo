package cn.beanbang.malldemo.service;

import cn.beanbang.malldemo.mapper.OrderItemMapper;
import cn.beanbang.malldemo.mapper.OrderMapper;
import cn.beanbang.malldemo.domain.po.Order;
import cn.beanbang.malldemo.domain.po.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private HttpSession session;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    /**
     * 通过id添加一个订单项
     * @param goodId 商品id
     * @return 是否添加成功
     */
    public boolean add(Long goodId){
        return add(goodId, 1);
    }

    /**
     * 添加指定数量的订单项
     * @param goodId 商品id
     * @param num 商品的数量
     * @return true
     */
    public boolean add(Long goodId, int num) {
        Map<Long, OrderItem> cartMap = getCart();
        OrderItem oi = cartMap.get(goodId);
        // 购物车中是否已经有了该商品
        if (oi != null) {
            oi.setNumber(num + oi.getNumber());
            // 订单项的数量为0，就移除
            if (oi.getNumber()==0){
                cartMap.remove(goodId);
            }
        }
        else {
            oi = new OrderItem();
            oi.setNumber(num);
            oi.setGoodId(goodId);
            cartMap.put(goodId, oi);
        }

        return true;
    }

    /**
     * 列出购物车列表
     * @return map 键值对列表
     */
    public Object list(){
        Map<Long, OrderItem> cartMap = getCart();
        return cartMap.entrySet().toArray();
    }

    /**
     * 移除商品
     * @param goodId
     * @return
     */
    public boolean remove(Long goodId){
        Map<Long, OrderItem> cartMap = getCart();
        cartMap.remove(goodId);
        return true;
    }

    /**
     * 从session中获取购物车对象
     * @return
     */
    public Map<Long, OrderItem> getCart() {
        Map<Long, OrderItem> cartMap;
        cartMap = (Map) session.getAttribute("shoppingCart");
        if (cartMap == null) {
            cartMap = new HashMap<>();
            session.setAttribute("shoppingCart", cartMap);
        }
        return cartMap;
    }

    /**
     * 保存购物车，下单
     * 把购物车的内容存到订单和订单项中
     * @return
     */
    public long settle() {
        Map<Long, OrderItem> cartMap = getCart();

        Order order = new Order();
        // 先把时间戳当序列号
        String sn = Long.toString(System.currentTimeMillis());
        order.setSn(sn);
        order.setUid(getUserId());

        orderMapper.insert(order);

        for (OrderItem oi : cartMap.values()){
            // 设置订单项的订单id
            oi.setOrderId(order.getId());
            orderItemMapper.insert(oi);
        }

        return order.getId();
    }

    /**
     * 没有用户表，假设一个id
     * @return 用户id
     */
    public long getUserId() {
        return 1234;
    }
}
