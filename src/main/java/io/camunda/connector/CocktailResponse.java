package io.camunda.connector;

import java.util.Objects;

public class CocktailResponse {
    private String result;

    public CocktailResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CocktailResponse that = (CocktailResponse) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "CocktailResponse{" +
                "result='" + result + '\'' +
                '}';
    }
}
