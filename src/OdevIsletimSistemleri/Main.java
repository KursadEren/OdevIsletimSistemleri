// Main.java

package OdevIsletimSistemleri;

public class Main {
    public static void main(String[] args) {
        BagliListe liste = new BagliListe();
        DosyadanOkuma dosyaOkuma = new DosyadanOkuma("C:\\Users\\keren\\eclipse-workspace\\OdevIsletimSistemleri\\src\\OdevIsletimSistemleri\\giris.txt");
        denetleyici denetle = new denetleyici();
        dosyaOkuma.okuma(liste);
        System.out.println("  Pid   varış   öncelik   cpu   MBytes   prn   scn   modem   cd   status");
        Bellek bellek = new Bellek();
        Yazici yazici = new Yazici();
        Tarayici tarayici = new Tarayici();
        Modem modem = new Modem();
        CD cd = new CD();

        BagliListe p0 = new BagliListe();
        BagliListe p1 = new BagliListe();
        BagliListe p2 = new BagliListe();
        BagliListe p3 = new BagliListe();

        for (int i = 0; i < liste.Count; i++) {
            if (liste.head.data.oncelik == 0) {
                p0.ekle(liste.head.data);
            } else if (liste.head.data.oncelik == 1) {
                p1.ekle(liste.head.data);
            } else if (liste.head.data.oncelik == 2) {
                p2.ekle(liste.head.data);
            } else if (liste.head.data.oncelik == 3) {
                p3.ekle(liste.head.data);
            }
            liste.Sonraki();
        }

        int count = 0;

        while (true) {
        	
            if (p0.head.data != null) {
                if (p0.head.data.varisZamani <= count) {
                	
                	
                    if (denetle.DenetlemeSirali(p0.head.data, bellek, yazici, modem, tarayici, cd)) {
                        p0.head.data.durum = "Aktif";
                        p0.head.data.baslamaZamaniAta(count);
                        p0.head.data.varisZamani--;
                        p0.head.data.ProsesBasladi();
                        p0.head.data.kackereCalisti++;
               
                    } else {
                        if (p0.head.data.durum == "Askıda") {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p0.Headyazdir();
                            System.out.println("Askıya Alındı");
                        } else {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p0.Headyazdir();
                            System.out.println(p0.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                            p0.BasDugumSil(liste);
                        }
                    }
               
                	
                	
              }
            }
        
            if (p1.head.data != null) {
                if (p1.head.data.varisZamani <= count) {
                	if(count - p1.head.data.baslamaZaman  == 1) {
                		if(p1.head.data.varisZamani !=0 && p1.head.data.kackereCalisti == 1)
                		{
                		 p2.ekle(p1.head.data);
                		 p1.removeHead();	
                		}
                	}
                    if (denetle.DenetlemeSirali(p1.head.data, bellek, yazici, modem, tarayici, cd) && p1.head.data.baslamaZaman != 0 ) {
                    	if( p0.head.data.baslamaZaman == -1)
                    	{
                    		p1.head.data.durum = "Aktif";
                        	p1.head.data.baslamaZamaniAta(count);
                        	p1.head.data.varisZamani--;
                        	p1.head.data.ProsesBasladi();
                        	p1.head.data.kackereCalisti++;
                    	}
                    	else {
                    		p1.head.data.durum = "Askıda";
                    	}

                    } 
                    else {
                        if (p1.head.data.durum == "Askıda") {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p1.Headyazdir();
                            System.out.println("Askıya Alındı");
                        } else {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p1.Headyazdir();
                            System.out.println(p1.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                            p1.BasDugumSil(liste);
                        }
                    }
                }
            }
            if (p2.head.data != null) {
                if (p2.head.data.varisZamani <= count) {
                	if(count - p2.head.data.baslamaZaman  == 1) {
                		if(p2.head.data.varisZamani !=0 && p2.head.data.kackereCalisti == 1)
                		{
                			System.out.println("----------------------------------------------------");
                		 p3.ekle(p2.head.data);
                		 p2.removeHead();	
                		}
                	}
                    if (denetle.DenetlemeSirali(p2.head.data, bellek, yazici, modem, tarayici, cd) && (p2.head.data.baslamaZaman != 0 )) {
                    	if( p0.head.data.baslamaZaman == -1 &&  p1.head.data.baslamaZaman == -1 ) {
                    	p2.head.data.durum = "Aktif";
                    	p2.head.data.kackereCalisti++;
                    	p2.head.data.baslamaZamaniAta(count);
                    	p2.head.data.varisZamani--;
                    	p2.head.data.ProsesBasladi();
                    	
                    	
                    	}
                    	else {
                    		 System.out.println(p2.head.data.pid + " Askıya Alındı");
                    		 p2.head.data.durum = "Askıda";
                    		 yazici.iade();
                             tarayici.iade();
                             modem.iade();
                             bellek.iade();
                             p2.Headyazdir();
                             System.out.println("Askıya Alındı");
                    	}
                    } else {
                        if (p2.head.data.durum == "Askıda") {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p2.Headyazdir();
                            System.out.println("Askıya Alındı");
                        } else {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p2.Headyazdir();
                            System.out.println(p2.head.data.pid+p2.head.data.durum  + "      hata Proses çok fazla kaynak istiyor");
                            p2.BasDugumSil(liste);
                        }
                    }
                }
            }
            if (p3.head.data != null) {
                if (p3.head.data.varisZamani <= count) {
                	
                    if (denetle.DenetlemeSirali(p3.head.data, bellek, yazici, modem, tarayici, cd)&& (p3.head.data.baslamaZaman != 0 && p0.head.data.baslamaZaman == 0)) {
                    	p3.head.data.durum = "Aktif";
                    	p3.head.data.baslamaZamaniAta(count);
                    	p3.head.data.varisZamani--;
                    	p3.head.data.ProsesBasladi();
                    } else {
                        if (p3.head.data.durum == "Askıda") {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p3.Headyazdir();
                            System.out.println("Askıya Alındı");
                        } else {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p3.Headyazdir();
                            System.out.println(p3.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                            p3.BasDugumSil(liste);
                        }
                    }
                }
            }

            
            System.out.println(count + "--------------------------------------------------------------------------");
            count++;
            if(count == 25)
            	break;
        }
    }
}
