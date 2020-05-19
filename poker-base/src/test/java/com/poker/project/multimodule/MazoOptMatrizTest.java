package com.poker.project.multimodule;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import com.poker.project.multimodule.base.mazos.MazoCartas;
import com.poker.project.multimodule.base.mazos.MazoOptMatriz;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsInTheDeckException;

public class MazoOptMatrizTest {
  private MazoCartas mazo;

  private static final int NUM_PALOS = Palo.values().length;
  private static final int NUM_CARTAS = 13;

  private ArrayList<Carta> cartas;

  @Before
  public void setUp() {
    mazo = new MazoOptMatriz();

    cartas = new ArrayList<>();

    cartas.add(new Carta(7, Palo.CORAZONES));
    cartas.add(new Carta(3, Palo.PICAS));
    cartas.add(new Carta(5, Palo.DIAMANTES));
    cartas.add(new Carta(8, Palo.TREBOLES));
  }

  @Test
  public void dameCartaAleatoria() {
    Carta carta = mazo.dameCartaAleatoria();

    Assert.assertNotNull(carta);
  }

  @Test
  public void dameNCartaAleatoria() {
    int n = 2;

    List<Carta> cartas = mazo.dameNCartasAleatorias(n);

    Assert.assertNotNull(cartas);

    Assert.assertTrue(!cartas.isEmpty());
  }

  @Test
  public void obtenerTodasCartasMazoAleatorio() {
    mazo.dameNCartasAleatorias(NUM_PALOS * NUM_CARTAS);

    Assert.assertTrue(mazo.estaVacio());
  }

  @Test
  public void testDameCartaConcreta() {
    Carta cartaConcreta = new Carta(2,Palo.CORAZONES);
    Carta carta = mazo.dameCartaConcreta(cartaConcreta);

    Assert.assertNotNull(carta);

    Assert.assertTrue(carta.compareTo(cartaConcreta) == 0);
  }

  @Test
  public void DameNCartasConcretas() {
    Carta cartaConcreta1 = new Carta(1, Palo.CORAZONES);
    Carta cartaConcreta2 = new Carta(2, Palo.CORAZONES);

    ArrayList<Carta> cartasConcretas = new ArrayList<>();

    cartasConcretas.add(cartaConcreta1);
    cartasConcretas.add(cartaConcreta2);

    List<Carta> cartas = mazo.dameNCartasConcretas(cartasConcretas);

    Assert.assertNotNull(cartas);
    Assert.assertTrue(!cartas.isEmpty());
    Assert.assertTrue(cartas.size() == cartasConcretas.size());

    for (int i = 0; i < cartas.size(); i++) {
      Carta carta = cartas.get(i);
      Carta cartaConcreta = cartasConcretas.get(i);

      Assert.assertTrue(carta.compareTo(cartaConcreta) == 0);
    }
  }

  @Test
  public void seleccionarCarta() {
    Carta carta = new Carta(7, Palo.CORAZONES);

    int numCartasNoSeleccionadas = mazo.getNumCartasNoSeleccionadas();

    boolean seleccionada = ((MazoOptMatriz) mazo).seleccionarCarta(carta);

    Assert.assertTrue(seleccionada);
    Assert.assertEquals(mazo.getNumCartasNoSeleccionadas(), numCartasNoSeleccionadas - 1);
  }
  
  public void seleccionarCartaMazoVacio() {
    mazo.dameNCartasAleatorias(NUM_PALOS * NUM_CARTAS);

    boolean seleccionada = ((MazoOptMatriz) mazo).seleccionarCarta(new Carta(7, Palo.CORAZONES));
  
    Assert.assertFalse(seleccionada);
  }

  @Test
  public void noPerteneceCartaAMazo() {
    Carta carta = new Carta(7, Palo.CORAZONES);

    ((MazoOptMatriz) mazo).seleccionarCarta(carta);

    Assert.assertFalse(!mazo.perteneceCartaAMazo(carta));
  }

  @Test
  public void perteneceCartaAMazo() {
    Carta carta = new Carta(7, Palo.CORAZONES);

    Assert.assertTrue(!mazo.perteneceCartaAMazo(carta));
  }

  @Test
  public void insertarCarta() throws CardIsInTheDeckException {
    mazo.dameNCartasConcretas(cartas);

    int numCartasSinSeleccionar = mazo.getNumCartasNoSeleccionadas();

    Carta carta = new Carta(7, Palo.CORAZONES);

    Assert.assertTrue(mazo.perteneceCartaAMazo(carta));

    mazo.insertarCarta(carta);

    Assert.assertEquals(numCartasSinSeleccionar + 1, mazo.getNumCartasNoSeleccionadas());
  }

  @Test
  public void insertarNCartas() throws CardIsInTheDeckException {
    mazo.dameNCartasConcretas(cartas);

    int numCartasSinSeleccionar = mazo.getNumCartasNoSeleccionadas();

    mazo.insertarCartas(cartas);

    int n = cartas.size();

    Assert.assertEquals(numCartasSinSeleccionar + n, mazo.getNumCartasNoSeleccionadas());
  }

  @Test(expected = CardIsInTheDeckException.class)
  public void insertarCartaRepetida() throws CardIsInTheDeckException {
    Carta carta = new Carta(7, Palo.CORAZONES);

    mazo.insertarCarta(carta);
  }
}
