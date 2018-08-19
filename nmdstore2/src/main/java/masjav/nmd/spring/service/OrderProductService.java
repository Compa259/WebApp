package masjav.nmd.spring.service;

import masjav.nmd.spring.model.OrderProduct.OrderProduct;
import masjav.nmd.spring.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    @Transactional
    public List<OrderProduct> getByOwnerId(Long id){
        return orderProductRepository.getByOwnerId(id);
    }
}
