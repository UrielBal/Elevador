public class Entrada implements Runnable{
	private Edificio edificio;
	private Elevador elevador;

	public Entrada( Edificio edificio, Elevador elevador ){
		this.edificio = edificio;
		this.elevador = elevador;
		new Thread( this, "Entrada al elevador" ).start();
	}

	public void run(){
		int n = 0;
		this.edificio.ordenarPersonasSalida();
		while( n < this.edificio.getTotalPersonas() ){
			this.elevador.subirPersonaSalida(  this.edificio.getPersona( n ) );
			n++;
		}
	}
}