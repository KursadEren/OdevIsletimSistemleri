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
        boolean CalisanProses = false;
        BagliListe p0 = new BagliListe();
        BagliListe p1 = new BagliListe();
        BagliListe p2 = new BagliListe();
        BagliListe p3 = new BagliListe();
        BagliListe liste2 = new BagliListe();
        
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
        int count2=0;
        
        while (true) {
        	count2++;
        	
            if (p0.head != null) {
                if (p0.head.data.varisZamani <= count) {
                	
                	if(p0.head.data.baslamaZaman != -1 )
                  	{
                		if(p0.head.data.prosesZamani == 0)
                    	{
                    		 CalisanProses = false;
                    		 System.out.println(p0.head.data.pid + " Proses tamamlandı");
                    		 yazici.iade();
                             tarayici.iade();
                             modem.iade();
                             cd.iade();
                             bellek.iade();
                             p0.Headyazdir();
                    		 p0.removeHead();
                    		 count++;
                    		
                    		 continue;
                    	}
                		
                  		p0.head.data.prosesZamani--;
                  		
                  	}
                    	
                	if(p0.head.data.baslamaZaman == -1) {
                     boolean deneme =denetle.DenetlemeSirali(p0.head.data, bellek, yazici, modem, tarayici, cd,CalisanProses);
                	
                	
                    if (deneme && p0.head.data.durum == "Aktif") {
                     
                        p0.head.data.baslamaZamaniAta(count);
                        p0.head.data.prosesZamani--;
                        p0.head.data.ProsesBasladi();
                        CalisanProses = true;
                        count++;
                        
                        continue;
                    } 
                    else  if (p0.head.data.durum == "Askıda") {
                            yazici.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            cd.iade();
                            p0.Headyazdir();
                            System.out.println("Askıya Alındı");
                        } 
                        else if(p0.head.data.durum=="iptal") {
                            yazici.iade();
                            cd.iade();
                            tarayici.iade();
                            modem.iade();
                            bellek.iade();
                            p0.Headyazdir();
                            System.out.println(p0.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                            p0.removeHead();
                        }
                    }
                    
                  
                } 
               
            	
            	 
              }
            
            if(p1.head != null) {
            	if(p1.head.data.varisZamani <= count ) {
            		if(p1.head.data.baslamaZaman != -1 && p1.head.data.kackereCalisti==1 )
                	{
            			p1.Headyazdir();
                        p1.head.data.oncelik++;
                        p2.ekle(p1.head.data);
                        p1.removeHead();
                        CalisanProses=false;
                        
                	}
        		
            		if(p2.head!=null&& p3.head!=null&&p2.head.data.pid > p1.head.data.pid && p3.head.data.pid > p1.head.data.pid)
            		{
            			
                		if(p1.head.data.baslamaZaman == -1) {
                            boolean deneme =denetle.DenetlemeSirali(p1.head.data, bellek, yazici, modem, tarayici, cd,CalisanProses);
                       	
                       
                           if (deneme && p1.head.data.durum == "Aktif") {
                            
                               p1.head.data.baslamaZamaniAta(count);
                               p1.head.data.prosesZamani--;
                               p1.head.data.ProsesBasladi();
                               p1.head.data.kackereCalisti++;
                               CalisanProses = true;
                              
                             
                           } 
                           else  if (p1.head.data.durum == "Askıda") {
                                   yazici.iade();
                                   tarayici.iade();
                                   modem.iade();
                                   bellek.iade();
                                   cd.iade();
                                   p1.Headyazdir();
                                   p1.head.data.oncelik++;
                                   p2.ekle(p1.head.data);
                                   p1.removeHead();
                                   System.out.println("Askıya Alındı");
                               } 
                               else if(p1.head.data.durum=="iptal") {
                                   yazici.iade();
                                   cd.iade();
                                   tarayici.iade();
                                   modem.iade();
                                   bellek.iade();
                                   p1.Headyazdir();
                                   System.out.println(p1.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                                   p1.removeHead();
                               }
                           }
                			if(p1.head != null)
                    		if(p1.head.data.prosesZamani == 0)
                        	{
                        		 CalisanProses = false;
                        		 System.out.println(p1.head.data.pid + " Proses tamamlandı");
                        		 yazici.iade();
                                 tarayici.iade();
                                 modem.iade();
                                 cd.iade();
                                 bellek.iade();
                                 p1.Headyazdir();
                        		 p1.removeHead();
                        		
                        		 
                        	}
                    		
                	}
            	}
            	
            }
            
            if(p2.head != null) {
            	if(p2.head.data.varisZamani <= count ) {
            		if(p2.head.data.baslamaZaman != -1 && p2.head.data.kackereCalisti ==1)
                	{
            			p2.Headyazdir();
                        p2.head.data.oncelik++;
                        p3.ekle(p2.head.data);
                        p2.head.data.ProsesDurdu();
                        p2.removeHead();
                        
                        CalisanProses=false;
                	}
            		if(p3.head.data.pid > p2.head.data.pid)
            		{
                		if(p2.head.data.baslamaZaman == -1) {
                            boolean deneme =denetle.DenetlemeSirali(p2.head.data, bellek, yazici, modem, tarayici, cd,CalisanProses);
                       	
                       
                           if (deneme && p2.head.data.durum == "Aktif") {
                            
                        	   p2.head.data.baslamaZamaniAta(count);
                        	   p2.head.data.prosesZamani--;
                        	   p2.head.data.ProsesBasladi();
                        	   p2.head.data.kackereCalisti++;
                               CalisanProses = true;
                              
                             
                           } 
                             if (p2.head.data.durum == "Askıda") {
                                   yazici.iade();
                                   tarayici.iade();
                                   modem.iade();
                                   bellek.iade();
                                   cd.iade();
                                   p2.Headyazdir();
                                   p2.head.data.oncelik++;
                                   p3.ekle(p2.head.data);
                                   p2.removeHead();
                                   System.out.println("Askıya Alındı");
                               } 
                               else if(p2.head.data.durum=="iptal") {
                                   yazici.iade();
                                   cd.iade();
                                   tarayici.iade();
                                   modem.iade();
                                   bellek.iade();
                                   p2.Headyazdir();
                                   System.out.println(p2.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                                   p2.removeHead();
                               }
                           }
                		if(p2.head !=null)
                    		if(p2.head.data.prosesZamani == 0)
                        	{
                        		 CalisanProses = false;
                        		 System.out.println(p2.head.data.pid + " Proses tamamlandı");
                        		 yazici.iade();
                                 tarayici.iade();
                                 modem.iade();
                                 cd.iade();
                                 bellek.iade();
                                 p2.Headyazdir();
                                 p2.removeHead();
                        		
                        		 
                        	}
                    		
                		
                	}
            	}
            	
            }
            if(p3.head != null) {
            	if(p3.head.data.varisZamani <= count ) {
            		if(p3.head.data.baslamaZaman != -1&& p3.head.data.kackereCalisti==1)
                	{
            			p3.Headyazdir();
                        p3.head.data.oncelik++;
                        p3.ekle(p3.head.data);
                        p3.head.data.ProsesDurdu();
                        p3.removeHead();
                        CalisanProses=false;
                	}
                		if(p3.head.data.baslamaZaman == -1) {
                            boolean deneme =denetle.DenetlemeSirali(p3.head.data, bellek, yazici, modem, tarayici, cd,CalisanProses);
                       	
                       
                           if (deneme && p3.head.data.durum == "Aktif") {
                            
                        	   p3.head.data.baslamaZamaniAta(count);
                        	   p3.head.data.prosesZamani--;
                        	   p3.head.data.ProsesBasladi();
                               CalisanProses = true;
                              
                             
                           } 
                           else  if (p3.head.data.durum == "Askıda") {
                                   yazici.iade();
                                   tarayici.iade();
                                   modem.iade();
                                   bellek.iade();
                                   cd.iade();
                                   p3.Headyazdir();
                                   p3.head.data.oncelik++;
                                   p3.ekle(p3.head.data);
                                   p3.removeHead();
                                   System.out.println("Askıya Alındı");
                               } 
                               else if(p3.head.data.durum=="iptal") {
                                   yazici.iade();
                                   cd.iade();
                                   tarayici.iade();
                                   modem.iade();
                                   bellek.iade();
                                   p3.Headyazdir();
                                   System.out.println(p3.head.data.pid + "  hata Proses çok fazla kaynak istiyor");
                                   p3.removeHead();
                               }
                           }
                		
                    		if(p3.head.data.prosesZamani == 0)
                        	{
                        		 CalisanProses = false;
                        		 System.out.println(p3.head.data.pid + " Proses tamamlandı");
                        		 yazici.iade();
                                 tarayici.iade();
                                 modem.iade();
                                 cd.iade();
                                 bellek.iade();
                                 p3.Headyazdir();
                                 p3.removeHead();
                        		
                        		 
                        	}
                    		
                		
                	}
            	
            	
            }
            	
                denetle.ZamanAsimi(p0,p1,p2,p3,count2);
            
                if(p0.head==null && p1.head==null&& p2.head==null )
            		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            
            if(p0.head != null && p1.head != null && p2.head != null)
            {
            	if(p0.head.data.varisZamani != count&& p1.head.data.varisZamani != count &&p2.head.data.varisZamani != count && p3.head.data.varisZamani != count )
                {count++;  System.out.println(count+ " " + "--------------------------------------------------------------------------");}
                
            }
            if(p0.head==null && p1.head==null&& p2.head==null && p3.head == null )
            	break;
            
        }
    }
}
