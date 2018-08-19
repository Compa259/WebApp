package masjav.nmd.spring.service;

import masjav.nmd.spring.model.Product.ProductEAVVarchar;
import masjav.nmd.spring.repository.ProductEAVLongRepository;
import masjav.nmd.spring.repository.ProductEAVVarcharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductEAVVarcharService {
    @Autowired
    ProductEAVVarcharRepository productEAVVarcharRepository;

    @Autowired
    ProductEAVLongRepository productEAVLongRepository;

    @Transactional
    public ProductEAVVarchar saveProductEAVVarchar(ProductEAVVarchar productEAVVarchar){
        return productEAVVarcharRepository.save(productEAVVarchar);
    }

    @Transactional
    public List<ProductEAVVarchar> getByProductId(Long id){
         List varchars = productEAVVarcharRepository.getByProductId(id);
         List longs = productEAVLongRepository.getByProductId(id);

         List merged = new ArrayList(varchars);
         varchars.addAll(longs);
         return longs;
    }
}
