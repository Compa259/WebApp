package masjav.nmd.spring.service;

import masjav.nmd.spring.model.Product.Product;
import masjav.nmd.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public Product findById(Long id){
        return productRepository.findById(id);
    }

    @Transactional
    public Page<Product> findAllByCategoryId(Long id, int pageIndex, int pageSize) {
        return productRepository.findAllByCategoryId(id, new PageRequest(pageIndex, pageSize));
    }

    @Transactional
    public Page<Product> findByNew(int pageIndex, int pageSize) {
        return productRepository.findByNew(new PageRequest(pageIndex, pageSize));
    }

    @Transactional
    public Page<Product> findBySale(int pageIndex, int pageSize) {
        return productRepository.findBySale(new PageRequest(pageIndex, pageSize));
    }

    @Transactional
    public Page<Product> findByTop(int pageIndex, int pageSize) {
        return productRepository.findByTop(new PageRequest(pageIndex, pageSize));
    }

    @Transactional
    public Page<Product> findByTopFollowCategory(Long id, int pageIndex, int pageSize){
        return productRepository.findByTopFollowCategory(id, new PageRequest(pageIndex, pageSize));
    }

//    @Transactional
//    public Product getProductDetail(Long id){
//        return productRepository.getProductDetail(id);
//    }
}
