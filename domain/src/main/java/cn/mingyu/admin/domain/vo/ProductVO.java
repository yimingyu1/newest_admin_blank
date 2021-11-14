package cn.mingyu.admin.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: ProductVO
 * Description:
 * date: 2021/11/14 下午10:07
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class ProductVO {
    private Integer id;
    private String productName;
    private String productDesc;
    private BigDecimal price;
    private Integer status;
    private List<String> productImages;
}
