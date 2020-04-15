package ebay;

public class Ebay extends CommonAPI_Ebay {
    public static void main(String[] args) {
        setup("https://www.ebay.com", "mac", "firefox");
        sleepFor(5);
        close();
    }

}

