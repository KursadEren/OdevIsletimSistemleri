package OdevIsletimSistemleri;

public class Tarayici {

	boolean TarayiciHazir1;
	int tarayicisayi;
	
	
	
	public Tarayici() {
		this.TarayiciHazir1=true;
	
		this.tarayicisayi=1;
	}
	
	public void Tarayici1Calisiyor() {
	this.TarayiciHazir1=false;
		System.out.println( "Tarayici 1 Calisiyor");
		
	}
	public void Tarayici1Durdu() {
		this.TarayiciHazir1=true;
		System.out.println( "Tarayici 1 Durdu");
		
	}
	
	public boolean Tarayici1Hazirmi() {
		return this.TarayiciHazir1;
	}
	public void iade() {
		this.TarayiciHazir1=true;
	}
	

}



	

