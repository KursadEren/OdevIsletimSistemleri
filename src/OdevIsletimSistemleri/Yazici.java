package OdevIsletimSistemleri;

public class Yazici {
    
	boolean YaziciHazir1 = true;
	boolean YaziciHazir2 = true;

	public void Yazici1Calisiyor() {
		System.out.println( "Yazici 1 Calisiyor");
		
	}
	public void Yazici1Durdu() {
		System.out.println( "Yazici 1 Durdu");
		
	}
	public void Yazici2Calisiyor() {
		System.out.println( "Yazici 1 Calisiyor");
		
	}
	public void Yazici2Durdu() {
		System.out.println( "Yazici 1 Durdu");
		
	}
	public boolean Yazici1Hazirmi() {
		return this.YaziciHazir1;
	}
	public boolean Yazici2Hazirmi() {
		return this.YaziciHazir2;
	}
}

