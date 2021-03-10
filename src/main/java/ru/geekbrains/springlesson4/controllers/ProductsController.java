package ru.geekbrains.springlesson4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springlesson4.product.Product;
import ru.geekbrains.springlesson4.productRepository.ProductRepository;
@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductRepository repository;

    public ProductsController(ProductRepository repository) {
        this.repository = repository;
    }
    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("products", repository.showAll());
        return "products/show";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model){
        model.addAttribute("product", repository.getById(id));
        return "products/id";
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }
    @PostMapping
    public String addProduct(@ModelAttribute("product") Product product){
        repository.addProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String editProduct(Model model, @PathVariable("id") long id){
        model.addAttribute("product", repository.getById(id));
        return "products/edit";
    }
    @PatchMapping("/{id}")
    public String updateProduct(@ModelAttribute("product") Product product, @PathVariable("id") long id){
        repository.update(id, product);
        return "redirect:/products";
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        repository.delete(id);
        return "redirect:/products";
    }



}
