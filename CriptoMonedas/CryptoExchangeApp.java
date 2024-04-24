import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.json.*;

public class CryptoExchangeApp extends JFrame {
    private JTextArea pricesTextArea;
    private JTextArea walletTextArea;

    public CryptoExchangeApp() {
        setTitle("Crypto Exchange App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        pricesTextArea = new JTextArea();
        walletTextArea = new JTextArea();

        JScrollPane pricesScrollPane = new JScrollPane(pricesTextArea);
        JScrollPane walletScrollPane = new JScrollPane(walletTextArea);

        add(pricesScrollPane);
        add(walletScrollPane);

        updatePrices();
        loadWallet();

        Timer timer = new Timer(30000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePrices();
            }
        });
        timer.start();
    }

    private void updatePrices() {
        String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            JSONArray jsonArray = new JSONArray(content.toString());
            StringBuilder prices = new StringBuilder();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                double price = jsonObject.getDouble("current_price");
                prices.append(name).append(": $").append(price).append("\n");
            }
            pricesTextArea.setText(prices.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadWallet() {
        try (BufferedReader reader = new BufferedReader(new FileReader("wallet.txt"))) {
            StringBuilder wallet = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                wallet.append(line).append("\n");
            }
            walletTextArea.setText(wallet.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CryptoExchangeApp app = new CryptoExchangeApp();
                app.setVisible(true);
            }
        });
    }
}

