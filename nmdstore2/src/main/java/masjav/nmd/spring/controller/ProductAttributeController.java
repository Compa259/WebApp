package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.Product.ProductAttribute;
import masjav.nmd.spring.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAttributeController {
    @Autowired
    ProductAttributeService productAttributeService;

    @PostMapping("/productattributes")
    public ProductAttribute saveProductAttribute(@RequestBody ProductAttribute productAttribute) {
        return productAttributeService.saveProductAttribute(productAttribute);
    }

    @PutMapping("/productattributes")
    public ProductAttribute updateProductAttribute(@RequestBody ProductAttribute productAttribute) {
        return productAttributeService.saveProductAttribute(productAttribute);
    }
}
