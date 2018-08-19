package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.OrderProduct.OrderProduct;
import masjav.nmd.spring.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderProductController {
    @Autowired
    OrderProductService orderProductService;

    @GetMapping(value = "/customers/{id}/orders")
    public List<OrderProduct> getByOwnerId(@PathVariable Long id){
        return orderProductService.getByOwnerId(id);
    }
}
