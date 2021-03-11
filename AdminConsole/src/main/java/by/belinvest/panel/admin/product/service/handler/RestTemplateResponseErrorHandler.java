package by.belinvest.panel.admin.product.service.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    public static String errors = "";

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == CLIENT_ERROR || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {
        System.out.println("RestTemplateResponseErrorHandler handleError method started.");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("ready to read response");
        System.out.println(httpResponse.getStatusCode().toString());
        System.out.println(httpResponse.getStatusText());
        InputStream body = httpResponse.getBody();
        System.out.println("get body.");
        Map<String, Object> jsonMap = mapper.readValue(body, Map.class);
        System.out.println("Errors map size: " + jsonMap.size());
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        errors = "Ошибка приема данных банковским сервисом. Сообщение: \"" + jsonMap.get("userMessage") + "\"";
        body.close();
        System.out.println(errors);
    }

}
