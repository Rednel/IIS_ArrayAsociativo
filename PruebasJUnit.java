package prArrayAsociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PruebasJUnit {
	
	private ArrayAsociativo array;
	
	@After
	public void finalizar(){
		array = null;
		System.gc();
	}
	
	// SIZE
	
	@Test
	public void sizeInicial() {
		array = new ArrayAsociativo();
		assertEquals(new Integer(0),new Integer(array.size()));
	}
	
	@Test
	public void size(){
		array = new ArrayAsociativo(new String[]{"Julia","Gamberro"},new String[]{"Alvaro","MagicElyas"});
		assertEquals(new Integer(2), new Integer(array.size()));
	}
	
	// GET
	
	@Rule
	public ExpectedException excepcion = ExpectedException.none();
	
	@Test
	public void getVacio(){
		excepcion.expect(NoSuchElementException.class);
		ArrayAsociativo array = new ArrayAsociativo();
		assertTrue(array.get("X").equals(""));
	}
	
	@Test
	public void getExisteLaClave(){
		array = new ArrayAsociativo(new String[]{"X"},new String[]{"Y"});
		assertTrue(array.get("X").equals("Y"));
	}
	
	@Test
	public void getNoExisteClave(){
		excepcion.expect(NoSuchElementException.class);
		array = new ArrayAsociativo(new String[]{"X"},new String[]{"Y"});
		assertTrue(array.get("Z").equals(""));
	}
	
	// PUT
	
	@Test
	public void setNuevoPar(){
		array = new ArrayAsociativo();
		array.put("X","Y");
		assertTrue(array.get("X").equals("Y"));
	}

	public void setEnArrayConElem(){
		array = new ArrayAsociativo(new String[]{"Clave"},new String[]{"Valor"});
		array.put("Julia", "Alvaro");
		assertTrue(array.get("Julia").equals("Alvaro"));
	}
	
	public void setYaClaveAlmacenada(){
		String clave = "Julia";
		array = new ArrayAsociativo(new String[]{clave},new String[]{"Alvaro"});
		assertTrue(array.get(clave).equals("Alvaro"));
		array.put(clave,"Nothing");
		assertTrue(array.get(clave).equals("Nothing"));
	}
	
}
