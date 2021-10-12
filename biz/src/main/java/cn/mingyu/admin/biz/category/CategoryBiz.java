package cn.mingyu.admin.biz.category;

import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.domain.model.CategoryModel;
import cn.mingyu.admin.domain.param.category.CategoryParam;
import cn.mingyu.admin.service.category.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@Service
public class CategoryBiz {

    @Resource
    private ICategoryService categoryService;

    public ApiResponse<Object> insertCategory(CategoryParam categoryParam){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setParentId(categoryParam.getParentId());
        categoryModel.setCategoryName(categoryParam.getCategoryName());
        categoryModel.setCategoryType(categoryParam.getCategoryType());
        categoryModel.setDeleted(0);
        categoryModel.setWeight(0);
        LocalDateTime now = LocalDateTime.now();
        categoryModel.setCreateTime(now);
        categoryModel.setUpdateTime(now);
        int rest = categoryService.insertCategory(categoryModel);
        if (rest > 0){
            return ApiResponse.buildSuccess();
        }
        return ApiResponse.buildFail("内部错误");
    }

    public ApiResponse<Object> getCategoriesByType(int categoryType){

    }

}
