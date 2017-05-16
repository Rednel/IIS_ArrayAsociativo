package prArrayAsociativo;

import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
		
	}
	
	//Variables de instancia
	private Nodo primero;
	private int size;
	
	//Constructores
	public ArrayAsociativo(){
		size = 0;
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
				size++;
			}
			size++;
		}
	}
	
	//Métodos de instancia
	
	public int size(){
		return size;
	}
	
	public String get(String clave){
		while(primero != null){
			if(primero.clave.equals(clave)){
				return primero.valor;
			}
			primero = primero.sig;
		}
		throw new NoSuchElementException("Elemento no encontrado.");
	}
	
	
	public void put(String clave, String valor){
		Nodo iterator = primero;
		while(iterator != null){
			if(iterator.clave.equals(clave)){
				break;
			}
			iterator = iterator.sig;
		}
		if(iterator == null){
			Nodo n = new Nodo(clave,valor,primero);
			primero = n;	
		}else{
			iterator.valor = valor;
		}
	}
	
	
	public String getOrElse(String clave, String valorPorDefecto){
		Nodo iterator = primero;
		while(iterator != null){
			if(iterator.clave.equals(clave)){
				break;
			}
			iterator = iterator.sig;
		}
		if(iterator == null){
			return valorPorDefecto;
		}
		return iterator.valor;
	}
	
	public boolean containsKey(String clave){
		Nodo iterator = primero;
		while(iterator != null){
			if(iterator.clave.equals(clave)){
				return true;
			}
			iterator = iterator.sig;
		}
		return false;
	}
	
	/*
	public boolean remove(String clave){
		
	}*/
	
}
