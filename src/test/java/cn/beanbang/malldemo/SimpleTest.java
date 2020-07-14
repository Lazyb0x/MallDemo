package cn.beanbang.malldemo;

import cn.beanbang.malldemo.mapper.GoodMapper;
import cn.beanbang.malldemo.domain.po.Good;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SimpleTest {

    @Resource
    private GoodMapper goodMapper;

    @Test
    public void testSelect(){
        List<Good> goodList = goodMapper.selectList(null);
        for (Good good : goodList) {
            System.out.println(good);
        }
    }

}
