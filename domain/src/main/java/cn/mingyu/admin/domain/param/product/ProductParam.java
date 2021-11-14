package cn.mingyu.admin.domain.param.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: ProductParam
 * Description:
 * date: 2021/11/14 下午8:53
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class ProductParam {
    private Integer id;
    private String productName;
    private String productDesc;
    private BigDecimal price;
    private Integer status;
    private List<String> productImages;
}
