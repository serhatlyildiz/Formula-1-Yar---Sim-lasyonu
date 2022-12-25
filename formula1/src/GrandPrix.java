import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


abstract class GrandPrix {

    abstract ArrayList<String> bilgiGetir();
    public static Takimlar takim=new Takimlar();
    public static TeknikEkip teknik=new TeknikEkip();
    public static Pilotlar pilot=new Pilotlar();

    public static void takimGetir(int takimSirasi){
        int teknikSayac=0;
        int pilotSayac=0;
        for (int i = 0 ; i<takim.bilgiGetir().size(); i++){
            if (i==(takimSirasi-1)){
                System.out.println("----------"+takim.bilgiGetir().get(i)+"----------"+
                        "\nTakım Şefi = "+teknik.bilgiGetir().get(teknikSayac)+
                        "\nTeknik Şef = "+teknik.bilgiGetir().get(teknikSayac+1)+
                        "\nTakım Giriş Yılı = "+teknik.bilgiGetir().get(teknikSayac+2)+
                        "\nTakım Şampiyonluk Sayısı = "+teknik.bilgiGetir().get(teknikSayac+3)+
                        "\n1.Takım Pilotu = "+pilot.bilgiGetir().get(pilotSayac)+
                        "\n1.Takım Pilotu Ülkesi = "+pilot.bilgiGetir().get(pilotSayac+1)+
                        "\n1.Takım Pilotu Şampiyonluk Sayısı = "+pilot.bilgiGetir().get(pilotSayac+2)+
                        "\n1.Takım Pilotu Yarış Sayısı = "+pilot.bilgiGetir().get(pilotSayac+3)+
                        "\n2.Takım Pilotu = "+pilot.bilgiGetir().get(pilotSayac+4)+
                        "\n2.Takım Pilotu Ülkesi = "+pilot.bilgiGetir().get(pilotSayac+5)+
                        "\n2.Takım Pilotu Şampiyonluk Sayısı = "+pilot.bilgiGetir().get(pilotSayac+6)+
                        "\n2.Takım Pilotu Yarış Sayısı = "+pilot.bilgiGetir().get(pilotSayac+7)+
                        "\nArabanın Ortalama Motor Gücü = 700 Beygir\nArabanın ERS oranı = 160\n");
            }
            teknikSayac=teknikSayac+4;
            pilotSayac=pilotSayac+8;
        }
    }
    public static void yaris(){
        String siralama []=new String[20];
        Integer puanlama []=new Integer[20];
        int teknikSayac=3;
        int siraSayac=0;
        int geciciPuanlama;
        String geciciSiralama;
        for (int i=0;i<pilot.bilgiGetir().size();i+=4){//burda siralama ve puanları sırayla diziye atadım (start düzlüğü)
            siralama[siraSayac]=pilot.bilgiGetir().get(i);
            Sans.setSans((int)(Math.random()*(((Integer.parseInt(pilot.bilgiGetir().get(i+2))*15)+Integer.parseInt(pilot.bilgiGetir().get(i+3))+Integer.parseInt(teknik.bilgiGetir().get(teknikSayac)))/10)));
            puanlama[siraSayac]=Sans.getSans();
            siraSayac++;
            if (siraSayac%2==0){
                teknikSayac=teknikSayac+4;
            }
        }
        teknikSayac=0;
        siraSayac=0;
        for(int b = 0; b < 19; b++)//burda büyükten küçüğe puanları sıralattım
        {
            for(int j = b+1; j < 20; j++)
            {
                if(puanlama[j] > puanlama[b]) {
                    geciciPuanlama = puanlama[b];
                    puanlama[b] = puanlama[j];
                    puanlama[j] = geciciPuanlama;
                    geciciSiralama = siralama[b];
                    siralama[b] = siralama[j];
                    siralama[j] = geciciSiralama;
                }
            }
        }
        for (int a = 1; a<=40;a++){//burda 40 tur olacak şekilde puanları üst üste eklettim
            int siraSayaci=0;
            int teknikSayaci=3;
            for(int c = 0;c<pilot.bilgiGetir().size();c+=4){
                Sans.setSans((int)(Math.random()*(((Integer.parseInt(pilot.bilgiGetir().get(c+2))*10000)+Integer.parseInt(pilot.bilgiGetir().get(c+3))*5+Integer.parseInt(teknik.bilgiGetir().get(teknikSayaci))))));
                puanlama[siraSayaci]=puanlama[siraSayaci]+Sans.getSans();
                siraSayaci++;
                if (siraSayaci%2==0){
                    teknikSayaci+=4;
                }
            }
            for(int b = 0; b < 19; b++)//burda büyükten küçüğe puanları sıralattım
            {
                for(int j = b+1; j < 20; j++)
                {
                    if(puanlama[j] > puanlama[b]) {
                        geciciPuanlama = puanlama[b];
                        puanlama[b] = puanlama[j];
                        puanlama[j] = geciciPuanlama;
                        geciciSiralama = siralama[b];
                        siralama[b] = siralama[j];
                        siralama[j] = geciciSiralama;
                    }
                }
            }
            if (a==1||a==5||a==10||a==15||a==20||a==25||a==30||a==35||a==40) {//10 turlar gösterildi
                System.out.println("---------- " + a + ". Tur ----------");
                double saniye=0;
                for (int k = 0; k < siralama.length; k++) {
                    System.out.print((k+1) + ". " + siralama[k]);
                    for (int j=0;j<20-siralama[k].length();j++){

                        System.out.print(" ");
                    } if (k<=8){
                        System.out.print(" ");
                    }
                    System.out.println("+"+new DecimalFormat("##.##").format(saniye)+" s");

                    saniye+=Math.random()*8;
                }
            }
            if (a==40){//son tura gelince ilk 3 kişinin bilgilerini gösterttim
                int teknikS=0;
                int pilotS=0;
                for (int d = 0;d<3;d++){//burda ise sırayla 3 yarışmacının bilgilerini gösterttim
                    for (int i = 0 ; i<takim.bilgiGetir().size(); i++){
                        if (pilot.bilgiGetir().get(pilotS)==siralama[d]) {
                            System.out.println("---------- {"+(d+1)+"} ----------" +
                                    "\nTakım = " + takim.bilgiGetir().get(i) +
                                    "\nTakım Pilotu = " + pilot.bilgiGetir().get(pilotS)+
                                    "\nTeknik Şef = " + teknik.bilgiGetir().get(teknikS + 1) +
                                    "\nTakım Şefi = " + teknik.bilgiGetir().get(teknikS) +
                                    "\nTakım Pilotu Ülkesi = " + pilot.bilgiGetir().get(pilotS + 1));
                        }
                        else if(pilot.bilgiGetir().get(pilotS+4)==siralama[d]){
                            System.out.println("---------- {"+(d+1)+"} ----------" +
                                    "\nTakım = " + takim.bilgiGetir().get(i) +
                                    "\nTakım Pilotu = " + pilot.bilgiGetir().get(pilotS+4) +
                                    "\nTeknik Şef = " + teknik.bilgiGetir().get(teknikS + 1) +
                                    "\nTakım Şefi = " + teknik.bilgiGetir().get(teknikS) +
                                    "\nTakım Pilotu Ülkesi = " + pilot.bilgiGetir().get(pilotS + 5));
                        }
                        teknikS=teknikS+4;
                        pilotS=pilotS+8;
                    }
                    teknikS=0;
                    pilotS=0;
                }

            }
        }
    }
    public static void arayuz(){
        int secenek=0;
        int takimDetay=0;

        System.out.println("1- Takımları Göster\n2- Yarışı başlat\n\n0- Çıkış");
        Scanner secim=new Scanner(System.in);
        secenek=secim.nextInt();
        if (secenek==1){

            for (int i =0;i<takim.bilgiGetir().size();i++){
                System.out.println((i+1)+" - "+takim.bilgiGetir().get(i));
            }

            System.out.println("\n0 - Çıkış");
            takimDetay=secim.nextInt();
            while (0!=takimDetay){
                takimGetir(takimDetay);
                takimDetay=secim.nextInt();
            }
            arayuz();
        }
        else if (secenek==2){
            yaris();
        }
        else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        arayuz();
    }
}