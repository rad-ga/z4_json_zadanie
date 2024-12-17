package exchangeService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public interface FxRateDownloader {
    double getRate(String from, String to) throws IOException;
    URL getUrl(String from, String to, String api_key, String baseUrl) throws MalformedURLException;
}