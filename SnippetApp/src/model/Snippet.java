package model;

public class Snippet {
	
	private int id;
	private String userName;
	private String vremeDatum;
	private String opis;
	private String kod;
	private String jezik;
	private String urlKoda;
	private String blokKom;
	
	public Snippet(){
		
	}

	public Snippet(int id, String userName, String vremeDatum, String opis, String kod, String jezik, String urlKoda, String blokKom) {
		super();
		this.id = id;
		this.opis = opis;
		this.kod = kod;
		this.jezik = jezik;
		this.urlKoda = urlKoda;
		this.userName = userName;
		this.vremeDatum = vremeDatum;
		this.blokKom = blokKom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getJezik() {
		return jezik;
	}

	public void setJezik(String jezik) {
		this.jezik = jezik;
	}

	public String getUrlKoda() {
		return urlKoda;
	}

	public void setUrlKoda(String urlKoda) {
		this.urlKoda = urlKoda;
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVremeDatum() {
		return vremeDatum;
	}

	public void setVremeDatum(String vremeDatum) {
		this.vremeDatum = vremeDatum;
	}
	
	

	public String getBlokKom() {
		return blokKom;
	}

	public void setBlokKom(String blokKom) {
		this.blokKom = blokKom;
	}

	@Override
	public String toString() {
		return id + "|" + userName + "|" + vremeDatum + "|" + opis + "|" + urlKoda + "|" + jezik + "|" +blokKom +"|" + kod;
	}
	
	
	
	

}
