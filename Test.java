/**
 *
 * @author los Armandos
 */
public class Test{
	public static void main( String [] args ){
		Edificio edificio = new Edificio();
		Elevador elevador = new Elevador();

		Entrada entrada = new Entrada( edificio, elevador );
		Salida salida = new Salida( edificio, elevador );
		System.out.println( "Presionar Ctrl + c para terminar" );
		System.out.println( "Numero total de inquilino: " + edificio.getTotalPersonas() );
	}
}