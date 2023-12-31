package OdevIsletimSistemleri;

public class denetleyici {
    boolean Denetleme;

    public denetleyici() {
        this.Denetleme = false;
    }

    public boolean SiralibellekSorgula(Proses data, Bellek bellek) {
        if (data.oncelik == 0) {
            if (bellek.GercekBellek >= data.MbAlan) {
                System.out.println(data.pid + " Bellek tahsis ediliyor");
                return true;
            } else {
            	if(bellek.GercekBellek == bellek.GercekBellekTakip)
            	{
                System.out.println(data.pid +  " Hata Bellek tahsis edilemiyor İşlem askıya alındı ");
                data.durum = "Askıda";
                return false;
            	}
            	else {
            		 System.out.println(data.pid +  " Hata Bellek tahsis edilemiyor İşlem iptal ediliyor ");
            		 data.durum = "iptal";
            		 return false;
            	}
            }
        } else {
            if (bellek.SiralamaBellek >= data.MbAlan) {
                System.out.println(data.pid +" Bellek tahsis ediliyor");
                return true;
            } else {
            	if(bellek.SiralamaBellek == bellek.SiralamaBellekTakip)
            	{
                System.out.println(data.pid +  " Hata Bellek tahsis edilemiyor İşlem askıya alındı ");
                data.durum = "Askıda";
                return false;
            	}
            	else {
            		 System.out.println(data.pid +  " Hata Bellek tahsis edilemiyor İşlem iptal ediliyor ");
            		 data.durum = "iptal";
            		 return false;
            	}
               
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
                System.out.println(data.pid +" Yazici 1 tahsis ediliyor");
                yazici.YaziciHazir1 = false;
               
                return true;
            } else if (yazici.Yazici2Hazirmi()) {
                System.out.println(data.pid +" Yazici 2 tahsis ediliyor");
                yazici.YaziciHazir2 = false;
                return true;
            } else {
                System.out.println(data.pid +" Yazicilar dolu sıraya alındı");
                data.durum = "Askıda";
                return false;
            }
        }
        if (yaziciSayi == 2) {
            if (yazici.Yazici1Hazirmi() && yazici.Yazici2Hazirmi()) {
                System.out.println(data.pid +" Yazici 1 ve 2 tahsis ediliyor");
                yazici.YaziciHazir1 = false;
                yazici.YaziciHazir2 = false;
                return true;
            } else {
                System.out.println(data.pid +" Yazicilar dolu sıraya alındı");
                data.durum = "Askıda";
                return false;
            }
        }
        System.out.println(data.pid +" Yazicida hata ");
        return false;
    }

    public boolean ProsesCDSorgula(Proses data, CD cd) {
        int CDSayi = data.CdSurucuSayi;
        if (CDSayi == 0)
            return true;
        if (CDSayi == 1) {
            if (cd.CD1Hazirmi()) {
                System.out.println(data.pid +" Cd 1 tahsis ediliyor");
                cd.CDHazir1 = false;
                return true;
            } else if (cd.CD2Hazirmi()) {
                cd.CDHazir2 = false;
                System.out.println(data.pid +" Cd 2 tahsis ediliyor");
                return true;
            } else {
                System.out.println(data.pid +" Cdler dolu sıraya alındı");
                data.durum = "Askıda";
                return false;
            }
        }
        if (CDSayi == 2) {
            if (cd.CD1Hazirmi() && cd.CD2Hazirmi()) {
                System.out.println(data.pid +" CD 1 ve 2 tahsis ediliyor");
                cd.CDHazir1 = false;
                cd.CDHazir2 = false;
                return true;
            } else {
                System.out.println(data.pid +" Yazicilar dolu sıraya alındı");
                data.durum = "Askıda";
                return false;
            }
        }
        System.out.println(data.pid +" cd sürücüde hata ");
        return false;
    }

    public boolean ProsesTarayiciSorgula(Proses data, Tarayici tarayici) {
        int TarayiciSayi = data.TarayiciSayi;
        if (TarayiciSayi == 0)
            return true;
        if (TarayiciSayi == 1) {
            if (tarayici.Tarayici1Hazirmi()) {
                System.out.println(data.pid +" Tarayici 1 tahsis ediliyor");
                tarayici.TarayiciHazir1 = false;
                return true;
            } else {
                System.out.println(data.pid +"Tarayicilar dolu sıraya alındı");
                data.durum = "Askıda";
                return false;
            }
        }

        System.out.println(data.pid +" Tarayicida hata ");
        return false;
    }

    public boolean ProsesModemSorgula(Proses data, Modem modem) {
        int ModemSayi = data.ModemSayi;
        if (ModemSayi == 0)
            return true;
        if (ModemSayi == 1) {
            if (modem.Modem1Hazirmi()) {
                System.out.println(data.pid +" Modem 1 tahsis ediliyor");
                return true;
            } else {
                System.out.println(data.pid + " Modem dolu sıraya alındı");
                data.durum = "Askıda";
                return false;
            }
        }
        System.out.println(data.pid +" Modemde hata");
        return false;
    }

    public boolean DenetlemeSirali(Proses data, Bellek bellek, Yazici yazici, Modem modem, Tarayici tarayici, CD cd) {

        if (data.oncelik == 0 && (data.YaziciSayi != 0 || data.ModemSayi != 0 || data.TarayiciSayi != 0 || data.CdSurucuSayi != 0))
        	{
        	data.durum="iptal";
        	return false;
        	}
           if(data.oncelik !=0 && (data.YaziciSayi > 2 || data.ModemSayi > 1 || data.TarayiciSayi > 1 || data.CdSurucuSayi > 2))
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
        		data.durum="Aktif";
            return true;
        }
        System.out.println("77777777777777777777777777777777777777777777-");
        return false;
    }
}
