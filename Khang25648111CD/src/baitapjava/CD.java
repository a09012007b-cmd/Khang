package baitapjava;

public class CD {
	private int maCD = 999999;
	private String tuaCD = "Chua xac dinh";
	private int sobaihat;
	private float giathanh;
	
	//Constructor
	public CD(int maCD, String tuaCD, int sobaihat, float giathanh) {
		setMa(maCD);
	    setTua(tuaCD);
	    setSbh(sobaihat);
	    setGt(giathanh);
	}
	
	//Getter
	public int getMa() { return maCD; }
	public String getTua() { return tuaCD; }
	public int getSbh() { return sobaihat; }
	public float getGiathanh() { return giathanh; }
	
	//Setter
	public void setMa(int maCD) {
		if(maCD < 0) {
			System.out.println("So da nhap be hon 0!");
			return;
		}
		this.maCD = maCD;
	}
	
	public void setTua(String tuaCD) {
		if(tuaCD == null || tuaCD.isEmpty()) {
			System.out.println("Ten rong!");
			this.tuaCD = "Chua xac dinh";
		}
		else {
			this.tuaCD = tuaCD;
		}
	}
	
	public void setSbh(int sobaihat) {
		if(sobaihat < 0) {
			System.out.println("So vua nhap be hon 0!");
			return;
		}
		else {
			this.sobaihat = sobaihat;
		}
		
	}
	
	public void setGt(float giathanh) {
		if(giathanh < 0) {
			System.out.println("So vua nhap lon hon 0!");
		}
		else {
			this.giathanh = giathanh;
		}
	}
	@Override
	public String toString() {
		return "CD[MaCD =" + maCD + "TuaCD: " + tuaCD + "SoBaiHat: " + sobaihat + "Giathanh: " + giathanh + "]";
	}
	
}
