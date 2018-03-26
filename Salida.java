/**
 *
 * @author los Armandos
 */
public class Salida implements Runnable{
	private Edificio edificio;
	private Elevador elevador;

	public Salida( Edificio edificio, Elevador elevador ){
		this.elevador = elevador;
		this.edificio = edificio;
		new Thread( this, "Empiezan a salir" ).start();
	}

	public void run(){
		while( true ){
			this.elevador.bajarPersonaSalida();
		}
	}
}