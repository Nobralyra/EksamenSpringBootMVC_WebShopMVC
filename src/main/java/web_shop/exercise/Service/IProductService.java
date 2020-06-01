package web_shop.exercise.Service;

import web_shop.exercise.Domain.Product;

import java.util.List;

public interface IProductService
{
    void create(Product product);
    Product read(long id);
    List<Product> readAll();
    boolean update(Product product);
    boolean delete(long id);
}
