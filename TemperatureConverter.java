import java.util.Scanner;

public class TemperatureConverter {

    // Method to get the unit symbol
    static String getUnit(int scale) {

        switch (scale) {

            case 1:
                return "°C";

            case 2:
                return "°F";

            case 3:
                return "K";

            default:
                return "";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = 1;

        do {

            System.out.println("\n======== Temperature Converter ========");

            // Input scale
            System.out.println("1. Celsius");
            System.out.println("2. Fahrenheit");
            System.out.println("3. Kelvin");

            System.out.print("Enter input scale: ");
            int inputScale = sc.nextInt();

            // Check input scale
            if (inputScale < 1 || inputScale > 3) {
                System.out.println("Invalid input scale.");
                continue;
            }

            // Input temperature
            System.out.print("Enter temperature: ");
            double temperature = sc.nextDouble();

            // Check temperature validity
            if (inputScale == 1 && temperature < -273.15) {
                System.out.println(
                    "Invalid temperature! Celsius cannot be below -273.15°C."
                );
                continue;
            }

            if (inputScale == 2 && temperature < -459.67) {
                System.out.println(
                    "Invalid temperature! Fahrenheit cannot be below -459.67°F."
                );
                continue;
            }

            if (inputScale == 3 && temperature < 0) {
                System.out.println(
                    "Invalid temperature! Kelvin cannot be negative."
                );
                continue;
            }

            // Output scale
            System.out.println("\nChoose output scale:");
            System.out.println("1. Celsius");
            System.out.println("2. Fahrenheit");
            System.out.println("3. Kelvin");

            System.out.print("Enter output scale: ");
            int outputScale = sc.nextInt();

            // Check output scale
            if (outputScale < 1 || outputScale > 3) {
                System.out.println("Invalid output scale.");
                continue;
            }

            // Convert input temperature to Celsius
            double celsius;

            switch (inputScale) {

                case 1:
                    celsius = temperature;
                    break;

                case 2:
                    celsius = (temperature - 32) * 5.0 / 9.0;
                    break;

                case 3:
                    celsius = temperature - 273.15;
                    break;

                default:
                    System.out.println("Invalid input scale.");
                    continue;
            }

            // Convert Celsius to required output scale
            double result;

            switch (outputScale) {

                case 1:
                    result = celsius;
                    break;

                case 2:
                    result = (celsius * 9.0 / 5.0) + 32;
                    break;

                case 3:
                    result = celsius + 273.15;
                    break;

                default:
                    continue;
            }

            // Get unit symbols
            String inputUnit = getUnit(inputScale);
            String outputUnit = getUnit(outputScale);

            // Display result
            System.out.println("\n========== RESULT ==========");

            System.out.printf(
                "%.2f %s = %.2f %s%n",
                temperature,
                inputUnit,
                result,
                outputUnit
            );

            System.out.println("============================");

            // Ask for another conversion
            System.out.print(
                "\nDo you want another conversion? (1 = Yes, 2 = No): "
            );

            choice = sc.nextInt();

        } while (choice == 1);

        System.out.println(
            "\nThank you for using Temperature Converter!"
        );

        sc.close();
    }
}