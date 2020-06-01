package web_shop.exercise.Repository;

import org.springframework.stereotype.Repository;
import web_shop.exercise.Domain.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product>
{
    private List<Product> listOfProducts = new ArrayList<>();

    public ProductRepository()
    {
        this.listOfProducts.add(new Product(1, "Kaffe", 45.0,"Lækker kaffe"));
        this.listOfProducts.add(new Product(2, "Te", 30,"Super te fra Kina"));
        this.listOfProducts.add(new Product(3, "Is", 22.0,"Kølig Magnum"));
        this.listOfProducts.add(new Product(4, "Lakridspipe", 5.0,"Skippers lakridspipe"));
        this.listOfProducts.add(new Product(5, "Bolcherne", 47.5,"Lækre bolcher fra Køge Nord"));
        this.listOfProducts.add(new Product(6, "Pepsi Max", 5.0,"Nul kaloier og god smag"));
    }

    @Override
    public void create(Product product)
    {
        listOfProducts.add(product);
    }

    @Override
    public Product findById(long id)
    {
        //find element by id
        int i = 0;
        while (i < listOfProducts.size())
        {
            // i = index of the element in list and getId is that elements id.
            // id is given when calling the method
            if (listOfProducts.get(i).getId() == id)
            {
                return listOfProducts.get(i);
            }
            else
            {
                i++;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll()
    {
        return listOfProducts;
    }

    @Override
    public boolean update(Product product)
    {
        //Find the element that should be updated in Product
        for(int i = 0; i < listOfProducts.size(); i++)
        {
            // product.getId() is given when calling the method
            if (listOfProducts.get(i).getId() == product.getId())
            {
                //Updates the index with product (Overrides the old product with the new)
                listOfProducts.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id)
    {
        int i = 0;
        while (i < listOfProducts.size())
        {
            if (listOfProducts.get(i).getId() == id)
            {
                listOfProducts.remove(i);
                return true;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
}
