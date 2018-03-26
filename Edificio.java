/**
 *
 * @author los armandos
 */

public class Edificio {

    private  final int PISOS = 6;
    private  final int NUMERO_DEPARTAMENTOS = 4;
    private  int [][] cantidadPersonas = new int[ PISOS ][ NUMERO_DEPARTAMENTOS ];
    private Persona [] personas;
    private int totalPersonas;

    /*
    * Se crea un nuevo edificio asignando aleatoriamente
    * la cantidad de inquilinos por cada departamento.
    */

    public Edificio() {
    	int contador;
    	this.totalPersonas = 0;
    	for( int i = 0; i < PISOS; i++ )
    		for( int j = 0; j < NUMERO_DEPARTAMENTOS; j++ ){
    			contador = (int) ( ( Math.random() * 4 ) + 1);
    			totalPersonas += contador;
    			cantidadPersonas[ i ][ j ] = contador;
    		}
    	this.personas = new Persona[ this.totalPersonas ];
    	this.generarPersonas();

    }

    //Retorna la cantidad de pisos del edificio.
    public int getPisos() {
        return this.PISOS;
    }

    public int getDepartamentos(){
    	return this.NUMERO_DEPARTAMENTOS;
    }

    public int [][] getCantidadPersonas(){
    	return this.cantidadPersonas;
    }

    public int getTotalPersonas(){
    	return this.totalPersonas;
    }


    //Se definen metodos, algunos privados, nos ayudaran a hacer un mejor manejo
    //de los objetos Persona.
    private void generarPersonas(){
    	int contador = 0;
    	for( int i = 0; i < PISOS; i++ )
    		for( int j = 0; j < NUMERO_DEPARTAMENTOS; j++ )
    			for( int k = 0; k < cantidadPersonas[ i ][ j ]; k++ )
    				personas[ contador++ ] = new Persona( i+1, j+1 );
    }

    //Ordenamiento burbuja ;3
    public void ordenarPersonasSalida(){
    	Persona auxiliar;
    	for( int i = 0; i < totalPersonas; i++ )
    		for( int j = 1; j < totalPersonas - i; j ++ ){
    			if( personas[ j - 1].getHoraSalida() > personas[ j ].getHoraSalida()  ){
    				auxiliar = personas[ j - 1 ];
    				personas[ j - 1 ] = personas[ j ];
    				personas[ j ] = auxiliar;
    			}
    		}
    }

    public void ordenarPersonasEntrada(){
    	Persona auxiliar;
    	for( int i = 0; i < totalPersonas; i++ )
    		for( int j = 1; j < totalPersonas - i; j ++ ){
    			if( personas[ j - 1].getHoraLlegada() > personas[ j ].getHoraLlegada()  ){
    				auxiliar = personas[ j - 1 ];
    				personas[ j - 1 ] = personas[ j ];
    				personas[ j ] = auxiliar;
    			}
    		}
    }

    public Persona getPersona( int n ){
    	return this.personas[ n ];
    }
}
