import java.time.LocalDate;
import static java.lang.Math.*;

/**
 * Klasa HealthProfile sluzy do tworzenia profilu,
 * na podstawie ktorego wylicza dane takie jak:
 * wiek, tetno max. i docelowe i BMI.
 * @author Weronika Wajda
 * @version 1.0   20/10/2019
 *
 */
public class HealthProfile {

    /**
    *Imie uzytkownika
    */
    private String imie;
    /**
     *Nazwisko uzytkownika
     */
    private String nazwisko;
    /**
     *Plec uzytkownika
     */
    private String plec;
    /**
     *Data urodzin uzytkownika podana za pomoca atrybutow: rok, miesiac i dzien urodzeneia uzytkownika.
     */
    private int rok;
    private int miesiac;
    private int dzien;
    /**
     *Wzrost uzytkownika [cm]
     */
    private double wzrost;
    /**
     *Masa(waga) uzytkownika [kg]
     */
    private double masa;

    /**
     * Konstruktor ze wszystkimi paramtrami uzytkownika.
     * @param imie  ustawia imie
     * @param nazwisko  ustawia nazwisko
     * @param plec  ustawia plec
     * @param rok  ustawia rok urodzenia
     * @param miesiac  ustawia miesiac urodzenia
     * @param dzien  ustawia dzien urodzenia
     * @param wzrost  ustawia wzrost [cm]
     * @param masa  ustawia mase(wage) [kg]
     */
    public HealthProfile(String imie, String nazwisko, String plec, int rok, int miesiac, int dzien, double wzrost, double masa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.rok = rok;
        this.miesiac = miesiac;
        this.dzien = dzien;
        this.wzrost = wzrost;
        this.masa = masa;
    }

    /**
     * Funkcja wylicza wiek uzytkownika na podstawie roznicy biezacej daty i daty urodzin uzytkownika.
     * @return wiek uzytkownika w latach
     */
    public int wiek() {
        LocalDate today = LocalDate.now();
        LocalDate lata = today.minusYears(rok).minusMonths(miesiac).minusDays(dzien);
        int wiek=lata.getYear();

        return wiek;
    }

    /**
     * Funkcja oblicza maksymalne i docelowe tetno uzytkownika dla umiarkowanej aktywnosci fizycznej.
     * Wyniki sa wypisywane w konsoli.
     */

    public void tetno(){
        int wiek=wiek();
        double tmax=220-wiek;
        double ts=round(0.7*tmax);
        double tp=round(0.5*tmax);
        System.out.println("Tetno maksymalne wymosi "+tmax+" uderzen/min, a tetno docelowe miesci sie w przedziale "+tp+"-"+ts+" uderzen/min");
    }

    /**
     * Funkcja oblicza BMI uzytkownika.
     * Wyniki sa wypisywane w konsoli.
     */

    public void BMI(){
        double bmi=ceil((masa/pow((wzrost/100),2))*100)/100;
        System.out.println("BMI wynosi "+bmi);
    }

    /**
     * Funkcja pobierajaca imie uzytkownika.
     * @return imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Funkcja ustawiajaca imie uzytkownika.
     * @param imie imie uzytkownika
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Funkcja pobierajaca nazwisko uzytkownika.
     * @return nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Funkcja ustawiajaca nazwisko uzytkownika.
     * @param nazwisko nazwisko uzytkownika
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Funkcja pobierajaca plec uzytkownika.
     * @return plec
     */
    public String getPlec() {
        return plec;
    }

    /**
     * Funkcja ustawiajaca plec uzytkownika.
     * @param plec plec uzytkownika
     */
    public void setPlec(String plec) {
        this.plec = plec;
    }

    /**
     * Funkcja pobierajaca rok urodzenia uzytkownika.
     * @return rok
     */
    public int getRok() {
        return rok;
    }

    /**
     * Funkcja ustawiajaca rok urodzenia uzytkownika.
     * @param rok rok urodzin uzytkownika
     */
    public void setRok(int rok) {
        this.rok = rok;
    }

    /**
     * Funkcja pobierajaca miesiac urodzenia uzytkownika.
     * @return miesiac
     */
    public int getMiesiac() {
        return miesiac;
    }

    /**
     * Funkcja ustawiajaca miesiac urodzenia uzytkownika.
     * @param miesiac miesiac urodzin uzytkownika
     */
    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    /**
     * Funkcja pobierajaca dzien urodzenia uzytkownika.
     * @return dzien
     */
    public int getDzien() {
        return dzien;
    }

    /**
     * Funkcja ustawiajaca dzien urodzenia uzytkownika.
     * @param dzien dzien urodzin uzytkownika
     */
    public void setDzien(int dzien) {
        this.dzien = dzien;
    }

    /**
     * Funkcja pobierajaca wzrost uzytkownika.
     * @return wzrost
     */
    public double getWzrost() {
        return wzrost;
    }

    /**
     * Funkcja ustawiajaca wzrost uzytkownika [cm].
     * @param wzrost wzrost uzytkownika [cm]
     */
    public void setWzrost(double wzrost) {
        this.wzrost = wzrost;
    }

    /**
     * Funkcja pobierajaca mase(wage) uzytkownika.
     * @return masa
     */
    public double getMasa() {
        return masa;
    }

    /**
     * Funkcja ustawiajaca mase(wage) uzytkownika [kg].
     * @param masa masa(waga) uzytkownika [kg]
     */
    public void setMasa(double masa) {
        this.masa = masa;
    }


}