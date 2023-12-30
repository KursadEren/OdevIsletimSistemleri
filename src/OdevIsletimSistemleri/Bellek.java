package OdevIsletimSistemleri;

public class Bellek {
   int Bellek;
   int GercekBellek;
   int SiralamaBellek;
   
   public Bellek() {
   this.Bellek = 1024;
   this.GercekBellek = 64;
   this.SiralamaBellek = Bellek - GercekBellek;
   }
   
   public void GercekBellekYetki(int sayi)
   {	
	   this.Bellek = this.Bellek-sayi;
   }
   
   public void SıralamaBellek(int sayi)
   {	
	   this.SiralamaBellek = this.SiralamaBellek-sayi;
   }
}


