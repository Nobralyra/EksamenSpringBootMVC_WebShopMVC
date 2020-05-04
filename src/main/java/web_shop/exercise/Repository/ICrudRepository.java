package web_shop.exercise.Repository;

import java.util.List;

public interface ICrudRepository <T>
{
    void create(T t);
    T findById(long id);
    List<T> findAll();
    boolean update(T t);
    boolean delete(long id);
}
