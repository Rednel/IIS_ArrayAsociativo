package prArrayAsociativo;

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
	
	/*public String get(String clave){
		
	}
	
	public void put(String clave, String valor){
		
	}
	
	public String getOrElse(String clave, String valorPorDefecto){
		
	}
	
	boolean containsKey(String clave){
		
	}
	
	boolean remove(String clave){
		
	}*/
	
}
