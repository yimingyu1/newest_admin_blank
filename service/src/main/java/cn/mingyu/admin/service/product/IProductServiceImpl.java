package cn.mingyu.admin.service.product;

import cn.mingyu.admin.dao.product.read.IProductReadDAO;
import cn.mingyu.admin.dao.product.write.IProductWriteDAO;
import cn.mingyu.admin.domain.model.ProductModel;
import cn.mingyu.admin.domain.schema.ProductDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName: IProductServiceImpl
 * Description:
 * date: 2021/11/14 下午8:46
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class IProductServiceImpl implements IProductService{

    @Resource
    private IProductWriteDAO productWriteDAO;

    @Resource
    private IProductReadDAO productReadDAO;

    @Override
    public int insertProduct(ProductModel productModel) {
        return productWriteDAO.insertProduct(ProductConverter.converter2ProductDO(productModel));
    }

    @Override
    public int updateProduct(ProductModel productModel) {
        return productWriteDAO.updateProduct(ProductConverter.converter2ProductDO(productModel));
    }

    @Override
    public int updateProductStatus(int id, int status) {
        return productWriteDAO.updateProductStatus(id, status);
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return ProductConverter.converter2ProductModelBatch(productReadDAO.getAllProducts());
    }

    @Override
    public List<ProductModel> getProductsByPage(int offset, int limit) {
        return ProductConverter.converter2ProductModelBatch(productReadDAO.getProductsByPage(offset, limit));
    }

    @Override
    public ProductModel getProductsById(int id) {
        return ProductConverter.converter2ProductModel(productReadDAO.getProductsById(id));
    }

    @Override
    public List<ProductModel> getProductsByNameAndKeys(Map<String, Object> paramMap) {
        return ProductConverter.converter2ProductModelBatch(productReadDAO.getProductsByNameAndKeys(paramMap));
    }
}
