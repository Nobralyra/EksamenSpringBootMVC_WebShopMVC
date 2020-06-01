package web_shop.exercise.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_shop.exercise.Domain.Product;
import web_shop.exercise.Repository.ICrudRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService
{
    //Runtime inject implemented class
    @Autowired
    ICrudRepository<Product> iCrudRepository;

    @Override
    public void create(Product product)
    {
        iCrudRepository.create(product);
    }

    @Override
    public Product read(long id)
    {
        return iCrudRepository.findById(id);
    }

    @Override
    public List<Product> readAll()
    {
        List<Product> productList = new ArrayList<>();

        for (Product product: iCrudRepository.findAll())
        {
            productList.add(product);
        }
        return productList;
    }

    @Override
    public boolean update(Product product)
    {
        boolean updateOk = false;
        updateOk = iCrudRepository.update(product);
        return updateOk;
    }

    @Override
    public boolean delete(long id)
    {
        return iCrudRepository.delete(id);
    }
}
