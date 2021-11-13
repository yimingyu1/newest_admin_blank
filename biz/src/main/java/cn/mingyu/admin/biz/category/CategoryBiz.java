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

    public ApiResponse<Object> getCategoriesByType(int categoryType, int offset, int limit, boolean isAllCategory){
        List<CategoryModel> allCategoryModels = categoryService.getCategoriesByType(categoryType);
        List<CategoryModel> categoryModels = new ArrayList<>();
        if (!isAllCategory) {
            categoryModels = categoryService.getCategoriesByTypeWithPage(categoryType, offset, limit);
        }
        return converter2CategoryVOBatch(allCategoryModels, categoryModels, offset, limit,isAllCategory);
    }

    public ApiResponse<Object> getCategoriesByParent(int categoryType, int parentId, int offset, int limit){
        List<CategoryModel> allCategoryModels = categoryService.getCategoriesByParentId(parentId, categoryType);
        List<CategoryModel> categoryModels = categoryService.getCategoriesByParentIdWithPage(parentId, categoryType, offset, limit);
        return converter2CategoryVOBatch(allCategoryModels, categoryModels, offset, limit,false);
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

    public ApiResponse<Object> updateCategoryName(CategoryParam categoryParam){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryParam.getId());
        categoryModel.setCategoryName(categoryParam.getCategoryName());
        LocalDateTime now = LocalDateTime.now();
        categoryModel.setUpdateTime(now);
        int rest = categoryService.updateCategoryName(categoryModel);
        if (rest > 0){
            return ApiResponse.buildSuccess();
        }
        return ApiResponse.buildFail("内部错误");
    }



    public static ApiResponse<Object> converter2CategoryVOBatch(List<CategoryModel> allCategoryModels,
                                                                List<CategoryModel> categoryModels,
                                                                int offset, int limit, boolean isAllCategory){
        Paging paging = new Paging();
        paging.setLimit(limit);
        paging.setOffset(offset);
        paging.setTotal(allCategoryModels.size());
        if (CollectionUtils.isEmpty(allCategoryModels)){
            return ApiResponse.buildSuccess(allCategoryModels, paging);
        }
        if (isAllCategory){
            categoryModels = allCategoryModels;
            paging.setLimit(allCategoryModels.size());
        }else if (CollectionUtils.isEmpty(categoryModels)){
            ApiResponse.buildFail("分页错误");
        }
        List<CategoryVO> categoryVOS = new ArrayList<>();
        for (CategoryModel category: categoryModels
        ) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setId(category.getId());
            categoryVO.setCategoryName(category.getCategoryName());
            categoryVO.setCategoryType(category.getCategoryType());
            categoryVOS.add(categoryVO);
        }
        return ApiResponse.buildSuccess(categoryVOS, paging);
    }

}
