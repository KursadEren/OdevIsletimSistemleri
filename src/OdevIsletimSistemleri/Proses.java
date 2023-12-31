package OdevIsletimSistemleri;

public class Proses {
	int pid;
	int varisZamani;
	int oncelik;
	int prosesZamani;
	int MbAlan;
	int YaziciSayi;
	int TarayiciSayi;
	int ModemSayi;
	int CdSurucuSayi;
	String durum;
	int baslamaZaman;
	int kackereCalisti;
	
	public Proses(int varisZamani,int oncelik,int prosesZamani,int MbAlan,int YaziciSayi,int TarayiciSayi,int ModemSayi,int CdSurucuSayi,String durum,int pid )
	{
		this.varisZamani =varisZamani;
		this.oncelik=oncelik;
		this.prosesZamani=prosesZamani;
		this.MbAlan=MbAlan;
		this.YaziciSayi=YaziciSayi;
		this.TarayiciSayi=TarayiciSayi;
		this.ModemSayi=ModemSayi;
		this.CdSurucuSayi=CdSurucuSayi;
		this.durum = durum;
		this.pid = pid;
		this.baslamaZaman =-1;
		this.kackereCalisti=0;
		
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
     
	public void baslamaZamaniAta(int deger)
	{
		this.baslamaZaman = deger;
	}
	public void ProsesBasladi()
	{
		System.out.println(this.pid + " Çalışmaya basladi");
	}
}
