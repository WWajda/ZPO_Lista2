import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Zad2 {

    public static void zapis(ArrayList<String> dane) {
        int j = 0;
        try {
            File file = new File("kalendarz.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dane.get(0) + " " + dane.get(1) + "\n");
            for (int i = 2; i < dane.size(); i++) {
                String linia = dane.get(i);
                bw.write(linia + "\t");
                j++;
                if (j == 7) {
                    bw.newLine();
                    j = 0;
                }
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> week = new ArrayList<>();
        int month = 0;
        int year = 0;
        int koniec = 0;
        String error = " ";
        Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Proszę podać numer miesiąca: (1-styczeń, 2-luty, ..., 12-grudzień)");
                month = Integer.parseInt(scan.nextLine());
                while (month > 12 || month < 1) {
                    System.out.println("Podany numer jest niepoprawny. Proszę wybrać numer miesiąca z przedziału [1 12].");
                    month = Integer.parseInt(scan.nextLine());
                }
                System.out.println("Proszę podać rok:");
                year = Integer.parseInt(scan.nextLine());
                while (year < 0) {
                    System.out.println("Podany rok jest niepoprawny. Proszę wybrać liczbę o wartości nieujemnej.");
                    year = Integer.parseInt(scan.nextLine());
                }
            } catch (NumberFormatException e) {
                error = "Podano zły format odpowiedzi.";
                System.out.println(error);
            }

        while (error.equals(" ") && koniec == 0) {
            LocalDate l = LocalDate.of(year, month, 1);
            week.add(String.valueOf(l.getMonth()));
            week.add(String.valueOf(l.getYear()));
            week.add("Mon");
            week.add("Tue");
            week.add("Wed");
            week.add("Thu");
            week.add("Fri");
            week.add("Sat");
            week.add("Sun");
            int length = l.lengthOfMonth();
            int first = 0;
            DayOfWeek first_day = l.getDayOfWeek();
            String fd = first_day.toString();
            for (int i = 2; i < week.size(); i++) {
                if (fd.contains(week.get(i).toUpperCase())) {
                    first = i - 2;
                }
            }
            for (int i = 0; i < 7; i++) {
                if (i == first) {
                    i = 7;
                    for (int j = 1; j <= length; j++) {
                        week.add(String.valueOf(j));
                    }
                }
                week.add(" ");
            }
            zapis(week);
            koniec=1;
        }
    }
}
