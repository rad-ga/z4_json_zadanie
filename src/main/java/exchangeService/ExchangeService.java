package exchangeService;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeService {
    private FxRateProvider fxRateProvider;

    public ExchangeService(FxRateProvider fxRateProvider) {
        this.fxRateProvider = fxRateProvider;
    }

    public double exchange(String from, String to, double amount) throws IOException {
        double result = fxRateProvider.getRate(from, to) * amount;
        return BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}