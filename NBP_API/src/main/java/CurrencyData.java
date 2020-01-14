import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.time.LocalDate;
import java.util.ArrayList;

public class CurrencyData {
    private Currencies currency;
    private Currencies currencyPair;
    private boolean currencyPairs = false;

    CurrencyData(String curr, int sessions) {
        WebResource webResource = Client.create().resource("http://api.nbp.pl/api/exchangerates/rates/a/" + curr + "/last/" + sessions + "/");
        this.setCurrency(webResource);
    }

    CurrencyData(String curr, LocalDate date1, LocalDate date2) {
        WebResource webResource = Client.create().resource("http://api.nbp.pl/api/exchangerates/rates/a/" + curr + "/"
                + date1.toString() + "/" + date2.toString() + "/");
        this.setCurrency(webResource);
    }

    CurrencyData(String currency1, String currency2, LocalDate date1, LocalDate date2) {
        currencyPairs = true;
        WebResource webResource1 = Client.create().resource("http://api.nbp.pl/api/exchangerates/rates/a/" + currency1 + "/"
                + date1.toString() + "/" + date2.toString() + "/");
        WebResource webResource2 = Client.create().resource("http://api.nbp.pl/api/exchangerates/rates/a/" + currency2 + "/"
                + date1.toString() + "/" + date2.toString() + "/");
        this.setCurrency(webResource1, webResource2);
    }

    private void setCurrency(WebResource webResource){
        try {
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

    private void setCurrency(WebResource webResource1, WebResource webResource2){
        try {
            ClientResponse webResponse1 = webResource1.accept("application/json").get(ClientResponse.class);
            ClientResponse webResponse2 = webResource2.accept("application/json").get(ClientResponse.class);
            if (webResponse1.getStatus() != 200 || webResponse2.getStatus() != 200) {
                throw new RuntimeException("Błąd HTTP ...\nFirst currency status: " + webResponse1.getStatus() + "\nSecond currency status: " + webResponse2.getStatus());
            }
            String receivedJson1 = webResponse1.getEntity(String.class);
            String receivedJson2 = webResponse2.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();

            currency = mapper.readValue(receivedJson1, Currencies.class);
            currencyPair = mapper.readValue(receivedJson2, Currencies.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Double> getRates() {
        if(currencyPairs){
            return null;
        } else {
            ArrayList<Double> rates = new ArrayList<>();

            for (int i = 0; i < currency.getRates().size(); i++) {
                rates.add(currency.getRates().get(i).getMid());
            }
            return rates;
        }
    }
    public ArrayList<ArrayList<Double>> getPairRates() {
        if(currencyPairs){
            ArrayList<ArrayList<Double>> rates = new ArrayList<>();
            if(currency.getRates().size() == currency.getRates().size()) {
                for (int i = 0; i < currency.getRates().size(); i++) {
                    ArrayList<Double> sameDayRate = new ArrayList<>();
                    sameDayRate.add(currency.getRates().get(i).getMid());
                    sameDayRate.add(currencyPair.getRates().get(i).getMid());
                    rates.add(sameDayRate);
                }
            }
            return rates;
        } else {
            return null;
        }
    }

}
