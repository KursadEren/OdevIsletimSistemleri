package OdevIsletimSistemleri;

public class Proses {
	int varisZamani;
	int oncelik;
	int prosesZamani;
	int MbAlan;
	int YaziciSayi;
	int TarayiciSayi;
	int ModemSayi;
	int CdSurucuSayi;
	
	public Proses(int varisZamani,int oncelik,int prosesZamani,int MbAlan,int YaziciSayi,int TarayiciSayi,int ModemSayi,int CdSurucuSayi )
	{
		this.varisZamani =varisZamani;
		this.oncelik=oncelik;
		this.prosesZamani=prosesZamani;
		this.MbAlan=MbAlan;
		this.YaziciSayi=YaziciSayi;
		this.TarayiciSayi=TarayiciSayi;
		this.ModemSayi=ModemSayi;
		this.CdSurucuSayi=CdSurucuSayi;
	}
	@Override
    public String toString() {
        return "Varış Zamanı: " + varisZamani +
                ", Öncelik: " + oncelik +
                ", Proses Zamanı: " + prosesZamani +
                ", Mb Alan: " + MbAlan +
                ", Yazıcı Sayısı: " + YaziciSayi +
                ", Tarayıcı Sayısı: " + TarayiciSayi +
                ", Modem Sayısı: " + ModemSayi +
                ", CD Sürücü Sayısı: " + CdSurucuSayi;
    }

}
