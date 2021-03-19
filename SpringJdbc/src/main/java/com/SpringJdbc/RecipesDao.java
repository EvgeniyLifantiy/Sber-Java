package com.SpringJdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class RecipesDao implements Dao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Recipe recipe)  {
        
            //push to table recipes
            jdbcTemplate.update("INSERT INTO recipes(Name,Author) VALUES (?,?)",recipe.getName(),recipe.getAuthor());

            //push to  table ingredients
            recipe.getIngredients().forEach((s, integer) -> {
                jdbcTemplate.update("INSERT INTO ingredients(recipe,name,weight) VALUES (?,?,?)",recipe.getName(),s,integer);
            });
    }

    public void delete(String recipeName){
            jdbcTemplate.update("DELETE FROM recipes WHERE Name=?",recipeName);
            jdbcTemplate.update("DELETE FROM ingredients WHERE recipe=?",recipeName);


    }


    public Recipe search(String recipeName){

            Recipe recipe=jdbcTemplate.query("SELECT * FROM recipes WHERE Name=?",
                    new Object[]{recipeName},
                    new BeanPropertyRowMapper<>(Recipe.class)).stream().findAny().orElse(null);


            recipe.setIngredients(jdbcTemplate.queryForMap("SELECT * FROM ingredients WHERE recipe=?",
                    new Object[]{recipeName}));



        return recipe;

    }

}
