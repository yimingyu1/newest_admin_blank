package cn.mingyu.admin.service.product;

import cn.mingyu.admin.domain.model.ProductModel;
import cn.mingyu.admin.domain.schema.ProductDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * ClassName: IProductService
 * Description:
 * date: 2021/11/14 下午8:46
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
public interface IProductService {

    int insertProduct(ProductModel productModel);

    int updateProduct(ProductModel productModel);

    int updateProductStatus(int id, int status);

    List<ProductModel> getAllProducts();

    List<ProductModel> getProductsByPage(@Param("offset") int offset, @Param("limit") int limit);

    ProductModel getProductsById(@Param("id") int id);

    List<ProductModel> getProductsByNameAndKeys(Map<String, Object> paramMap);

}
