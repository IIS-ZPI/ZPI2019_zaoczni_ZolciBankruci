public class Main {

    public static void main(String[] args) {

        CurrencyData wynik1 = new CurrencyData("USD", 3);
        System.out.println(wynik1.getRates());

        CurrencyData wynik2 = new CurrencyData("USD", "2020-01-01", "2020-01-12");
        System.out.println(wynik2.getRates());
    }
}
