package masjav.nmd.spring.service;

import masjav.nmd.spring.model.Product.ProductAttribute;
import masjav.nmd.spring.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductAttributeService {
    @Autowired
    ProductAttributeRepository productAttributeRepository;

    @Transactional
    public ProductAttribute saveProductAttribute(ProductAttribute productAttribute){
        return productAttributeRepository.save(productAttribute);
    }
}
