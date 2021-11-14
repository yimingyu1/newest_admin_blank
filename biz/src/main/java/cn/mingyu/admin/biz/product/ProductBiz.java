package cn.mingyu.admin.biz.product;

import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.common.Paging;
import cn.mingyu.admin.domain.model.CategoryModel;
import cn.mingyu.admin.domain.model.ProductModel;
import cn.mingyu.admin.domain.param.product.ProductParam;
import cn.mingyu.admin.domain.vo.CategoryVO;
import cn.mingyu.admin.domain.vo.ProductVO;
import cn.mingyu.admin.service.product.IProductService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: ProductBiz
 * Description:
 * date: 2021/11/14 下午8:51
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class ProductBiz {

    @Resource
    private IProductService productService;

    public ApiResponse<Object> addProduct(ProductParam productParam){
        ProductModel productModel = new ProductModel();
        productModel.setProductName(productParam.getProductName());
        productModel.setProductDesc(productParam.getProductDesc());
        productModel.setPrice(productParam.getPrice());
        productModel.setStatus(productParam.getStatus());
        productModel.setProductImages(productParam.getProductImages());
        int rest = productService.insertProduct(productModel);
        if (rest > 0){
            return ApiResponse.buildSuccess();
        }
        return ApiResponse.buildFail("内部错误");
    }

    public ApiResponse<Object> updateProduct(ProductParam productParam){
        ProductModel productModel = new ProductModel();
        productModel.setId(productParam.getId());
        productModel.setProductName(productParam.getProductName());
        productModel.setProductDesc(productParam.getProductDesc());
        productModel.setPrice(productParam.getPrice());
        productModel.setStatus(productParam.getStatus());
        productModel.setProductImages(productParam.getProductImages());
        productModel.setUpdateTime(LocalDateTime.now());
        int rest = productService.updateProduct(productModel);
        if (rest > 0){
            return ApiResponse.buildSuccess();
        }
        return ApiResponse.buildFail("内部错误");
    }

    public ApiResponse<Object> updateProductStatus(ProductParam productParam){
        ProductModel productModel = new ProductModel();
        productModel.setId(productParam.getId());
        productModel.setStatus(productParam.getStatus());
        productModel.setUpdateTime(LocalDateTime.now());
        int rest = productService.updateProductStatus(productModel.getId(), productModel.getStatus());
        if (rest > 0){
            return ApiResponse.buildSuccess();
        }
        return ApiResponse.buildFail("内部错误");
    }

    public ApiResponse<Object> getProductInfoById(int id){
        ProductModel productModel = productService.getProductsById(id);
        return ApiResponse.buildSuccess(converter2ProductVO(productModel));
    }


    public ApiResponse<Object> getProductListWithParam(Map<String, Object> paramsData, int offset, int limit){
        Paging paging = new Paging();
        paging.setLimit(limit);
        paging.setOffset(offset);
        List<ProductModel> allProductModels = null;
        if (null != paramsData.get("productName") || null != paramsData.get("productDesc")) {
            allProductModels = productService.getProductsByNameAndKeys(paramsData);
        } else {
            allProductModels = productService.getAllProducts();
        }
        if (org.springframework.util.CollectionUtils.isEmpty(allProductModels)){
            return ApiResponse.buildSuccess(allProductModels, paging);
        }
        paging.setTotal(allProductModels.size());
        List<ProductModel> productsByPage = null;
        if (null != paramsData.get("productName") || null != paramsData.get("productDesc")) {
            paramsData.put("offset", offset);
            paramsData.put("limit", limit);
            productsByPage = productService.getProductsByNameAndKeys(paramsData);
        } else {
            productsByPage = productService.getProductsByPage(offset, limit);
        }
        if (org.springframework.util.CollectionUtils.isEmpty(productsByPage)){
            ApiResponse.buildFail("分页错误");
        }
        return ApiResponse.buildSuccess(converter2ProductVOBatch(productsByPage), paging);
    }



    public ProductVO converter2ProductVO(ProductModel productModel){
        ProductVO productVO = new ProductVO();
        productVO.setId(productModel.getId());
        productVO.setProductName(productModel.getProductName());
        productVO.setProductDesc(productModel.getProductDesc());
        productVO.setPrice(productModel.getPrice());
        productVO.setStatus(productModel.getStatus());
        productVO.setProductImages(productModel.getProductImages());
        return productVO;
    }

    public List<ProductVO> converter2ProductVOBatch(List<ProductModel> productModels){
        List<ProductVO> productVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productModels)){
            productVOS = productModels.stream().map(this::converter2ProductVO).collect(Collectors.toList());
        }
        return productVOS;
    }


}
