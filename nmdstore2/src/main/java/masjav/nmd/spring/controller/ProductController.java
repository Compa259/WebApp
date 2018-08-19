package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.Product.Product;
import masjav.nmd.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
//        Product _product = productService.findById(product.getId());
//        _product.setSku(product.getSku());
//       return productService.saveProduct(_product);
        return productService.saveProduct(product);
    }

    @PutMapping("/products")
    public Product update(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @RequestMapping("/categories/{id}/products")
    public Page<Product> getProductByCategoryId(@PathVariable Long id,
                                                @RequestParam Integer pageIndex,
                                                @RequestParam Integer pageSize){
        return productService.findAllByCategoryId(id, pageIndex, pageSize);
    }

    @RequestMapping("/products/new")
    public Page<Product> getProductNew(@RequestParam Integer pageIndex, @RequestParam Integer pageSize){
        return productService.findByNew(pageIndex, pageSize);
    }

    @RequestMapping("/products/sale")
    public Page<Product> getProductSale(@RequestParam Integer pageIndex, @RequestParam Integer pageSize){
        return productService.findBySale(pageIndex, pageSize);
    }

    @RequestMapping("/products/top")
    public Page<Product> getProductTop(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return productService.findByTop(pageIndex, pageSize);
    }

    @RequestMapping("/categories/{id}/products/top")
    public Page<Product> getProductTopFollowCategory(@PathVariable Long id, @RequestParam Integer pageIndex, @RequestParam Integer pageSize){
        return productService.findByTopFollowCategory(id, pageIndex, pageSize);
    }

//    @RequestMapping("/products/{id}/detail")
////    public Product getProductDetail(@PathVariable Long id) {
////        return productService.getProductDetail(id);
////    }
}
