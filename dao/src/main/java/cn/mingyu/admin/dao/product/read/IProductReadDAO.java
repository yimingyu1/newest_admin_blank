package cn.mingyu.admin.dao.product.read;

import cn.mingyu.admin.domain.schema.ProductDO;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * ClassName: IProductReadDAO
 * Description:
 * date: 2021/11/14 下午8:33
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
public interface IProductReadDAO {

    @Results( id="productResult", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productDesc", column = "product_desc"),
            @Result(property = "price", column = "price"),
            @Result(property = "status", column = "status"),
            @Result(property = "productImages", column = "product_imp_price"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
        }
    )
    @Select("select * from product")
    List<ProductDO> getAllProducts();

    @ResultMap("productResult")
    @Select("select * from product limit #{offset}, #{limit}")
    List<ProductDO> getProductsByPage(@Param("offset") int offset, @Param("limit") int limit);

    @ResultMap("productResult")
    @Select("select * from product where id = #{id}")
    ProductDO getProductsById(@Param("id") int id);


    @ResultMap("productResult")
    @SelectProvider(type = cn.mingyu.admin.dao.product.ProductSqlProvider.class, method = "getProductsByParams")
    List<ProductDO> getProductsByNameAndKeys(Map<String, Object> paramMap);

}
