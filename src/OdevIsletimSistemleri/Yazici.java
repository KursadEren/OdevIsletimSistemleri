package OdevIsletimSistemleri;

public class Yazici {
    
	boolean YaziciHazir1;
	boolean YaziciHazir2;
	int yazicisayi;
	
	
	public Yazici() {
		this.YaziciHazir1=true;
		this.YaziciHazir2 = true;
		this.yazicisayi=2;
	}
	public void Yazici1Calisiyor() {
		this.YaziciHazir1=false;
		System.out.println( "Yazici 1 Calisiyor");
		
	}
	public void Yazici1Durdu() {
		this.YaziciHazir2=true;
		System.out.println( "Yazici 1 Durdu");
		
	}
	public void Yazici2Calisiyor() {
		this.YaziciHazir2=false;
		System.out.println( "Yazici 2 Calisiyor");
		
	}
	public void Yazici2Durdu() {
		this.YaziciHazir2=true;
		System.out.println( "Yazici 2 Durdu");
		
	}
	public boolean Yazici1Hazirmi() {
		return this.YaziciHazir1;
	}
	public boolean Yazici2Hazirmi() {
		return this.YaziciHazir2;
	}
	public void iade() {
		this.YaziciHazir1=true;
		this.YaziciHazir2=true;
	}
	
}

