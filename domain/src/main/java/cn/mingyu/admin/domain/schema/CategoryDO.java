package cn.mingyu.admin.domain.schema;

import cn.mingyu.admin.domain.BaseObj;
import lombok.Data;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@Data
public class CategoryDO extends BaseObj {
    private static final long serialVersionUID = -1651201088960938603L;
    private Integer parentId;
    private String categoryName;
    private Integer categoryType;
    private Integer weight;
    private Integer deleted;
}
