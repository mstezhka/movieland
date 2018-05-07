package com.stezhka.movieland.web.util.currency;


import com.stezhka.movieland.entity.Movie;
import com.stezhka.movieland.dao.enums.Currency;
import com.stezhka.movieland.web.util.currency.cache.CurrencyCache;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyServiceTest {
    @Test
    public void testConvertMoviePrice() {
        double actualPrice = 100;
        double expectedPrice = 3.85;
        double currencyRate = 26;

        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setNameRussian("Test russian name");
        movie.setNameNative("Test native name");
        movie.setYearOfRelease(3000);
        movie.setPrice(actualPrice);
        movie.setRating(1.1);
        movie.setPicturePath("Test path");

        CurrencyCache mockCurrencyCache = mock(CurrencyCache.class);
        when(mockCurrencyCache.getCurencyRate(Currency.USD)).thenReturn(currencyRate);

        CurrencyService currencyService = new CurrencyService(mockCurrencyCache);

        currencyService.convertMoviePrice(movie, currencyRate);

        assertEquals(expectedPrice, movie.getPrice(), 0);

    }

}