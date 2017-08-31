package model;

public class Snippet {
	
	public String opis;
	public String kod;
	public String jezik;
	public String url;
	
	public Snippet(){
		
	}
	
	public Snippet(String opis, String kod, String jezik, String url) {
		super();
		this.opis = opis;
		this.kod = kod;
		this.jezik = jezik;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return opis + "|" + kod+ "|" +jezik+ "|" +url;
	}
	
	

}
