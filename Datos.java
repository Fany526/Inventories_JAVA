// Programa en Java de la clase "Datos"
// Proyecto Final de Programación Avanzada
// Datos iniciales

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes


public class Datos extends JFrame{
	
	public static String articulosD[] = new String[6];
	public static String coloresD[][] = new String[6][5];
	public static String unidadD[] = new String[6];
	public static int cantidadD[] = new int[6];
	public static String fechaID[] = new String[6];
	public static String fechaRD[] = new String[6];

//Constructor
	public Datos(){
	setLayout(null);
	setTitle("Datos");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	getContentPane().setBackground(new Color(76,228,255));
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
	
for(int z=0;z<=5;z++){
	articulosD[z] = "";
	unidadD[z] = "";
	cantidadD[z] = 0;
	fechaID[z]="";
	fechaRD[z]="Sin fecha";
	for(int a=0;a<=4;a++){
		coloresD[z][a]="";
	}
}
	articulosD[0]="Agua";
	articulosD[1]="Arena";
	articulosD[2]="Lapices";
	articulosD[3]="Pintura";
	coloresD[0][0]="Azul";
	coloresD[1][0]="Amarillo";
	coloresD[1][1]="Blanco";
	coloresD[2][0]="Negro";
	coloresD[2][1]="Amarillo";
	coloresD[3][0]="Rojo";
	coloresD[3][1]="Amarillo";
	coloresD[3][2]="Azul";
	unidadD[0]="Litros";
	unidadD[1]="Bultos";
	unidadD[2]="Paquetes";
	unidadD[3]="Cubetas";
	cantidadD[0]=2000;
	cantidadD[1]=500;
	cantidadD[2]=1000;
	cantidadD[3]=450;
	fechaID[0]="2020-11-10";
	fechaID[1]="2020-10-26";
	fechaID[2]="2020-11-06";
	fechaID[3]="2020-11-18";


	} //Fin del Constructor de la clase Datos

	public static void main(String args[]){
		Inventarios ventanaPrinc = new Inventarios();
		ventanaPrinc.setBounds(500,300,700,700); //x, y, ancho, alto
		ventanaPrinc.setVisible(false);
	} // Fin del método main


} //Fin de la clase Datos
