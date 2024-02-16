package CurrencyConverter;

public class CurrencyConverter {
    private final double eur = 1;
    private final double usd = 1.0743;
    private final double aud = 1.6525;
    private final double chf = 0.9484;
    private final double gbp = 0.8564;
    private final double jpy = 161.26;
    private final double nok = 11.361;
    private final double sek = 11.2575;
    private final double thb = 38.829;

    public double convertTo(double amount, String source, String target) {
        double sourceRate = getRate(source);
        double targetRate = getRate(target);
        double baseAmount = amount / sourceRate;
        return baseAmount * targetRate;
    }

    private double getRate(String currency) {
        switch (currency.toLowerCase()) {
            case "eur":
                return eur;
            case "usd":
                return usd;
            case "aud":
                return aud;
            case "chf":
                return chf;
            case "gbp":
                return gbp;
            case "jpy":
                return jpy;
            case "nok":
                return nok;
            case "sek":
                return sek;
            case "thb":
                return thb;
            default:
                throw new IllegalArgumentException("Currency not found");
        }
    }
}
