package manos;

import java.util.ArrayList;
import com.poker.project.multimodule.base.cartas.Carta;

public abstract class Mano implements Comparable<Mano> {
  protected ArrayList<Carta> cartas;
  protected NombreMano nombreMano;
  
  @Override
  public int compareTo(Mano o) {
    return 0;
  }
}
