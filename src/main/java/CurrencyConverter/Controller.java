package CurrencyConverter;

public class Controller {
    static CurrencyConverter currencyConverter = new CurrencyConverter();
    static private CurrencyConrollerGui gui;

    public Controller(CurrencyConrollerGui gui) {
        this.gui = gui;
    }

    public double convert(double amount, String source, String target) {
        return currencyConverter.convertTo(amount, source, target);
    }

    public static void main(String[] args) {
        CurrencyConrollerGui.launch(CurrencyConrollerGui.class);
    }
}
