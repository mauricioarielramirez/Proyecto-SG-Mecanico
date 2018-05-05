package ar.com.PSGMecanico.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author NbkGPetterin
 * Nombre de contexto de la clase en este caso user
 * Y el session scoped el tiempo de vida del bean
 */
@ManagedBean(name="user")
@SessionScoped


public class pruebaBeans implements Serializable {
private String name = "";
private String password;

public String login() {
	String result = "";
	
	if (name.length() > 0 && password.length() > 0) {
		result = "Welcome";
	}else{	
		result = "prueba";
	} 
	
	return result;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
} 


}
