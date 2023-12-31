package OdevIsletimSistemleri;

public class CD {

	boolean CDHazir1 = true;
	boolean CDHazir2 = true;
   int cdsayi;
	
	public CD() {
		this.CDHazir1=true;
		this.CDHazir2=true;
		this.cdsayi=2;
	}
	
	public void CD1Calisiyor() {
		this.CDHazir2= false;
		System.out.println( "Yazici 1 Calisiyor");
		
	}
	public void CD1Durdu() {
		this.CDHazir1=true;
		System.out.println( "Yazici 1 Durdu");
		
	}
	public void CD2Calisiyor() {
		this.CDHazir2 = false;
		System.out.println( "Yazici 2 Calisiyor");
		
	}
	public void CD2Durdu() {
		this.CDHazir2=true;
		System.out.println( "Yazici 2 Durdu");
		
	}
	public boolean CD1Hazirmi() {
		return this.CDHazir1;
	}
	public boolean CD2Hazirmi() {
		return this.CDHazir2;
	}

}



	

