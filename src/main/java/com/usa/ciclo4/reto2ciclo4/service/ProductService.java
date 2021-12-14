package com.usa.ciclo4.reto2ciclo4.service;

import com.usa.ciclo4.reto2ciclo4.model.Product;
import com.usa.ciclo4.reto2ciclo4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(String reference) {
        return productRepository.getProduct(reference);
    }

    public Product save(Product product){
         if (product.getReference() == null) {
            return product;
        } else {
            return productRepository.save(product);
        }
    }
    
   public Product update(Product product) {

        if (product.getReference() != null) {
            Optional<Product> accesoryDb = productRepository.getProduct(product.getReference());
            if (!accesoryDb.isEmpty()) {
                if (product.getBrand() != null) {
                    accesoryDb.get().setBrand(product.getBrand());
                }

                if (product.getCategory() != null) {
                    accesoryDb.get().setCategory(product.getCategory());
                }

                if (product.getMaterial() != null) {
                    accesoryDb.get().setMaterial(product.getMaterial());
                }

                if (product.getDescription() != null) {
                    accesoryDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    accesoryDb.get().setPhotography(product.getPhotography());
                }
                accesoryDb.get().setAvailability(product.isAvailability());
                productRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

     public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            productRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
