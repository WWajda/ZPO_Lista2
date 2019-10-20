import java.util.Scanner;

public class Zad3 {
    public static void main(String[] args) {
        String error = " ";
        String imie;
        String nazwisko;
        String plec;
        int rok = 0;
        int miesiac = 0;
        int dzien = 0;
        double wzrost = 0;
        double waga = 0;
        int koniec = 0;

        System.out.println("Proszę podać imię: ");
        Scanner scan = new Scanner(System.in);
        imie = scan.next();
        System.out.println("Proszę podać nazwisko: ");
        nazwisko = scan.next();
        System.out.println("Proszę podać płeć (k-kobieta m-mężczyzna) : ");
        String p = scan.next();
        while (!p.equals("k") && !p.equals("m")) {
            System.out.println("Podana nazwa jest niepoprawna. Proszę wybrać odpowiedź k lub m");
            p = scan.next();
        }
        if (p.equals("k")) {
            plec = "kobieta";
        } else {
            plec = "mężczyzna";
        }
            try {
                System.out.println("Proszę podać datę urodzenia:");
                System.out.println("rok: ");
                rok = Integer.valueOf(scan.next());
                while (rok < 0) {
                    System.out.println("Podany rok jest niepoprawny. Proszę wybrać liczbę o wartości nieujemnej.");
                    rok = Integer.parseInt(scan.next());
                }
                System.out.println("miesiąc: (1-styczeń, 2-luty,..., 12-grudzień) ");
                miesiac = Integer.valueOf(scan.next());
                while (miesiac > 12 || miesiac < 1) {
                    System.out.println("Podany numer jest niepoprawny. Proszę wybrać numer miesiąca z przedziału [1 12].");
                    miesiac = Integer.parseInt(scan.next());
                }
                System.out.println("dzień: ");
                dzien = Integer.valueOf(scan.next());
                while (dzien > 31 || dzien < 1) {
                    System.out.println("Podany numer jest niepoprawny. Proszę wybrać numer dnia z przedziału [1 31].");
                    dzien = Integer.parseInt(scan.next());
                }
                System.out.println("Proszę podać wzrost [cm]: ");
                wzrost = Double.valueOf(scan.next());
                System.out.println("Proszę podać wagę [kg]: ");
                waga = Double.valueOf(scan.next());
            } catch (NumberFormatException e) {
                error = "Podano zły format odpowiedzi.";
                System.out.println(error);
            }
            while (error.equals(" ") && koniec == 0) {
                HealthProfile h = new HealthProfile(imie, nazwisko, plec, rok, miesiac, dzien, wzrost, waga);
                System.out.println("Profil użytkownika: ");
                System.out.println("Imię: " + h.getImie());
                System.out.println("Nazwisko: " + h.getNazwisko());
                System.out.println("Płeć: " + h.getPlec());
                System.out.println("Data urodzenia: " + h.getDzien() + "-" + h.getMiesiac() + "-" + h.getRok());
                System.out.println("Wzrost: " + h.getWzrost() + " cm");
                System.out.println("Waga: " + h.getMasa() + " kg");
                System.out.println("Wiek: " + h.wiek() + " lat");
                h.tetno();
                h.BMI();
                koniec = 1;
            }
        }
    }
