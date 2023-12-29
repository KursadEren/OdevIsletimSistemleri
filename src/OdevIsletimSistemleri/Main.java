// Main.java

package OdevIsletimSistemleri;

public class Main {
    public static void main(String[] args) {
        BagliListe liste = new BagliListe();
        DosyadanOkuma dosyaOkuma = new DosyadanOkuma("C:\\Users\\keren\\eclipse-workspace\\OdevIsletimSistemleri\\src\\OdevIsletimSistemleri\\giris.txt");

        dosyaOkuma.okuma(liste);
        
        BagliListe p0 = new BagliListe();
        BagliListe p1 = new BagliListe();
        BagliListe p2 = new BagliListe();
        BagliListe p3 = new BagliListe();
       
        for(int i =0; i<liste.Count; i++) {
        	if(liste.head.data.varisZamani == 0)
        	{
        		p0.ekle(liste.head.data);
        	}
        	else if(liste.head.data.varisZamani == 1)
        	{
        		p1.ekle(liste.head.data);
        	}
        	else if(liste.head.data.varisZamani == 2)
        	{
        		p2.ekle(liste.head.data);
        	}
        	else if(liste.head.data.varisZamani == 3)
        	{
        		p3.ekle(liste.head.data);
        	}
        }
       
        int sure;
        Bellek bellek = new Bellek();
        
        while(true) {
        	if(p0.head != null) {
        		
        	}
        	
        	
        }
        
        
    }
}
