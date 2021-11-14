package cn.mingyu.admin.domain.model;

import cn.mingyu.admin.domain.BaseObj;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: ProductModel
 * Description:
 * date: 2021/11/14 下午8:45
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class ProductModel extends BaseObj {
    private String productName;
    private String productDesc;
    private BigDecimal price;
    private Integer status;
    private List<String> productImages;

}
