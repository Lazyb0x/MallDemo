package cn.beanbang.malldemo;

import cn.beanbang.malldemo.mapper.GoodMapper;
import cn.beanbang.malldemo.model.Good;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
