package OdevIsletimSistemleri;

public class denetleyici {
	boolean Denetleme;
	
	public denetleyici() {
		this.Denetleme= false;
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
	
			
		return true;
	}
}
