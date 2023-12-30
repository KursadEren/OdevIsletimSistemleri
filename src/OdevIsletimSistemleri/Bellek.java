package OdevIsletimSistemleri;

public class Bellek {
   int Bellek;
   int GercekBellek;
   int SiralamaBellek;
   int GercekBellekTakip;
   int SiralamaBellekTakip;
   
   public Bellek() {
   this.Bellek = 1024;
   this.GercekBellek = 64;
   this.SiralamaBellek = Bellek - GercekBellek;
   this.GercekBellekTakip = 64;
   this.SiralamaBellekTakip = 960;
   }
   
   public void GercekBellekYetki(int sayi)
   {	
	   this.Bellek = this.Bellek-sayi;
   }
   
   public void SıralamaBellek(int sayi)
   {	
	   this.SiralamaBellek = this.SiralamaBellek-sayi;
   }
   public void iade()
   {	
	   this.SiralamaBellek = 960;
	   this.GercekBellek = 960;
   }
}


