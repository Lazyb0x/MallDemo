package cn.beanbang.malldemo.service.impl;

import cn.beanbang.malldemo.mapper.OrderItemMapper;
import cn.beanbang.malldemo.mapper.OrderMapper;
import cn.beanbang.malldemo.model.Order;
import cn.beanbang.malldemo.model.OrderItem;
import cn.beanbang.malldemo.service.IOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lazyb0x
 * @since 2020-07-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    OrderItemMapper orderItemMapper;

    @Override
    public List<Order> list(){
        List<Order> orders = super.list();

        for (Order o : orders){
            // 填充 Order 的订单项 map
            QueryWrapper<OrderItem> oiWrapper = new QueryWrapper<>();
            oiWrapper.lambda().eq(OrderItem::getOrderId, o.getId());
            List<OrderItem> ois = orderItemMapper.selectList(oiWrapper);

            Map<Long, OrderItem> items = new HashMap<>();
            for (OrderItem oi : ois){
                items.put(oi.getGoodId(), oi);
            }
            o.setItems(items);
        }

        return orders;
    }
}
