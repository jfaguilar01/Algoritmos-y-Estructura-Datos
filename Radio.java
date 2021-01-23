
public class Radio implements Interface{
    private boolean Emisora;
    private double[] emisorasFm;
    private int[] emisorasAm;
    private double emisoraFm;
    private int emisoraAm;
    private boolean encendidoApagado;

    /**
     * Constructor 
     */
    public Radio(){
        encendidoApagado=false;
        Emisora = false; // true -> AM
        emisorasFm = new double[12];
        emisorasAm = new int[12];
        for(int i =0 ; i<12; i++){
            emisorasFm[i] = 0.0;
            emisorasAm[i] = 0;
        }
        emisoraFm = 87.9;
        emisoraAm = 530;
    }
    /**
     * Este metodo se encargara mandar en que emisora esta reproduciendoce
     * @param ninguno
     * @return boolean
     */
    public boolean amFm(){
        return Emisora;
    }
    /**
     * Este metodo se encargara de mandar el la frecuencia con la que se esta reproduciendo en la radio 
     * @param ninguno
     * @return void
     */
    public void setEmisora(){
        Emisora = !Emisora;
    }
    /**
     * Este metodo se encargara de alamcenar y presentar el menu para 
     * cuaquiera de las 2 frecuencias de radio 
     * @param btn noton de la radio en las que se guarda las emisoras 
     * @return Striing
     */
    public String guardar(int btn){
        // Si la frecuencia es Am
        if(Emisora){
            emisorasAm[btn] = getEmisoraAm();
        }else{
            emisorasFm[btn] = getEmisoraFm();
        }
        return "Se a guardado con exito";
    }

    /**
     * Este metodo se encargara mandar en qeu emisora se encuentra en la frecuencia fm 
     * @param a tipo double 
     * @return void
     */
    public void setEmisoraFm(double a){
        emisoraFm = a;
    }
    
    public double getEmisoraFm(){ 
        return emisoraFm;
    }
    public void setEmisoraAm(int b){
        emisoraAm = b;
    }
    public int getEmisoraAm(){ 
        return emisoraAm;
    }
    
    /**
     * Este metodo se encargara de seleccionar la emisora que desee el usuario 
     * @param btn boton de las emisoras 
     * @return String
     */
    public String seleccionar(int btn){
        //Emisora == Am
        if(Emisora){
            if(emisorasAm[btn]!=0){
                setEmisoraAm(emisorasAm[btn]);
                return "";
            }
            else
                return "\n\n*********************************\nERROR: NO HAY UNA EMISORA GUARDADA\n*********************************\n\n";
        }
        else{
            if(emisorasFm[btn]!=0.0){
               setEmisoraFm(emisorasFm[btn]);
               return "";
            }
            else
                return "\n\n*********************************\nERROR: NO HAY UNA EMISORA GUARDADA\n*********************************\n\n";

        }
    }

    /**
     * Este metodo se encargara de avanzar por toda la emisora dependiendo de su rango y su frecuencia
     * @param ninguno
     * @return double
     */
    public double avanzar(){
        //Emisora == Am
        if(Emisora){
            if(getEmisoraAm()+10 <= 1610)
                setEmisoraAm(getEmisoraAm()+10);
            else
                setEmisoraAm(530);

            return getEmisoraAm();
        }else{
            if(getEmisoraFm()+0.2 <= 107.9)
                setEmisoraFm(getEmisoraFm()+0.2);
            else
                setEmisoraFm(87.9);
            return getEmisoraFm();
            
        }
    }

    /**
     * Este metodo se encargara de mostrar si esta encendido o apagado la radio
     * @param ninguno
     * @return boolean
     */
    public boolean encenderApagar(){
        return encendidoApagado; 
    }
    public void setEstado(boolean a){
        encendidoApagado=a;
    }

}