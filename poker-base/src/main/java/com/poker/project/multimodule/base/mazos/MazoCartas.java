package com.poker.project.multimodule.base.mazos;

import java.util.List;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsInTheDeckException;

public interface MazoCartas {
  /**
   * Extrae una carta sin seleccionar aleatoria del mazo.
   * 
   * @return Carta - carta aleatoria
   */
  public Carta dameCartaAleatoria();

  /**
   * Extrae n cartas sin seleccionar aleatorias del mazo.
   * 
   * @return List<Carta> - cartas aleatorias.
   */
  public List<Carta> dameNCartasAleatorias(int n);

  /**
   * Devuelve una carta concreta.
   * 
   * @return Carta - carta concreta.
   */
  public Carta dameCartaConcreta(Carta cartaConcreta);

  /**
   * Devuelve n cartas concretas.
   * 
   * @return List<Carta> - lista de n cartas concretas.
   */
  public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas);

  /**
   * Inserta una carta en el mazo y la marca como no seleccionada.
   * 
   * @throws CardIsInTheDeckException - cuando la carta está actualmente sin seleccionar en el mazo.
   */
  public void insertarCarta(Carta carta) throws CardIsInTheDeckException;

  /**
   * Inserta varias carta concreta en el mazo.
   */
  public void insertarCartas(List<Carta> cartas);

  /**
   * Comprueba si el mazo está vacío.
   * 
   * @return boolean - true si el mazo está vacío, false en caso contrario.
   */
  public boolean estaVacio();

  /**
   * Comprueba si una carta está seleccionada en el mazo.
   * 
   * @return boolean - true si la carta está actualmente seleccionada,
   * false en caso contrario.
   */
  public boolean perteneceCartaAMazo(Carta carta);
  
  public int getNumCartasNoSeleccionadas();
}
