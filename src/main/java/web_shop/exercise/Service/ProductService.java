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

    public void Create(Product product)
    {
        iCrudRepository.Create(product);
    }

    public Product Read(long id)
    {
        return iCrudRepository.Read(id);
    }

    public List<Product> ReadAll()
    {
        List<Product> productList = new ArrayList<>();

        for (Product product: iCrudRepository.ReadAll())
        {
            productList.add(product);
        }
        return productList;
    }

    public boolean Update(Product product)
    {
        boolean updateOk = false;
        updateOk = iCrudRepository.Update(product);
        return updateOk;
    }

    public boolean Delete(long id)
    {

        return iCrudRepository.Delete(id);
    }
}
