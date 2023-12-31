package OdevIsletimSistemleri;

public class denetleyici {
    boolean Denetleme;
    denetleyici denetle;
    public denetleyici() {
        this.Denetleme = false;
    }

    public boolean SiralibellekSorgula(Proses data, Bellek bellek) {
        if (data.oncelik == 0) {
            if (bellek.GercekBellek >= data.MbAlan) {
            	bellek.GercekBellek -= data.MbAlan;
            		
                System.out.println(data.pid + " Bellek tahsis ediliyor");
                return true;
            } else 
                System.out.println(data.pid +  " Hata Bellek tahsis edilemiyor İşlem iptal alındı ");
                data.durum = "iptal";
                return false;

        } else {
            if (bellek.SiralamaBellek >= data.MbAlan) {
            	bellek.SiralamaBellek-=data.MbAlan;
                System.out.println(data.pid +" Bellek tahsis ediliyor");
                return true;
            } else {
            	
            	
                System.out.println(data.pid  +  " Hata Bellek tahsis edilemiyor İşlem iptal alındı ");
                data.durum = "iptal";
                return false;
            	
               
            }
        }
    }

    public boolean ProsesZamanSorgula(Proses data) {
        if (data.prosesZamani > 0)
            return true;
        return false;
    }

    public boolean ProsesYaziciSorgula(Proses data, Yazici yazici) {
        int yaziciSayi = data.YaziciSayi;
        if (yaziciSayi == 0)
            return true;
        if (yaziciSayi == 1) {
            if (yazici.Yazici1Hazirmi()) {
         
                yazici.YaziciHazir1 = false;
               
                return true;
            } else if (yazici.Yazici2Hazirmi()) {
           
                yazici.YaziciHazir2 = false;
                return true;
            } else {
             
                data.durum = "Askıda";
                return false;
            }
        }
        if (yaziciSayi == 2) {
            if (yazici.Yazici1Hazirmi() && yazici.Yazici2Hazirmi()) {
               
                yazici.YaziciHazir1 = false;
                yazici.YaziciHazir2 = false;
                return true;
            } else {
               
                data.durum = "Askıda";
                return false;
            }
        }
       
        return false;
    }

    public boolean ProsesCDSorgula(Proses data, CD cd) {
        int CDSayi = data.CdSurucuSayi;
        if (CDSayi == 0)
            return true;
        if (CDSayi == 1) {
            if (cd.CD1Hazirmi()) {
                
                cd.CDHazir1 = false;
                return true;
            } else if (cd.CD2Hazirmi()) {
                cd.CDHazir2 = false;
           
                return true;
            } else {
              
                data.durum = "Askıda";
                return false;
            }
        }
        if (CDSayi == 2) {
            if (cd.CD1Hazirmi() && cd.CD2Hazirmi()) {
            
                cd.CDHazir1 = false;
                cd.CDHazir2 = false;
                return true;
            } else {
             
                data.durum = "Askıda";
                return false;
            }
        }
       
        return false;
    }

    public boolean ProsesTarayiciSorgula(Proses data, Tarayici tarayici) {
        int TarayiciSayi = data.TarayiciSayi;
        if (TarayiciSayi == 0)
            return true;
        if (TarayiciSayi == 1) {
            if (tarayici.Tarayici1Hazirmi()) {
              
                tarayici.TarayiciHazir1 = false;
                return true;
            } else {
        
                data.durum = "Askıda";
                return false;
            }
        }

       
        return false;
    }

    public boolean ProsesModemSorgula(Proses data, Modem modem) {
        int ModemSayi = data.ModemSayi;
        if (ModemSayi == 0)
            return true;
        if (ModemSayi == 1) {
            if (modem.Modem1Hazirmi()) {
                
                return true;
            } else {
                
                data.durum = "Askıda";
                return false;
            }
        }
        System.out.println(data.pid +" Modemde hata");
        return false;
    }

    public boolean DenetlemeSirali(Proses data, Bellek bellek, Yazici yazici, Modem modem, Tarayici tarayici, CD cd,boolean calisan) {
    	
    	
    	
        if (data.oncelik == 0 && (data.YaziciSayi != 0 || data.ModemSayi != 0 || data.TarayiciSayi != 0 || data.CdSurucuSayi != 0  || data.MbAlan>64))
        	{
        	data.durum="iptal";
        	return false;
        	}
           if(data.oncelik !=0 && (data.YaziciSayi > 2 || data.ModemSayi > 1 || data.TarayiciSayi > 1 || data.CdSurucuSayi > 2 || data.MbAlan>960))
           { 
        	data.durum="iptal";
        	return false;
           }
           
        if (SiralibellekSorgula(data, bellek)
                && ProsesZamanSorgula(data)
                && ProsesYaziciSorgula(data, yazici)
                && ProsesModemSorgula(data, modem)
                && ProsesTarayiciSorgula(data, tarayici)
                && ProsesCDSorgula(data, cd)) {
        		
        		if(calisan==true) {
        			System.out.println("Çalışan başka bir proses var");
        			data.durum="Askıda";
        		return false;}
        		else
        			data.durum = "Aktif";
            return true;
        }
        data.durum="iptal";
        return false;
    }
    public void ZamanAsimi(BagliListe p0,BagliListe p1, BagliListe p2,BagliListe p3 , int count) {
    	ZamanAsimi(p0,count);
    	
    	ZamanAsimi(p1,count);
    	
    	ZamanAsimi(p2,count);
    	ZamanAsimi(p3,count);
    	
    }
 
    public void ZamanAsimi(BagliListe liste, int count) {
        Node current = liste.head;
        Node temp;

        while (current != null) {
        	
            if (count - current.data.varisZamani   >= 20 ) {
                temp = current.next; // Sonraki düğümü geçici bir değişkene kaydet
                liste.deleteNode(current); // Düğümü sil
                current = temp; // Güncellenmiş current ile devam et
            } else {
                current = current.next; // Eğer silme işlemi yapmadıysan sıradaki düğüme geç
            }
        }
    





    

    }
    
    
}
