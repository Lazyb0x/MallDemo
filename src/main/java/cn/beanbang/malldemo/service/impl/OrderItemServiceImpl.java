package cn.beanbang.malldemo.service.impl;

import cn.beanbang.malldemo.mapper.OrderItemMapper;
import cn.beanbang.malldemo.model.OrderItem;
import cn.beanbang.malldemo.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lazyb0x
 * @since 2020-07-10
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
