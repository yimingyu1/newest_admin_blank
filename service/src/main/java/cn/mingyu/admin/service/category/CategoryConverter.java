package cn.mingyu.admin.service.category;

import cn.mingyu.admin.domain.model.CategoryModel;
import cn.mingyu.admin.domain.schema.CategoryDO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
public class CategoryConverter {

    public static CategoryDO converter2CategoryDO(CategoryModel categoryModel){
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setId(categoryModel.getId());
        categoryDO.setParentId(categoryModel.getParentId());
        categoryDO.setCategoryName(categoryModel.getCategoryName());
        categoryDO.setCategoryType(categoryModel.getCategoryType());
        categoryDO.setWeight(categoryModel.getWeight());
        categoryDO.setDeleted(categoryModel.getDeleted());
        categoryDO.setCreateTime(categoryModel.getCreateTime());
        categoryDO.setUpdateTime(categoryModel.getUpdateTime());
        return categoryDO;
    }

    public static CategoryModel converter2CategoryModel(CategoryDO categoryDO){
        if (categoryDO == null){
            return null;
        }
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryDO.getId());
        categoryModel.setParentId(categoryDO.getParentId());
        categoryModel.setCategoryName(categoryDO.getCategoryName());
        categoryModel.setCategoryType(categoryDO.getCategoryType());
        categoryModel.setWeight(categoryDO.getWeight());
        categoryModel.setDeleted(categoryDO.getDeleted());
        categoryModel.setCreateTime(categoryDO.getCreateTime());
        categoryModel.setUpdateTime(categoryDO.getUpdateTime());
        return categoryModel;
    }

    public static List<CategoryModel> converter2CategoryModelBatch(List<CategoryDO> categoryDOS){
        List<CategoryModel> categoryModels = new ArrayList<>();
        if (CollectionUtils.isEmpty(categoryDOS)){
            return categoryModels;
        }
        return categoryDOS.stream().map(CategoryConverter::converter2CategoryModel).collect(Collectors.toList());
    }
}
