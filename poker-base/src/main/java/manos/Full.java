package manos;

import java.util.ArrayList;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.util.ordenar.comp.ComparadorCartaPorNumero;

public class Full extends Mano {
  private int trio;
  private int pareja;
  
  public Full(ArrayList<Carta> cartas) {
    this.cartas = cartas;
    
    this.cartas.sort(new ComparadorCartaPorNumero());
    
    Carta cartaTrio1 = cartas.get(0);
    
    this.trio = ;
    this.pareja = new Pareja(cartas);
    super.nombreMano = NombreMano.FULL;
  }
  
  @Override
  public int compareTo(Mano mano) {
    this.cartas.sort(new ComparadorCartaPorNumero());
    mano.cartas.sort(new ComparadorCartaPorNumero());
    
    return compareTo();
  }
}
