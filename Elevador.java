/**
 *
 * @author los Armandos
 */

public class Elevador {
	//El elvador soporta hasta 5 personas.
    private final int CAPACIDAD_MAXIMA = 5;
    private int pisoActual;
    private Persona [] personas; 
    private int numeroPersonas;
    private final String [] ESTADOS = { "ESPERA", "SUBIENDO", "BAJANDO" };
    private String estadoActual;
    
    /*
    * Crea un nuevo elevador en el piso 0 (planta baja)
    * sin ninguna persona a bordo,
    * y esperando una nueva solicitud.
    */
    public Elevador() {
    	this.pisoActual = 0;
    	this.numeroPersonas = 0;
    	this.estadoActual = ESTADOS[ 0 ];
    	this.solicitud = false;
    	this.personas = new Persona[ 5 ]; 
    }

    //Retorna la respuesta
    public int getCapacidadMaxima() {
        return this.CAPACIDAD_MAXIMA;
    }

    public int getNumeroPersonas(){
    	return this.numeroPersonas;
    }

    public int getPisoActual() {
    	return this.pisoActual;
    }

    public String [] getEstados(){
    	return this.ESTADOS;
    }

    public String getEstado(){
    	return this.estadoActual;
    }

    public void setPisoActual( int piso ){
    	this.pisoActual = piso;
    }

    public void setEstadoActual( String estado ){
    	this.estadoActual = estado;
    }

    public void setNumeroPeronas( int n ){
    	this.numeroPersonas = n;
    }


    public boolean verificarEspacio(){
    	return numeroPersonas < CAPACIDAD_MAXIMA;
    }
    /*
    * Este metodo se encarga de subir una nueva persona
    * al elevador.
    */
    public synchronized void subirPersonaSalida( Persona persona ){
   		while( !this.verificarEspacio() ){
   			try{
   				wait();
   			}catch( InterruptedException ie ){
   				System.out.println( "Ocurrio un error durante el metodo \"subirPersona.\" " );
   			}
   		}
   		this.personas[ this.numeroPersonas++ ] = persona;
   		this.estadoActual = ( this.pisoActual < persona.getPiso() )? ESTADOS[ 1 ] : ESTADOS[ 2 ];
   		this.pisoActual = persona.getPiso();
   		System.out.println( "Subio una persona en el piso " + persona.getPiso() + " departamento " + persona.getDepartamento() + " a las " + persona.getHoraSalida() + " hrs" );
   		this.notify();
    }

    /*
    * Este metodo se encarga de bajar a la persona
    * en el piso que haya elegido.
    */
    public synchronized void bajarPersonaSalida(){
    	while( this.numeroPersonas == 0  ){
    		try{
    			wait();
    		}catch( InterruptedException ie ){
    			System.out.println( "Ocurrio un error durante el metodo \"bajarPersona.\" " );	
    		}
    	}
    	this.numeroPersonas = 0;
    	this.pisoActual = 0;
    	this.estadoActual = ESTADOS[ 0 ];
    	System.out.println( "Bajaron todas las personas" );
    	this.notify();
    }
}
