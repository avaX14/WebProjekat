package model;

public class Snippet {
	
	private Integer id;
	private String opis;
	private String kod;
	private String jezik;
	private String url;
	
	public Snippet(){
		
	}

	public Snippet(Integer id, String opis, String kod, String jezik, String url) {
		super();
		this.id = id;
		this.opis = opis;
		this.kod = kod;
		this.jezik = jezik;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return id + "|" + opis + "|" + kod + "|" + jezik + "|" + "|" + url;
	}
	
	
	
	

}
