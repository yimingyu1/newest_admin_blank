package cn.mingyu.admin.domain.param.category;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@Data
public class CategoryParam implements Serializable {
    private static final long serialVersionUID = -5949228879459233733L;

    private Integer id;
    private Integer parentId;
    private String categoryName;
    private Integer categoryType;
    private Integer weight;
    private Integer deleted;
}
