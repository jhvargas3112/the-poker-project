package com.poker.project.multimodule.base.cartas;

/**
 * Estructura carta con palo y numero usando enumerado
 * @author victor
 *
 */
public class CartaNumero implements Comparable<CartaNumero>
{
	private Palo palo;
	private NumeroCarta num;

	public CartaNumero(NumeroCarta n , Palo p)
	{
		this.num=n;
		this.palo=p;
	}
	 
	public Palo getPalo() 			{return palo;}
	public void setPalo(Palo palo) 	{this.palo = palo;}
	public NumeroCarta getNum() {return num;}
	public void setNum(NumeroCarta num) {this.num = num;}

	public String toString()
	{
		return  num + " of " +palo.ing();//.name();
	}

	@Override
	public int compareTo(CartaNumero o) 
	{
		int n1=num.valor;
		int n2=o.num.valor;
		if(n1==1)n1 = 15;
		if(n2==1)n2 = 15;
		
		int r= Integer.compare(n1, n2);
		if(r==0)r=0;//tienen el mismo valor
		
		return r;
		
	}
	
	
	public String dameNombre()
	{
		return num.toString();
	}
	
	public String dameLetras()
	{
		return num.letra+ Character.toLowerCase(palo.letr());
	}
	
	
	/**
	 * Suponiendo que juego con una unica baraja;(si no, pone un atributo idBaraja)
	 * POr lo que una carta sera igual a otra  si sus numeros y palos son coinciden
	 */
	public boolean equals(Object o)
	{
		try
		{
			CartaNumero c = (CartaNumero)o;
			return this.num == c.num && this.palo.equals(c.palo);
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
