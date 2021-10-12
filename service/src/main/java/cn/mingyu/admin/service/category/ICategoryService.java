package cn.mingyu.admin.service.category;

import cn.mingyu.admin.domain.model.CategoryModel;

import java.util.List;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
public interface ICategoryService {
    int insertCategory(CategoryModel categoryModel);

    List<CategoryModel> getCategoriesByType(int categoryType);

    List<CategoryModel> getCategoriesByParentId(int parentId, int categoryType);

    int updateCategory(CategoryModel categoryModel);
}
