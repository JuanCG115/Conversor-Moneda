import java.util.Scanner;

public class Menu {
    private final CurrencyService currencyService;
    private final Scanner scanner;

    public Menu() {
        this.currencyService = new CurrencyService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertir("USD", "MXN");
                case 2 -> convertir("MXN", "USD");
                case 3 -> convertir("USD", "EUR");
                case 4 -> convertir("EUR", "USD");
                case 5 -> convertir("USD", "GBP");
                case 6 -> convertir("GBP", "USD");
                case 7 -> convertir("USD", "JPY");
                case 8 -> convertir("JPY", "USD");
                case 9 -> System.out.println("Gracias por usar el conversor");
                default -> System.out.println("Opción inválida!");
            }

        } while (opcion != 9);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n===== CONVERSOR DE MONEDAS =====");
        System.out.println("1. USD → MXN");
        System.out.println("2. MXN → USD");
        System.out.println("3. USD → EUR");
        System.out.println("4. EUR → USD");
        System.out.println("5. USD → GBP");
        System.out.println("6. GBP → USD");
        System.out.println("7. USD → JPY");
        System.out.println("8. JPY → USD");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void convertir(String base, String destino) {

        try {
            System.out.print("Ingrese la cantidad en " + base + ": ");
            double cantidad = scanner.nextDouble();

            ExchangeResponse response = currencyService.getRates(base);

            if (!"success".equals(response.result())) {
                System.out.println("Error en la API");
                return;
            }

            Double tasa = response.conversion_rates().get(destino);

            if (tasa == null) {
                System.out.println("Moneda no disponible");
                return;
            }

            double resultado = cantidad * tasa;

            System.out.printf("Resultado: %.2f %s%n", resultado, destino);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
