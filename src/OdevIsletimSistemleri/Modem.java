package OdevIsletimSistemleri;

public class Modem {
		
	 
		boolean ModemHazir1;
		int modemsayi;


		public Modem() {
			this.ModemHazir1=true;
		
			this.modemsayi=1;
		}
		
		
		public void Modem1Calisiyor() {
			this.ModemHazir1 = false;
			System.out.println( "Modem 1 Bağlanıyor");
			
		}
		public void Modem1Durdu() {
			this.ModemHazir1=false;
			System.out.println( "Modem 1 bağlantı kesildi");
			
		}
		
		public boolean Modem1Hazirmi() {
			return this.ModemHazir1;
		}
		
		public void iade() {
			 this.ModemHazir1=true;
		}
}



   

