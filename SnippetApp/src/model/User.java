package model;


public class User {
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private int phone;
	private String email;
	private String address;
	private String blokiran;
	
	public User(){
		
	}

	public User(String userName, String password, String firstName,
			String lastName, String role, int phone, String email,
			String address, String image) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.blokiran = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlokiran() {
		return blokiran;
	}

	public void setBlokiran(String blokiran) {
		this.blokiran = blokiran;
	}

	@Override
	public String toString() {
		return userName + "|" + password+ "|" +firstName+ "|" +lastName+ "|" +role+ "|" +phone+ "|" +email+ "|" +address+ "|" +blokiran;
	}
	
	
	
}
