public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //numero de veces que se le da a imprimir
    private int billetesVend1;
    //elige el tipo de máquina 1=maquina normal 2=maquina con premio
    private int tipoMaquina;
    //veces que imprime la maquina
    private int impresiones = 0;
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. 
     * Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int tipoDeMaquina, int precioDelBillete, 
                    String origen, String destino) {
        tipoMaquina = tipoDeMaquina; 
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente 
     * actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del 
     * cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual 
                                    + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida 
                    + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        
        if (cantidadDeDineroQueFalta <= 0 && impresiones <=2 ) { 
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " 
                                            + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado 
                                            + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual 
                                            - precioBillete;
            if (tipoMaquina == 2){
                System.out.println("Tienes un descuento de " + precioBillete * 10 / 100 + " euros ");
            }
    
            impresiones++;
            billetesVend1 = billetesVend1 + 1;
        }
        else if (cantidadDeDineroQueFalta > 0){
            System.out.println("Necesitas introducir " 
                        + (cantidadDeDineroQueFalta)   
                    + " euros mas!");
                    
        }  
        
        else if (impresiones > 2){
                System.out.println("No queda tinta");
                
            }
    
            
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido 
     * hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public int vaciarDineroDeLaMaquina () {
        int vDDLM1;
        if (balanceClienteActual > 0) {
            System.out.println("La máquina esta realizando una operación, no puede vaciar el dinero");
            vDDLM1 = -1;
        }
        else {
            int vaciadoDinero;
            vaciadoDinero = totalDineroAcumulado + balanceClienteActual;
            balanceClienteActual=0;
            totalDineroAcumulado=0;
            vDDLM1 = vaciadoDinero;
        }
        return vDDLM1; 
    }
    
    public int getNumeroBilletesVendidos() {
        return billetesVend1;
    }
    
    public void imprimeNumeroBilletesVendidos() {
        System.out.println(billetesVend1);
    }
    
}
