package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

public interface IGestor<T> {
	void setSession() throws Exception;
	void setTransaction() throws Exception;
	void add(T object) throws Exception;
	void modify(T object) throws Exception;
	void delete(T object) throws Exception;
	T getById(Long id) throws Exception;
	void closeSession() throws Exception;
	ArrayList<Object> getByExample(Object example) throws Exception;
}