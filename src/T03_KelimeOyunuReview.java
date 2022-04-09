import java.util.Scanner;

public class T03_KelimeOyunuReview {

    /* Iki kisinin oynayacagi bir kelime oyunu uretelim
     * Kurallar
     * 1- Baslangicta 1.oyuncudan bir kelime girmesini isteyin ve kelimeyi yazdirin
     *
     * 2- 1.oyuncu kelimeyi girince 2.oyuncuya kelimeyi kabul edip etmedigini sorun.
     *      * Eger kelimeyi kabul ederse onceki oyuncuya kelimedeki harf sayisi kadar puan ekleyin
     *        ve 3.adima gecin
     *      * girilen kelimeyi kabul etmezse "gecersiz kelime" yazdirin ve onceki oyuncunun
     *        kazandigini yazip oyunu bitirin
     *
     * 3- yeni oyuncuya oyuna devam etmek isteyip istemedigini sorun
     *      * devam etmek isterse kelimeye eklemek istedigi string'i ve
     *          basa mi sona mi ekleyecegini sorun
     *          aldiginiz string'i kelimeye ekleyip 2.adima gidin
     *
     *      *   Devam etmek istemezse
     *          "Oyun bitti" yazin
     *          kullanicilarin puanlarini ve kazanan oyuncuyu yazdirin
     */

    static int oyuncu =1;
    static int puan1 =0;
    static int puan2 =0;
    static String klm ="";

    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

       kelimeGiris();

    }

    private static void kelimeGiris() {
        System.out.println(oyuncu+ ". oyuncu kelime girsin");
        klm = scan.next();
        System.out.println(klm);

        oyuncuDegistir1();

    }
    private static void oyuncuDegistir1() {
        if (oyuncu ==1){
            oyuncu =2;
        }else{
            oyuncu =1;
        }

        kabulmu();
    }

    private static void kabulmu() {
        System.out.println("ey "+oyuncu+". oyuncu " + klm+ " kelimesini kabul ediyor musun?");
        System.out.println("Kabul eidyorsan ,E, etmiyorsan ,H,");

        String scm = scan.next();
        if (scm.equalsIgnoreCase("e")){
            if( oyuncu ==1){
                puan2+=klm.length();
            }else if(oyuncu ==2){
                puan1+=klm.length();
            }

            kelimeEkleme();
        }
        else {
            cikisKelime();
        }

    }

    private static void kelimeEkleme() {
        System.out.println("Gireceğiniz kelimeyi başa mı sona mı ekleyeceksiniz?   basa/sona");
        String secim = scan.next();
        System.out.println("ekliyeceğiniz kelimeyi giriniz");
        String ekleme =scan.next();

        if (secim.equalsIgnoreCase("basa")){
            klm=ekleme+klm;
            System.out.println(klm);

        } else if (secim.equalsIgnoreCase("sona")){
            klm =klm+ekleme;
            System.out.println(klm);
        }

        oyuncuDegistir1();

    }

    private static void cikisKelime() {
        System.out.println("1. oyuncu puan "+ puan1+"    2. oyuncu puan "+puan2);
    }
}
