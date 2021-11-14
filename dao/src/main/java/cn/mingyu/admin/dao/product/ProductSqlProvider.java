package cn.mingyu.admin.dao.product;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * ClassName: ProductSql
 * Description:
 * date: 2021/11/14 下午9:41
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
public class ProductSqlProvider {

    public String getProductsByParams(Map<String, Object> paramMap){
        System.out.println(paramMap);
        System.out.println(paramMap.get("productDesc"));
        String sql = new SQL(){
            {
                SELECT("*");
                FROM("product");
                if (null != paramMap.get("productName")) {
                    WHERE("product_name like #{productName}");
                }
                if(null != paramMap.get("productDesc")) {
                    WHERE("product_desc like #{productDesc}");
                }
                if (null != paramMap.get("offset")){
                    LIMIT("#{offset}, #{limit}");
                }
            }
        }.toString();
        System.out.println(sql);
        return sql;
    }

}
