// Main.java

package OdevIsletimSistemleri;

public class Main {
    public static void main(String[] args) {
        BagliListe liste = new BagliListe();
        DosyadanOkuma dosyaOkuma = new DosyadanOkuma("C:\\Users\\keren\\eclipse-workspace\\OdevIsletimSistemleri\\src\\OdevIsletimSistemleri\\giris.txt");
        denetleyici denetle= new denetleyici();
        dosyaOkuma.okuma(liste);
        int sure=0;
        Bellek bellek = new Bellek();
        Yazici yazici = new Yazici();
        Tarayici tarayici = new Tarayici();
        Modem modem  = new Modem();
        CD cd = new CD();
        
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
       
        
       
        while(true) {//(p0.head.data,bellek,yazici,tarayici,modem,cd);
        	if(p0.head != null) {
        		denetle.DenetlemeGercek(p0.head.data, bellek);
        		
        		
        	}
        	
        	
        	sure++;
        }
        
        
    }
}
