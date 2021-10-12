package cn.mingyu.admin.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@Data
public class CategoryVO implements Serializable {
    private static final long serialVersionUID = -1937552829160362727L;
    private Integer id;
    private String categoryName;
    private Integer categoryType;
}
