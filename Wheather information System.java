import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherInformationSystem {

    // -------- Weather CLASS --------
    static class Weather {
        private String city;
        private double temperature;
        private String condition;   // sunny, rainy, cloudy
        private int humidity;       // %

        public Weather(String city, double temperature, String condition, int humidity) {
            this.city = city;
            this.temperature = temperature;
            this.condition = condition;
            this.humidity = humidity;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "City: " + city +
                    " | Temp: " + temperature + "°C" +
                    " | Condition: " + condition +
                    " | Humidity: " + humidity + "%";
        }
    }

    // -------- DATA STORAGE --------
    private static List<Weather> weatherList = new ArrayList<>();

    // -------- MAIN METHOD --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample data
        loadSampleWeather();

        int choice;
        do {
            System.out.println("\n===== WEATHER INFORMATION SYSTEM =====");
            System.out.println("1. View all cities weather");
            System.out.println("2. Search weather by city");
            System.out.println("3. Add weather info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice!");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    viewAllWeather();
                    break;
                case 2:
                    searchWeather(sc);
                    break;
                case 3:
                    addWeather(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using Weather Information System!");
                    break;
                default:
                    System.out.println("Enter valid choice (1–4).");
            }

        } while (choice != 4);

        sc.close();
    }

    // -------- SAMPLE DATA --------
    private static void loadSampleWeather() {
        weatherList.add(new Weather("Mumbai", 32.5, "Sunny", 70));
        weatherList.add(new Weather("Delhi", 28.0, "Cloudy", 55));
        weatherList.add(new Weather("Pune", 26.3, "Rainy", 80));
        weatherList.add(new Weather("Nashik", 24.0, "Clear", 60));
    }

    // -------- VIEW WEATHER --------
    private static void viewAllWeather() {
        System.out.println("\n--- All Cities Weather ---");
        if (weatherList.isEmpty()) {
            System.out.println("No weather data available.");
            return;
        }

        for (Weather w : weatherList) {
            System.out.println(w);
        }
    }

    // -------- SEARCH WEATHER --------
    private static void searchWeather(Scanner sc) {
        System.out.print("\nEnter city name to search: ");
        String city = sc.nextLine().trim();

        boolean found = false;
        for (Weather w : weatherList) {
            if (w.getCity().equalsIgnoreCase(city)) {
                System.out.println("Weather Found:");
                System.out.println(w);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No weather information found for this city.");
        }
    }

    // -------- ADD WEATHER --------
    private static void addWeather(Scanner sc) {
        try {
            System.out.print("Enter city name: ");
            String city = sc.nextLine();

            System.out.print("Enter temperature (°C): ");
            double temp = Double.parseDouble(sc.nextLine());

            System.out.print("Enter condition (Sunny/Rainy/Cloudy): ");
            String condition = sc.nextLine();

            System.out.print("Enter humidity (%): ");
            int humidity = Integer.parseInt(sc.nextLine());

            Weather w = new Weather(city, temp, condition, humidity);
            weatherList.add(w);

            System.out.println("Weather information added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input! Weather not added.");
        }
    }
}

*******************************************************OUTPUT****************************************************************

===== WEATHER INFORMATION SYSTEM =====
1. View all cities weather
2. Search weather by city
3. Add weather info
4. Exit
Enter your choice: 1

--- All Cities Weather ---
City: Mumbai | Temp: 32.5?C | Condition: Sunny | Humidity: 70%
City: Delhi | Temp: 28.0?C | Condition: Cloudy | Humidity: 55%
City: Pune | Temp: 26.3?C | Condition: Rainy | Humidity: 80%
City: Nashik | Temp: 24.0?C | Condition: Clear | Humidity: 60%

===== WEATHER INFORMATION SYSTEM =====
1. View all cities weather
2. Search weather by city
3. Add weather info
4. Exit
Enter your choice: 2

Enter city name to search: Mumbai
Weather Found:
City: Mumbai | Temp: 32.5?C | Condition: Sunny | Humidity: 70%

===== WEATHER INFORMATION SYSTEM =====
1. View all cities weather
2. Search weather by city
3. Add weather info
4. Exit
Enter your choice: 3
Enter city name: pune
Enter temperature (?C): 25
Enter condition (Sunny/Rainy/Cloudy): sunny
Enter humidity (%): 70
Weather information added successfully!

===== WEATHER INFORMATION SYSTEM =====
1. View all cities weather
2. Search weather by city
3. Add weather info
4. Exit
Enter your choice: 4
Thank you for using Weather Information System!

=============================================================================================================================