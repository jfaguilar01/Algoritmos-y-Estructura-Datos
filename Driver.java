
/**
 * @author Javier Aguilar 20611/ Mariana David 201055
 * @version 22/01/2021
 */

import java.util.Scanner;
public class Driver{
    public static void print(String message){
        System.out.println(message);
    }
    /**
     * Este metodo se encargara de alamcenar y presentar el menu para 
     * cuaquiera de las 2 frecuencias de radio 
     * @param ninguno
     * @return void
     */
    public static  void menu(){
        print("1.   Cambiar frecuencia");
        print("2.   Guardar Emisora");
        print("3.   Seleccionar Emisora");
        print("4.   Avanzar");
        print("5.   Enceder/Apagar radio");
        print("\nQue accion desea ejecutar:    ");
    }
    /**
     * Este metodo se encargara de alamcenar y presentar el menu para 
     * cuaquiera de las 2 frecuencias de radio 
     * @param Rad Manda a llamar la clase de radio 
     * @return void
     */
    public static void showRadio(Radio rad){
        if(rad.encenderApagar()){
            for(int i=0; i<74;i++)
                System.out.print("*");
            print("\nFrecuencia : "+((rad.amFm())? "Am":"Fm")); // if amFm == true -> Am  else Fm
            for(int i = 0; i<21;i++)
                System.out.print(" ");
            if(rad.amFm())
                System.out.println("Emisora sonando: "+rad.getEmisoraAm());
            else System.out.println("Emisora sonando: " + String.format("%.2f", rad.getEmisoraFm())); 
            
            for(int i=0; i<74;i++)
                System.out.print("*");
            System.out.print("\n");
        }else{
            for(int i=0; i<74;i++)
                System.out.print("*");
            print("\n");
            for(int i = 0; i<21;i++)
                System.out.print(" ");
            print("APAGADO");
            for(int i=0; i<74;i++)
                System.out.print("*");
            print("\n");
            

        }
            
        
    }
    public static void main(String[] args){
        Radio miRadio = new Radio();
        Scanner scan = new Scanner(System.in);
    
        while(true){
            try{
            showRadio(miRadio);
            menu();
            
            int opcion = Integer.parseInt(scan.nextLine());
            if(miRadio.encenderApagar()){
            if(opcion == 1){
                miRadio.setEmisora();
            }else if(opcion == 2){
                print("\nEn que boton quieres guardar la emisora(1-12):   ");
                int btn = Integer.parseInt(scan.nextLine());
                if(btn>=1 && btn <=12){
                    print(miRadio.guardar(btn-1));
                }else{
                    print("\n*********************************\nERROR: ELIGE UN BOTON VALIDO\n*********************************\n");
                }
            }else if(opcion == 3){
                print("\nQue boton quieres elegir(1-12):   ");
                int btn = Integer.parseInt(scan.nextLine());
                if(btn>=1 && btn <=12){
                    print(miRadio.seleccionar(btn-1));
                }else{
                    print("\n*********************************\nERROR: ELIGE UN BOTON VALIDO\n*********************************\n");
                }

            }else if(opcion == 4){
                miRadio.avanzar();
            }else{
                print("\n*********************************\nERROR: ELIGE UNA OPCION VALIDA\n*********************************\n");

            }
        }else if(!miRadio.encenderApagar() && opcion==5){
            miRadio.setEstado(!miRadio.encenderApagar());
        }
        else{
            print("\n*********************************\nERROR:ESTA FUNCION NECESITA QUE LA RADIO ESTE ENCENDIDA\n*********************************\n");
        }
        }catch(Exception e){
            print("\n*********************************\nERROR:FORMATO DE ENTRADA INVALIDO\n*********************************\n");
            continue;
        }       
        }
    
        
    }
}