package com.SpringJdbc;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class Recipe {

    private String Name;

    private String Author;

    private Map<String,Integer> ingredients;

    public Recipe(String name, String author, Map<String, Integer> ingredients) {
        Name = name;
        Author = author;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public Recipe() {
    }

    @Override
    public int hashCode() {
        return Name.hashCode()+Author.hashCode()+ingredients.hashCode();
    }


    public boolean equals(Recipe recipe) {
        if(Name.equals(recipe.getName())&&
                Author.equals(recipe.getAuthor())&&
                ingredients.equals(recipe.getIngredients())&&
                hashCode()==recipe.hashCode()){
            return true;
        }
        return false;
    }

    public void setIngredients(Map<String, Object> queryForMap) {
            queryForMap.forEach((s, o) -> ingredients.put(s, (Integer) o));
        }
    }


