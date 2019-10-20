import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;

public class Zad1 {

    public static int jakiNumer(ArrayList<String> imiona, ArrayList<Integer> numery, String imie){
        int numer;
        numer=numery.get(imiona.indexOf(imie));
        return numer;
    }

    public static int ilu(ArrayList<String> kraje,String kraj){
        int liczba = 0;
        for(int i=0;i<kraje.size();i++) {
            if (kraje.get(i).equals(kraj))
            liczba++;
        }
        return liczba;
    }

    public static ArrayList<Double> wylicz(ArrayList<Integer> wiek){
        List<Double> dane = new ArrayList<>();
        double suma_sr=0;
        double suma_od=0;
        int rozmiar=10;
        for (int i=0;i<rozmiar;i++){
            suma_sr+=wiek.get(i);
        }
        double srednia=suma_sr/rozmiar;
        srednia=ceil(srednia*100)/100;
        for (int i=0;i<rozmiar;i++) {
            suma_od += pow(wiek.get(i) - srednia,2);
        }
        double odchylenie=sqrt(suma_od/(rozmiar-1));
        odchylenie=ceil(odchylenie*100)/100;
        dane.add(srednia);
        dane.add(odchylenie);
        return (ArrayList<Double>) dane;
    }

    public static int roznica(String imie1, String imie2, ArrayList<String> imiona, ArrayList<Integer> punkty){
        int index1=imiona.indexOf(imie1);
        int index2=imiona.indexOf(imie2);
        int roznica=abs(punkty.get(index1)-punkty.get(index2));

        return roznica;
    }

    public static void turnieje(ArrayList<Integer> turnieje){
        try {
            File file = new File("turnieje.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0;i<turnieje.size();i++){
                String linia=(turnieje.get(i)).toString();
                bw.write(linia);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        List<Integer> numery= new ArrayList<>();
        List<String> kraje = new ArrayList<>();
        List<String> imiona = new ArrayList<>();
        List<Integer> wiek = new ArrayList<>();
        List<Integer> punkty = new ArrayList<>();
        List<Integer> turnieje = new ArrayList<>();

     try {
         File file = new File("ranking.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String linia = null;
         while ((linia = br.readLine()) != null) {
             String[] elementy = linia.split("\t");
             numery.add(Integer.valueOf(elementy[0]));
             kraje.add(elementy[1]);
             imiona.add(elementy[2]);
             wiek.add(Integer.valueOf(elementy[3]));
             punkty.add(Integer.valueOf(elementy[4]));
             turnieje.add(Integer.valueOf(elementy[5]));
         }
         br.close();
         fr.close();
     } catch (IOException e) {
         System.out.println("Błąd WE/WY");
     }
        System.out.println(jakiNumer((ArrayList<String>) imiona,(ArrayList<Integer>) numery,"Hubert Hurkacz"));
        System.out.println(ilu ((ArrayList<String>) kraje,"FRA"));
        System.out.println(wylicz((ArrayList<Integer>) wiek));
        System.out.println(roznica("Rafael Nadal","Borna Coric",(ArrayList<String>) imiona, (ArrayList<Integer>) punkty));
        turnieje((ArrayList<Integer>) turnieje);
    }
}

