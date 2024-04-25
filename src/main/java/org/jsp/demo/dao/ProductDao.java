package org.jsp.demo.dao;

import org.jsp.demo.model.Product;
import org.jsp.demo.model.User;
import org.jsp.demo.repository.ProductRepository;
import org.jsp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductDao
{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;;
    public Product addProduct(Product product,int id)
    {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent())
        {
            User user1=user.get();
            user1.getProducts().add(product);
            product.setUser(user1);
           return productRepository.save(product);
        }
        return null;
    }

    public Product updateProduct(Product product)
    {
        Optional<Product> product1=productRepository.findById(product.getId());
        if(product1.isPresent())
        {
            Product product2=product1.get();
            product2.setName(product.getName());
            product2.setPrice(product.getPrice());
            product2.setType(product.getType());
            return productRepository.save(product2);
        }
        return null;
    }
    public void deleteProduct(int id){
        if(productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }
}
