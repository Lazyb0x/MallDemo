package cn.beanbang.malldemo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lazyb0x
 * @since 2020-07-10
 */
@TableName("order_info")
public class Order extends Model<Order> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long uid;

    private String name;

    private String sn;

    /**
     * Map（商品id，订单项）
     */
    @TableField(exist = false)
    private Map<Long, OrderItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Map<Long, OrderItem> getItems() {
        return items;
    }

    public void setItems(Map<Long, OrderItem> items) {
        this.items = items;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", items=" + items +
                '}';
    }
}
