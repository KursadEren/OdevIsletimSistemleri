// DosyadanOkuma.java

package OdevIsletimSistemleri;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DosyadanOkuma {
    private String dosyaYolu;

    public DosyadanOkuma(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }

    public void okuma(BagliListe bagliListe) {
        try {
            Path dosya = Paths.get(this.dosyaYolu);
            Scanner scanner = new Scanner(dosya);
            int Count =0;
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] sayiStr = satir.split(",");
                Count++;
                int varisZamani = Integer.parseInt(sayiStr[0].trim());
                int oncelik = Integer.parseInt(sayiStr[1].trim());
                int prosesZamani = Integer.parseInt(sayiStr[2].trim());
                int MbAlan = Integer.parseInt(sayiStr[3].trim());
                int YaziciSayi = Integer.parseInt(sayiStr[4].trim());
                int TarayiciSayi = Integer.parseInt(sayiStr[5].trim());
                int ModemSayi = Integer.parseInt(sayiStr[6].trim());
                int CdSurucuSayi = Integer.parseInt(sayiStr[7].trim());
                
                Proses yeniProses = new Proses(varisZamani, oncelik, prosesZamani, MbAlan, YaziciSayi, TarayiciSayi, ModemSayi, CdSurucuSayi,"pasif",Count);
                bagliListe.ekle(yeniProses);
            }
            
            bagliListe.Count=Count;
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
