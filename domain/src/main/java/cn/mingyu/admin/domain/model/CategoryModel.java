package cn.mingyu.admin.domain.model;

import cn.mingyu.admin.domain.BaseObj;
import lombok.Data;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@Data
public class CategoryModel extends BaseObj {
    private static final long serialVersionUID = -6420874029627521241L;
    private Integer parentId;
    private String categoryName;
    private Integer categoryType;
    private Integer weight;
    private Integer deleted;
}
