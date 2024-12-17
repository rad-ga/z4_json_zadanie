package exchangeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExchangeServiceTest {


    @Test
    public void testExchange() throws IOException {
        //given
        FxRateProvider fxRateProvider = mock(FxRateProvider.class);

        when(fxRateProvider.getRate("EUR", "USD")).thenReturn(1.15);

        ExchangeService exchangeService = new ExchangeService(fxRateProvider);

        //when
        double amount = exchangeService.exchange("EUR", "USD", 10000);

        //then
        assertEquals(amount,11500);


    }


}
