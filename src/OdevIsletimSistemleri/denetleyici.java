package OdevIsletimSistemleri;

public class denetleyici {
	boolean Denetleme;
	
	public denetleyici() {
		this.Denetleme= false;
	}
	
	public boolean SiralibellekSorgula(Proses data, Bellek bellek) {
		if(bellek.SiralamaBellek <= data.MbAlan){
			System.out.println(" Bellek tahsis ediliyor");
			return true;
			}
	    else {
	    	System.out.println("Hata Bellek tahsis edilemiyor veya fazla bellek isteiyor");
			return false;
	    }
	}
	
	
	
	public boolean ProsesZamanSorgula(Proses data) {
		if(data.prosesZamani >0) 
			return true;
		return false;
	} 
	
	
	
	public boolean ProsesYaziciSorgula(Proses data, Yazici yazici) {
		int yaziciSayi = data.YaziciSayi;
		if(yaziciSayi == 0)
			return true;
		if(yaziciSayi == 1)
		{
			if(yazici.Yazici1Hazirmi())
			{
				System.out.println("Yazici 1 tahsis ediliyor");
				return true;
			}
			else if (yazici.Yazici2Hazirmi()) {
				System.out.println("Yazici 2 tahsis ediliyor");
				return true;
			}
			else {
				System.out.println("Yazicilar dolu sıraya alındı");
				return false;
			}
		}
		if(yaziciSayi == 2)
		{
			if(yazici.Yazici1Hazirmi()&&yazici.Yazici2Hazirmi())
			{
				System.out.println("Yazici 1 ve 2 tahsis ediliyor");
				return true;
			}
			else {
				System.out.println("Yazicilar dolu sıraya alındı");
				return false;
			}
		}
		System.out.println("Yazicida hata ");
		return false;
	} 
	
	
	
	
	public boolean ProsesCDSorgula(Proses data, CD cd) {
		int CDSayi = data.CdSurucuSayi;
		if(CDSayi == 0)
			return true;
		if(CDSayi == 1)
		{
			if(cd.CD1Hazirmi())
			{
				System.out.println("Yazici 1 tahsis ediliyor");
				return true;
			}
			else if (cd.CD2Hazirmi()) {
				System.out.println("Yazici 2 tahsis ediliyor");
				return true;
			}
			else {
				System.out.println("Yazicilar dolu sıraya alındı");
				return false;
			}
		}
		if(CDSayi == 2)
		{
			if(cd.CD1Hazirmi()&&cd.CD2Hazirmi())
			{
				System.out.println("Yazici 1 ve 2 tahsis ediliyor");
				return true;
			}
			else {
				System.out.println("Yazicilar dolu sıraya alındı");
				return false;
			}
		}
		System.out.println("Yazicida hata ");
		return false;
	} 
	
	
	
	public boolean ProsesTarayiciSorgula(Proses data, Tarayici tarayici) {
		int TarayiciSayi = data.TarayiciSayi;
		if(TarayiciSayi == 0)
			return true;
		if(TarayiciSayi == 1)
		{
			if(tarayici.Tarayici1Hazirmi())
			{
				System.out.println("Tarayici 1 tahsis ediliyor");
				return true;
			}
			else {
				System.out.println("Tarayicilar dolu sıraya alındı");
				return false;
			}
		}
		
		System.out.println("Tarayicida hata ");
		return false;
	} 
	
	
	public boolean ProsesModemSorgula(Proses data, Modem modem) {
		int ModemSayi = data.ModemSayi;
		if(ModemSayi == 0)
			return true;
		if(ModemSayi == 1)
		{
			if(modem.Modem1Hazirmi())
			{
				System.out.println("Modem 1 tahsis ediliyor");
				return true;
			}
			else {
				System.out.println("Modem dolu sıraya alındı");
				return false;
			}
		}
		System.out.println("Modemde hata");
		return false;
	} 
	
	
	public boolean DenetlemeGercek(Proses data, Bellek bellek) {
		int sayi = 0;
		// 
		if(data.oncelik == 0) {
			sayi++;
		}
		else
		{
			System.out.println("Hata grçek zamanlı değil");
			return false;
		}
		if(bellek.GercekBellek <=  data.MbAlan) {
			System.out.println("Hata Bellek tahsis ediliyor");
			bellek.GercekBellek = bellek.GercekBellek - data.MbAlan;
			sayi++;}
		else {
		  System.out.println("Hata Bellek tahsis edilemiyor veya fazla bellek isteiyor");
			return false;
		}
		if(data.prosesZamani > 0) {
			sayi++;
		}
		else {
			System.out.println("Hata gönderilen proses zaten bitmiş");
			return false;
		}
	
		if(sayi==3)	
		return true;
		return false;
	}
	
	
	
	public boolean DenetlemeSirali(Proses data, Bellek bellek, Yazici yazici, Modem modem,Tarayici tarayici,CD cd) {
		
	 
	    if( SiralibellekSorgula(data, bellek)
	    	&& ProsesZamanSorgula(data) 
	    	&& ProsesYaziciSorgula(data,yazici) 
	    	&& ProsesModemSorgula(data,modem)
	    	&& ProsesTarayiciSorgula(data,tarayici)
	    	&& ProsesCDSorgula(data,cd)) 
	     return true;
	     return false;
	 
	}
	
}
















