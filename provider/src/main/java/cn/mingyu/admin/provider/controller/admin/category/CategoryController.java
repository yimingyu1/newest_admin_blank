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


}
