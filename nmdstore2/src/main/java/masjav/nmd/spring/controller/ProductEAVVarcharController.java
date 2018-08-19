package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.Product.ProductEAVVarchar;
import masjav.nmd.spring.service.ProductEAVVarcharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductEAVVarcharController {
    @Autowired
    ProductEAVVarcharService productEAVVarcharService;

    @PostMapping("/producteavvarchars")
    public ProductEAVVarchar saveProductEAVVarchar(@RequestBody ProductEAVVarchar productEAVVarchar){
        return productEAVVarcharService.saveProductEAVVarchar(productEAVVarchar);
    }

    @GetMapping("/products/{id}/producteavvarchars")
    public List<ProductEAVVarchar> getByProductId(@PathVariable Long id){
        return productEAVVarcharService.getByProductId(id);
    }
}
