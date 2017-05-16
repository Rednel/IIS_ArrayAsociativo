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

	@Test
	public void setEnArrayConElem(){
		array = new ArrayAsociativo(new String[]{"Clave"},new String[]{"Valor"});
		array.put("Julia", "Alvaro");
		assertTrue(array.get("Julia").equals("Alvaro"));
	}
	
	@Test
	public void setYaClaveAlmacenada(){
		String clave = "Julia";
		array = new ArrayAsociativo(new String[]{clave},new String[]{"Alvaro"});
		assertTrue(array.get(clave).equals("Alvaro"));
		array.put(clave,"Nothing");
		assertTrue(array.get(clave).equals("Nothing"));
	}
	
	// GETORELSE
	
	@Test
	public void getOrElseArrayVacio(){
		array = new ArrayAsociativo();
		assertTrue(array.getOrElse("X", "ValorDefecto").equals("ValorDefecto"));
	}
	
	@Test
	public void getOrElseArrayClaveExiste(){
		array = new ArrayAsociativo(new String[]{"X","Y"},new String[]{"W","Z"});
		assertTrue(array.getOrElse("X", "W").equals("W"));
	}
	
	@Test
	public void getOrElseArrayClaveNoExiste(){
		array = new ArrayAsociativo(new String[]{"X","Y"},new String[]{"W","Z"});
		assertTrue(array.getOrElse("S", "ValorDefecto").equals("ValorDefecto"));
	}
	
	// CONTAINSKEY
	
	@Test
	public void containsKeyArrayVacio(){
		array = new ArrayAsociativo();
		assertTrue(array.containsKey("X") == false);
	}
	
	@Test
	public void containsKeyArrayNoContiene(){
		array = new ArrayAsociativo(new String[]{"X","Y"},new String[]{"W","Z"});
		assertTrue(array.containsKey("Q") == false);
	}
	
	@Test
	public void containsKeyArrayContiene(){
		array = new ArrayAsociativo(new String[]{"X","Y"},new String[]{"W","Z"});
		assertTrue(array.containsKey("X"));
	}
	
}
