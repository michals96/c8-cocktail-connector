package io.camunda.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.connector.model.CocktailApiResponse;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class CocktailService {
    private static String COCKTAIL_DB_API_URL = "https://thecocktaildb.com/api/json/v1/1/filter.php?i=";

    public static String getCocktail(final String ingredient) throws JsonProcessingException {
        final var objectMapper = new ObjectMapper();
        final var restTemplate = new RestTemplate();

        final var response = restTemplate.getForEntity(COCKTAIL_DB_API_URL + ingredient, String.class);
        final var cocktailApiResponse = objectMapper.readValue(response.getBody(), CocktailApiResponse.class);
        final int randomIndex = getRandomIndex(cocktailApiResponse.getDrinks().size());
        return cocktailApiResponse.getDrinks().get(randomIndex).getStrDrink();
    }

    private static int getRandomIndex(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
}
