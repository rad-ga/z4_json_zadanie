package exchangeService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

 /*
 0. Jak sprawic zeby ObjectMapper Sie nie wywracał przy braku jakiejs zmiennej
 // działa bez niczego




Stworzych klase ExchangeService z funkcja double exchange(FROM,TO,AMOUNT) -> Ta klasa powinna
zlozyc zapytanie to APIomowionego na lekcji, zczytac exchange_rate i przewalutowac podaną kwotę
 korzystając z tego rate.

 Pamiętaj żeby kod był elastyczny, reużywalny
 */

        String apiKey = "739527234b0128a3121982af";
        String apiBaseUrl = "https://v6.exchangerate-api.com/v6/";

        FxRateProvider fxRateProvider = new FxRateProvider<>(FxRateProviderResponse.class, apiKey, apiBaseUrl);

        ExchangeService exchangeService = new ExchangeService(fxRateProvider);
        System.out.println(exchangeService.exchange("EUR", "PLN", 1000.00));


    }
}
