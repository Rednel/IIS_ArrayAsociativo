package prArrayAsociativo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasJUnit {

	@Test
	public void sizeInicial() {
		assertEquals(new Integer(0),new Integer(new ArrayAsociativo().size()));
	}
	
	@Test
	public void size(){
		ArrayAsociativo array = new ArrayAsociativo(new String[]{"Julia","Gamberro"},new String[]{"Alvaro","MagicElyas"});
		assertEquals(new Integer(2), new Integer(array.size()));
	}

}
