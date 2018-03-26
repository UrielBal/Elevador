/**
 *
 * @author los Armandos
 */
public class Persona{

	private final int horaSalida;
	private final int horaLlegada;
	private final int piso;
	private final int departamento;

	public Persona( int piso, int departamento ){
		this.horaSalida = ( int ) ( Math.random() * ( 7 )  + 7 ); 
		this.horaLlegada = ( int )( Math.random() * ( 6 )  + 15 );
		this.piso = piso;
		this.departamento = departamento;
	}

	public int getHoraSalida(){
		return this.horaSalida;
	}

	public int getHoraLlegada(){
		return this.horaLlegada;
	}

	public int getPiso(){
		return this.piso;
	}

	public int getDepartamento(){
		return this.departamento;
	}
}