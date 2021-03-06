package cn.beanbang.malldemo.service.impl;

import cn.beanbang.malldemo.mapper.GoodMapper;
import cn.beanbang.malldemo.domain.po.Good;
import cn.beanbang.malldemo.service.IGoodService;
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
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

}
