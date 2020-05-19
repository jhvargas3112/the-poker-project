package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsInTheDeckException;

public class MazoOptMatriz implements MazoCartas {
  private Carta mazo[][];
  private boolean cartasSeleccionadas[][];
  private int numCartasNoSeleccionadas;

  private static final  int NUM_PALOS = Palo.values().length;
  private static final  int NUM_CARTAS = 13;

  public MazoOptMatriz() {
    mazo = new Carta[NUM_PALOS][NUM_CARTAS];
    cartasSeleccionadas = new boolean[NUM_PALOS][NUM_CARTAS];
    numCartasNoSeleccionadas = NUM_PALOS * NUM_CARTAS;

    for(Palo palo : Palo.values()) {
      for(int i = 0; i < NUM_CARTAS; i++) {
        mazo[palo.ordinal()][i] = new Carta(i + 1, palo);
      }
    }
  }

  /**
   * Extrae una carta sin seleccionar aleatoria del mazo.
   * 
   * Coste en tiempo O(n * m). n es el número de cartas
   * y m es el número de veces que obtiene una carta
   * candidata aleatoria.
   * 
   * @return Carta - carta aleatoria
   */
  @Override
  public Carta dameCartaAleatoria() {
    if (estaVacio()) {
      return null;
    } else {
      Random random = new Random(System.currentTimeMillis());

      int paloOrdinal = random.nextInt(NUM_PALOS);
      int numeroCarta = random.nextInt(NUM_CARTAS);

      Palo palo =  Palo.values()[paloOrdinal];
      Carta carta = new Carta(numeroCarta + 1, palo);

      while (perteneceCartaAMazo(carta)) {
        paloOrdinal = random.nextInt(NUM_PALOS);
        numeroCarta = random.nextInt(NUM_CARTAS);

        palo =  Palo.values()[paloOrdinal];
        carta = new Carta(numeroCarta + 1, palo);
      }

      seleccionarCarta(carta);

      return carta;
    }
  }

  /**
   * Extrae n cartas sin seleccionar aleatorias del mazo.
   * 
   * @return List<Carta> - cartas aleatorias.
   */
  @Override
  public List<Carta> dameNCartasAleatorias(int n) {
    ArrayList<Carta> cartasAleatorias = new  ArrayList<>();

    for (int i = 0; i < n; i++) {
      cartasAleatorias.add(dameCartaAleatoria());
    }

    return cartasAleatorias;
  }

  /**
   * Inserta una carta en el mazo y la marca como no seleccionada.
   * 
   * Coste en tiempo O(1).
   * 
   * @throws CardIsInTheDeckException - cuando la carta está actualmente sin seleccionar en el mazo.
   */
  @Override
  public void insertarCarta(Carta carta) throws CardIsInTheDeckException {
    if (!perteneceCartaAMazo(carta)) {
      throw new CardIsInTheDeckException("This card is already in the deck.");
    }

    int paloOrdinal = carta.getPaloOrdinal();
    int numero = carta.getNum();

    cartasSeleccionadas[paloOrdinal][numero] = false;

    numCartasNoSeleccionadas++;
  }

  /**
   * Inserta varias carta concreta en el mazo.
   * 
   * Coste en tiempo O(n).
   */
  @Override
  public void insertarCartas(List<Carta> cartas) {
    for (Carta carta: cartas)
      try {
        insertarCarta(carta);
      } catch (CardIsInTheDeckException e) {
        e.printStackTrace();
      }
  }

  /**
   * Comprueba si el mazo está vacío.
   * 
   * Coste en tiempo O(1).
   * 
   * @return boolean - true si el mazo está vacío, false en caso contrario.
   */
  @Override
  public boolean estaVacio() {
    return numCartasNoSeleccionadas == 0;
  }

  /**
   * Marca una carta como seleccionada en el mazo.
   * 
   * Coste en tiempo O(1).
   * 
   * @return boolean - true si ha marcado la carta como seleccionada,
   * false si la carta ya estaba seleccionada.
   */
  public boolean seleccionarCarta(Carta carta) {
    if (carta == null) {
      return false;
    }

    if (!perteneceCartaAMazo(carta)) {
      int numero = carta.getNum();
      int paloOrdinal = carta.getPaloOrdinal();

      cartasSeleccionadas[paloOrdinal][numero] = true;
      numCartasNoSeleccionadas--;

      return true;
    } else {
      return false;
    }
  }

  /**
   * Comprueba si una carta está seleccionada en el mazo.
   * 
   * Coste en tiempo O(1).
   * 
   * @return boolean - true si la carta está actualmente seleccionada,
   * false en caso contrario.
   */
  @Override
  public boolean perteneceCartaAMazo(Carta carta) {
    int numero = carta.getNum();
    int paloOrdinal = carta.getPaloOrdinal();

    boolean estaSeleccionada = this.cartasSeleccionadas[paloOrdinal][numero];

    return estaSeleccionada;
  }

  /**
   * Devuelve una carta concreta.
   * 
   * Coste en tiempo O(1).
   * 
   * @return Carta - carta concreta.
   */
  @Override
  public Carta dameCartaConcreta(Carta cartaConcreta) {
    if(cartaConcreta == null) {
      return null;
    }

    if (perteneceCartaAMazo(cartaConcreta)) {
      cartaConcreta = null;
    } else {
      seleccionarCarta(cartaConcreta);
    }

    return cartaConcreta;
  }
  
  /**
   * Devuelve n cartas concretas.
   * 
   * Coste en tiempo O(n).
   * 
   * @return List<Carta> - lista de n cartas concretas.
   */
  @Override
  public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas) {
    List<Carta> cartas= new ArrayList<>();
    
    for (Carta carta : cartasConcretas) {
      Carta cartaConcreta = dameCartaConcreta(carta);
      
      if (cartaConcreta != null) {
        cartas.add(cartaConcreta);
      }
    }
    
    return cartas;
  }

  /**
   * Coste en tiempo O(1).
   */
  @Override
  public int getNumCartasNoSeleccionadas() {
    return numCartasNoSeleccionadas;
  }
}
