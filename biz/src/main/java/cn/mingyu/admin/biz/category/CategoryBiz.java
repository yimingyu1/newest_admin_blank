package cn.mingyu.admin.biz.category;

import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.common.Paging;
import cn.mingyu.admin.domain.model.CategoryModel;
import cn.mingyu.admin.domain.param.category.CategoryParam;
import cn.mingyu.admin.domain.vo.CategoryVO;
import cn.mingyu.admin.service.category.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        List<CategoryModel> categoryModels = categoryService.getCategoriesByType(categoryType);
        Paging paging = new Paging();
        paging.setTotal(categoryModels.size());
        List<CategoryVO> categoryVOS = converter2CategoryVOBatch(categoryModels);
        return ApiResponse.buildSuccess(categoryVOS, paging);
    }

    public ApiResponse<Object> getCategoriesByParent(int categoryType, int parentId){
        List<CategoryModel> categoryModels = categoryService.getCategoriesByParentId(parentId, categoryType);
        Paging paging = new Paging();
        paging.setTotal(categoryModels.size());
        List<CategoryVO> categoryVOS = converter2CategoryVOBatch(categoryModels);
        return ApiResponse.buildSuccess(categoryVOS, paging);
    }

    public ApiResponse<Object> updateCategory(CategoryParam categoryParam){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryParam.getId());
        categoryModel.setParentId(categoryParam.getParentId());
        categoryModel.setCategoryName(categoryParam.getCategoryName());
        categoryModel.setCategoryType(categoryParam.getCategoryType());
        LocalDateTime now = LocalDateTime.now();
        categoryModel.setUpdateTime(now);
        int rest = categoryService.updateCategory(categoryModel);
        if (rest > 0){
            return ApiResponse.buildSuccess();
        }
        return ApiResponse.buildFail("内部错误");
    }



    public static List<CategoryVO> converter2CategoryVOBatch(List<CategoryModel> categoryModels){
        List<CategoryVO> categoryVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(categoryModels)){
            return categoryVOS;
        }
        for (CategoryModel category: categoryModels
        ) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setId(category.getId());
            categoryVO.setCategoryName(category.getCategoryName());
            categoryVO.setCategoryType(category.getCategoryType());
            categoryVOS.add(categoryVO);
        }
        return categoryVOS;
    }

}
