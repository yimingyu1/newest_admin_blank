package cn.mingyu.admin.service.category.impl;

import cn.mingyu.admin.dao.category.read.ICategoryReadDAO;
import cn.mingyu.admin.dao.category.write.ICategoryWriteDAO;
import cn.mingyu.admin.domain.model.CategoryModel;
import cn.mingyu.admin.service.category.CategoryConverter;
import cn.mingyu.admin.service.category.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@Service
public class ICategoryServiceImpl implements ICategoryService {

    @Resource
    private ICategoryWriteDAO categoryWriteDAO;

    @Resource
    private ICategoryReadDAO categoryReadDAO;

    @Override
    public int insertCategory(CategoryModel categoryModel) {
        return categoryWriteDAO.insertCategory(CategoryConverter.converter2CategoryDO(categoryModel));
    }

    @Override
    public List<CategoryModel> getCategoriesByType(int categoryType) {
        return CategoryConverter.converter2CategoryModelBatch(categoryReadDAO.getCategoryListByType(categoryType));
    }

    @Override
    public List<CategoryModel> getCategoriesByParentId(int parentId, int categoryType) {
        return CategoryConverter.converter2CategoryModelBatch(categoryReadDAO.getCategoryListByParentId(parentId, categoryType));
    }

    @Override
    public int updateCategory(CategoryModel categoryModel) {
        return categoryWriteDAO.updateCategory(CategoryConverter.converter2CategoryDO(categoryModel));
    }

    @Override
    public List<CategoryModel> getCategoriesByTypeWithPage(int categoryType, int offset, int limit) {
        return CategoryConverter.converter2CategoryModelBatch(categoryReadDAO.getCategoryListByTypeWithPage(categoryType, offset, limit));
    }

    @Override
    public List<CategoryModel> getCategoriesByParentIdWithPage(int parentId, int categoryType, int offset, int limit) {
        return CategoryConverter.converter2CategoryModelBatch(categoryReadDAO.getCategoryListByParentIdWithPage(parentId, categoryType, offset, limit));

    }
}
