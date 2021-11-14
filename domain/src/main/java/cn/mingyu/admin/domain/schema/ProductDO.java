package cn.mingyu.admin.domain.schema;

import cn.mingyu.admin.domain.BaseObj;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: ProductDO
 * Description:
 * date: 2021/11/14 下午8:29
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class ProductDO extends BaseObj {
    private String productName;
    private String productDesc;
    private BigDecimal price;
    private Integer status;
    private String productImages;
}
