package cn.mingyu.admin.provider.controller.admin.product;

import cn.mingyu.admin.biz.product.ProductBiz;
import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.domain.param.product.ProductParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ProductController
 * Description:
 * date: 2021/11/14 下午9:00
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/admin/product")
@Slf4j
public class ProductController {

    @Resource
    private ProductBiz productBiz;

    @PostMapping(path = "/add.json")
    public ApiResponse<Object> addProduct(@RequestBody ProductParam productParam){
        log.info("addProduct productParam is {}", productParam);
        return productBiz.addProduct(productParam);
    }

    @PostMapping(path = "/update.json")
    public ApiResponse<Object> updateProduct(@RequestBody ProductParam productParam){
        log.info("updateProduct productParam is {}", productParam);
        return productBiz.updateProduct(productParam);
    }

    @PostMapping(path = "/updateStatus.json")
    public ApiResponse<Object> updateProductStatus(@RequestBody ProductParam productParam){
        log.info("updateProductStatus productParam is {}", productParam);
        return productBiz.updateProductStatus(productParam);
    }

    @GetMapping(path = "/getProductInfoById.json")
    public ApiResponse<Object> getProductInfoById(@RequestParam(name = "id") Integer id){
        log.info("getProductInfoById productParam is {}", id);
        return productBiz.getProductInfoById(id);
    }

    @GetMapping(path = "/getProductList.json")
    public ApiResponse<Object> getProductList(@RequestParam(name = "productName", required = false, defaultValue = "") String productName,
                                              @RequestParam(name = "productDesc", required = false, defaultValue = "") String productDesc,
                                              @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset,
                                              @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit
                                              ){
        log.info("getProductList productParam is {} -- {} -- {} -- {}", productName, productDesc, offset, limit);
        Map<String, Object> paramsData = new HashMap<>();
        if (!StringUtils.isEmpty(productName) ){
            paramsData.put("productName","%" + productName + "%");
        }
        if (!StringUtils.isEmpty(productDesc)){
            paramsData.put("productDesc","%" + productDesc + "%");
        }
        return productBiz.getProductListWithParam(paramsData, offset, limit);
    }




}
