package cn.mingyu.admin.provider.controller.admin.category;

import cn.mingyu.admin.biz.category.CategoryBiz;
import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.domain.param.category.CategoryParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yimingyu
 * @date 2021/10/12
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Resource
    private CategoryBiz categoryBiz;

    @PostMapping(path = "/add.json")
    public ApiResponse<Object> addCategory(@RequestBody CategoryParam categoryParam){
        return  categoryBiz.insertCategory(categoryParam);
    }

    @GetMapping(path = "/getCategoryByType.json")
    public ApiResponse<Object> getCategoryByType(@RequestParam(name = "categoryType") int categoryType){
        return  categoryBiz.getCategoriesByType(categoryType);
    }

    @GetMapping(path = "/getCategoryByParentId.json")
    public ApiResponse<Object> getCategoryByParentId(@RequestParam(name = "categoryType") int categoryType,
                                                     @RequestParam(name = "categoryParentId") int categoryParentId){
        return  categoryBiz.getCategoriesByParent(categoryType, categoryParentId);
    }

    @PostMapping(path = "/update.json")
    public ApiResponse<Object> updateCategory(@RequestBody CategoryParam categoryParam){
        return  categoryBiz.updateCategory(categoryParam);
    }




}
