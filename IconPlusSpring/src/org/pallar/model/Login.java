package org.pallar.model;

public class Login {
private String username;
private String password;
public Login() {}

public Login(String username, String password) {

	this.username = username;
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getpassword() {
	return password;
}
public void setpassword(String password) {
	this.password = password;
}
}
