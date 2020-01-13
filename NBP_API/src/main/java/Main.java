public class Main {

    public static void main(String[] args) {

        CurrencyData result1 = new CurrencyData("USD", 3);
        System.out.println(result1.getRates());

        CurrencyData result2 = new CurrencyData("USD", "2020-01-03", "2020-01-03");
        System.out.println(result2.getRates());
    }
}
