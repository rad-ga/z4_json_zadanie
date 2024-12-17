package exchangeService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FxRateProvider<T extends RateResponse> implements FxRateDownloader {
    private Class<T> targetClass;
    private String apiKey;
    private String apiBaseUrl;

    public FxRateProvider(Class<T> targetClass, String apiKey, String apiBaseUrl) {
        this.targetClass = targetClass;
        this.apiKey = apiKey;
        this.apiBaseUrl = apiBaseUrl;
    }

    @Override
    public double getRate(String from, String to) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URL url = getUrl(from, to, apiKey, apiBaseUrl);
            T response = objectMapper.readValue(url, targetClass);
            if (response.getConversion_rate() <= 0) {
                throw new IllegalStateException("Invalid conversion rate");
            }
            return response.getConversion_rate();
        } catch (MalformedURLException e) {
            throw new IOException("Incorrect URL for API", e);
        } catch (IllegalStateException e) {
            throw new IOException("Error in fetching valid conversion rate", e);
        }
    }

    @Override
    public URL getUrl(String from, String to, String apiKey, String baseUrl) throws MalformedURLException {
        return new URL(baseUrl + apiKey + "/pair/" + from + "/" + to);
    }

}