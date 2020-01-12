import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;

public class CurrencyData {

    Currencies currency;

    CurrencyData(String curr, int days) {

        try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://api.nbp.pl/api/exchangerates/rates/a/" + curr + "/last/" + days + "/");
            ClientResponse webResponse = webResource.accept("application/json").get(ClientResponse.class);
            if (webResponse.getStatus() != 200) {
                throw new RuntimeException("Błąd HTTP ..." + webResponse.getStatus());
            }
            String receivedJson = webResponse.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            currency = mapper.readValue(receivedJson, Currencies.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CurrencyData(String curr, String date1, String date2) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://api.nbp.pl/api/exchangerates/rates/a/" + curr + "/" + date1 + "/" + date2 + "/");
            ClientResponse webResponse = webResource.accept("application/json").get(ClientResponse.class);
            if (webResponse.getStatus() != 200) {
                throw new RuntimeException("Błąd HTTP ..." + webResponse.getStatus());
            }
            String receivedJson = webResponse.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            currency = mapper.readValue(receivedJson, Currencies.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList getRates() {
        ArrayList rates = new ArrayList();

        for (int i = 0; i < currency.getRates().size(); i++) {
            rates.add(currency.getRates().get(i).getMid());
        }
        return rates;
    }

}
