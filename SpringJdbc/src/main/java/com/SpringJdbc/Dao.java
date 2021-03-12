package com.SpringJdbc;

public interface Dao {
    void add(Recipe recipe);

    void delete(String recipeName);

    Recipe search(String recipeName);
}
