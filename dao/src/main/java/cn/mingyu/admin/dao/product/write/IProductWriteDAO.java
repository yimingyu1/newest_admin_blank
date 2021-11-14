package cn.mingyu.admin.dao.product.write;

import cn.mingyu.admin.domain.schema.ProductDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: IProducWriteDAO
 * Description:
 * date: 2021/11/14 下午8:32
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
public interface IProductWriteDAO {

    @Insert("insert into product(product_name, product_desc, price, status, product_imp_price) values" +
            "(#{productName}, #{productDesc}, #{price}, #{status}, #{productImages})")
    int insertProduct(ProductDO productDO);

    @Update("update product set " +
            "product_name = #{productName}, " +
            "product_desc = #{productDesc}, " +
            "price = #{price}, " +
            "status = #{status}, " +
            "product_imp_price = #{productImages}, " +
            "update_time = #{updateTime} " +
            "where id = #{id}")
    int updateProduct(ProductDO productDO);

    @Update("update product set status = #{status} where id = #{id}")
    int updateProductStatus(@Param("id") int id, @Param("status") int status);
}
