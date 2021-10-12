package cn.mingyu.admin.dao.category.write;

import cn.mingyu.admin.domain.schema.CategoryDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Update;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
public interface ICategoryWriteDAO {

    @Insert("insert into category(parent_id, category_name, category_type, weight, deleted, create_time, update_time) values " +
            "(#{parentId}, #{categoryName}, #{categoryType}, #{weight}, #{deleted}, #{createTime}, #{updateTime})")
    int insertCategory(CategoryDO category);

    @Update("update category set parent_id = #{parentId}, category_name = #{categoryName}, category_type = #{categoryType}, update_time = #{updateTime}" +
            " where id = #{id}")
    int updateCategory(CategoryDO category);
}
