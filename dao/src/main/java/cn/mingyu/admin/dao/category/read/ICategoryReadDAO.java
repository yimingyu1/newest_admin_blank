package cn.mingyu.admin.dao.category.read;

import cn.mingyu.admin.domain.schema.CategoryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
public interface ICategoryReadDAO {

    @Results(id = "categoryResult", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "deleted", property = "deleted"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })

    @Select("select * from category where category_type = #{categoryType}")
    List<CategoryDO> getCategoryListByType(@Param("categoryType") int categoryType);


    @Select("select * from category where parent_id = #{parentId} and category_type = #{categoryType}")
    @ResultMap("categoryResult")
    List<CategoryDO> getCategoryListByParentId(@Param("parentId") int parentId, @Param("categoryType") int categoryType);
}
