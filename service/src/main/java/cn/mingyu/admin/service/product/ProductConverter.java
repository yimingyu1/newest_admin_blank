package cn.mingyu.admin.service.product;

import cn.mingyu.admin.domain.model.ProductModel;
import cn.mingyu.admin.domain.schema.ProductDO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: ProductConverter
 * Description:
 * date: 2021/11/14 下午8:46
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
public class ProductConverter {

    public static ProductDO converter2ProductDO(ProductModel productModel){
        ProductDO productDO = new ProductDO();
        productDO.setId(productModel.getId());
        productDO.setProductName(productModel.getProductName());
        productDO.setProductDesc(productModel.getProductDesc());
        productDO.setPrice(productModel.getPrice());
        productDO.setStatus(productModel.getStatus());
        productDO.setProductImages(JSONObject.toJSONString(productModel.getProductImages()));
        productDO.setCreateTime(productModel.getCreateTime());
        productDO.setUpdateTime(productModel.getUpdateTime());
        return productDO;
    }

    public static ProductModel converter2ProductModel(ProductDO productDO){

        ProductModel productModel = new ProductModel();
        productModel.setId(productDO.getId());
        productModel.setProductName(productDO.getProductName());
        productModel.setProductDesc(productDO.getProductDesc());
        productModel.setPrice(productDO.getPrice());
        productModel.setStatus(productDO.getStatus());
        productModel.setProductImages(JSONArray.parseArray(productDO.getProductImages(), String.class));
        productModel.setCreateTime(productDO.getCreateTime());
        productModel.setUpdateTime(productDO.getUpdateTime());
        return productModel;
    }

    public static List<ProductModel> converter2ProductModelBatch(List<ProductDO> productDOS){

        List<ProductModel> productModels = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productDOS)){
            productModels = productDOS.stream().map(ProductConverter::converter2ProductModel).collect(Collectors.toList());
        }
        return productModels;
    }



}
