package web_shop.exercise.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Repository.ICrudRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ICrudRepository<Product> iCrudRepository;

    public void create(Product product)
    {
        iCrudRepository.create(product);
    }

    public Product read(long id)
    {
        return iCrudRepository.findById(id);
    }

    public List<Product> readAll()
    {
        List<Product> productList = new ArrayList<>();

        for (Product product: iCrudRepository.findAll())
        {
            productList.add(product);
        }
        return productList;
    }

    public boolean update(Product product)
    {
        boolean updateOk = false;
        updateOk = iCrudRepository.update(product);
        return updateOk;
    }

    public boolean delete(long id)
    {
        return iCrudRepository.delete(id);
    }
}
