package io.camunda.connector;

import java.util.Objects;

public class CocktailRequest {

    private String ingredient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CocktailRequest that = (CocktailRequest) o;
        return Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient);
    }

    public String getIngredient() {
        return ingredient;
    }

    @Override
    public String toString() {
        return "CocktailRequest{" +
                "ingredient='" + ingredient + '\'' +
                '}';
    }
}
