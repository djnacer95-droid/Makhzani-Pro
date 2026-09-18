package com.makhzani.pro;

import androidx.room.*;
import java.util.*;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product ORDER BY id DESC")
    List<Product> all();

    @Insert
    void insert(Product p);

    @Delete
    void delete(Product p);

    @Query("UPDATE Product SET quantity=quantity-:q WHERE id=:id AND quantity>=:q")
    int sell(int id, int q);

    @Query("SELECT * FROM Product WHERE id=:id LIMIT 1")
    Product get(int id);

    @Query("SELECT COALESCE(SUM(quantity*sellPrice),0) FROM Product")
    double stockValue();
}
