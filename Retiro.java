// Programa en Java de la clase "Retiro"
// Proyecto Final de Programación Avanzada
/* Ventana Retirar mercancía de algún articulo disponible
  En esta ventana se podrá retirar mercancía de un artículo*/

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes

public class Retiro extends JFrame implements ActionListener, ItemListener, MouseListener, FocusListener, KeyListener{
	final int poscx = 800;
	final int poscy = 250;
	private JMenuBar menubar;
	private JMenu menuOpcs, menuApariencia;
	private JMenuItem menuiPrincipal, menuiBlanco, menuiNegro, menuiOriginal;
	private JLabel etiqArticulo, etiqCant, etiqFechaR, etiqueta;
	private JLabel etiqInstruc, etiqInstruc1, etiqInstruc2;
	private JTextField campoCant, campoFechaR;
	private JComboBox <String> comboArticulos;
	private JButton botonRetirar;
	
	public int colorVentana, foco = 0, existencia, cantidadIni;
	public String retiro, cad = "",cantidad="",resArtic="",cadf ="",fech,resguardo = "";
	public boolean canti = false, fechr = false;
	public static String articulosR[] = new String[6];
	public static int cantidadR[] = new int[6];
	public static String fechaRR[] = new String[6];

	public static int exist[] = new int[6];
	public static String fechaRetN[] = new String[6];
	
public void Color(){
	if(colorVentana==0){
		getContentPane().setBackground(new Color(76,228,255));
		etiqArticulo.setForeground(Color.BLACK);  
		etiqCant.setForeground(Color.BLACK); 
		etiqFechaR.setForeground(Color.BLACK);
		etiqInstruc.setForeground(Color.BLACK); 
		etiqInstruc1.setForeground(Color.BLACK); 
		etiqInstruc2.setForeground(Color.BLACK);   
	}
	if(colorVentana==1){
		getContentPane().setBackground(Color.WHITE);
		etiqArticulo.setForeground(Color.BLACK); 
		etiqCant.setForeground(Color.BLACK); 
		etiqFechaR.setForeground(Color.BLACK); 
		etiqInstruc.setForeground(Color.BLACK); 
		etiqInstruc1.setForeground(Color.BLACK); 
		etiqInstruc2.setForeground(Color.BLACK); 
	}
	if(colorVentana==2){
		getContentPane().setBackground(Color.BLACK);
		etiqArticulo.setForeground(Color.WHITE);
		etiqCant.setForeground(Color.WHITE);
		etiqFechaR.setForeground(Color.WHITE);
		etiqInstruc.setForeground(Color.WHITE);
		etiqInstruc1.setForeground(Color.WHITE);
		etiqInstruc2.setForeground(Color.WHITE); 
	}
}

//Constructor
	public Retiro(){
	setLayout(null);
	setTitle("Retiro de mercancias");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
	
Inventarios ventanaR = new Inventarios();
	for(int z=0;z<=5;z++){
		articulosR[z] = ventanaR.articuloss[z];
		cantidadR[z] = ventanaR.cantidads[z];
		fechaRR[z] = ventanaR.fechaRs[z];
	
		if(articulosR[z]==null){
			Datos ventanaD1 = new Datos();
			articulosR[z] = ventanaD1.articulosD[z];
			cantidadR[z] = ventanaD1.cantidadD[z];
			fechaRR[z] = ventanaD1.fechaRD[z];
		}//Fin del if null

		if(exist[z]!=0){
			cantidadR[z] = exist[z];
		}
	}//Fin del for "z"

//Etiquetas
	etiqArticulo = new JLabel("Articulo");
	etiqArticulo.setBounds(40,80,150,35); //x, y, ancho, alto
	etiqArticulo.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqArticulo);

	etiqCant = new JLabel("Cantidad a retirar");
	etiqCant.setBounds(40,190,250,35); //x, y, ancho, alto
	etiqCant.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqCant);

	etiqFechaR = new JLabel("Fecha de retiro");
	etiqFechaR.setBounds(40,300,220,35); //x, y, ancho, alto
	etiqFechaR.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqFechaR);

	etiqueta = new JLabel("");
	etiqueta.setBounds(410,440,220,35); //x, y, ancho, alto
	etiqueta.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqueta);

	etiqInstruc = new JLabel("Instrucciones");
	etiqInstruc.setBounds(40,400,250,35); //x, y, ancho, alto
	etiqInstruc.setFont(new Font("arial",Font.ITALIC,25)); 
	add(etiqInstruc);

	etiqInstruc1 = new JLabel("Click en la rueda del raton");
	etiqInstruc1.setBounds(40,440,350,35); //x, y, ancho, alto
	etiqInstruc1.setFont(new Font("arial",Font.PLAIN,25)); 
	add(etiqInstruc1);
	
	etiqInstruc2 = new JLabel("o en el boton para retirar");
	etiqInstruc2.setBounds(40,480,350,35); //x, y, ancho, alto
	etiqInstruc2.setFont(new Font("arial",Font.PLAIN,25)); 
	add(etiqInstruc2);

	Inventarios ventanaAnterior = new Inventarios();
	colorVentana = ventanaAnterior.color;
	Color();

//Text Field
	campoCant = new JTextField();
	campoCant.setBounds(320,190,330,35);
	campoCant.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoCant);

	campoFechaR = new JTextField();
	campoFechaR.setBounds(320,300,330,35);
	campoFechaR.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoFechaR);

//Combo Box
	comboArticulos = new JComboBox<String>();
	comboArticulos.setBounds(320,90,330,35);
	comboArticulos.setFont(new Font("arial",Font.PLAIN,21));
	comboArticulos.setEditable(true); 
	comboArticulos.setSelectedItem(" Elige un articulo");
	add(comboArticulos);

	comboArticulos.addItem(" Elige un articulo");
	for(int i=0;i<=5;i++){
		if(!articulosR[i].equals("")){
			comboArticulos.addItem(articulosR[i]);
		}
	}
	comboArticulos.addItemListener(this);

//Menú Bar
	menubar = new JMenuBar();
	setJMenuBar(menubar);

//Menús y Submenús
	menuOpcs = new JMenu("Opciones");
	menuOpcs.setFont(new Font("arial",Font.BOLD,17)); 
	menuApariencia = new JMenu("Color ventana");
	menuApariencia.setFont(new Font("arial",Font.BOLD,14)); 
	
	menubar.add(menuOpcs);
	
//Item de los menús
	menuiPrincipal = new JMenuItem("Ventana principal");
	menuiPrincipal.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiBlanco = new JMenuItem("Diurno");
	menuiBlanco.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiNegro = new JMenuItem("Nocturno");
	menuiNegro.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiOriginal = new JMenuItem("Original");
	menuiOriginal.setFont(new Font("arial",Font.PLAIN,14));

	menuOpcs.add(menuiPrincipal);
	menuOpcs.add(menuApariencia);
	menuApariencia.add(menuiBlanco);
	menuApariencia.add(menuiNegro);
	menuApariencia.add(menuiOriginal);

	menuiPrincipal.addActionListener(this);
	menuiBlanco.addActionListener(this);
	menuiNegro.addActionListener(this);
	menuiOriginal.addActionListener(this);

//Botones
	botonRetirar = new JButton("Retirar");
	botonRetirar.setBounds(410,540,150,45);
	botonRetirar.setForeground(Color.WHITE);
	botonRetirar.setBackground(new Color(255,56,56));
	botonRetirar.setFont(new Font("arial",Font.BOLD,21)); 
	add(botonRetirar);
	
	addMouseListener(this);
	botonRetirar.addActionListener(this);

	campoCant.addFocusListener(this);
	campoFechaR.addFocusListener(this);
	setFocusable(true);
	campoCant.addKeyListener(this);
	campoFechaR.addKeyListener(this);
	} //Fin del Constructor de la clase Retiro

	public void actionPerformed(ActionEvent accion5){
		if(accion5.getSource() == menuiPrincipal){
			Inventarios ventana = new Inventarios();
			ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana.setVisible(true);
			ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion5.getSource() == menuiBlanco){
			colorVentana=1;
			Color();
		} //Fin del if
		if(accion5.getSource() == menuiNegro){
			colorVentana=2;
			Color();
		} //Fin del if
		if(accion5.getSource() == menuiOriginal){
			colorVentana=0;
			Color();
		} //Fin del if
		if(accion5.getSource() == botonRetirar){
			try{
			int opcion;
			opcion = JOptionPane.showConfirmDialog(etiqueta,"Seguro de querer retirar esa mercancia?");
			if(opcion==0){
				if(!campoCant.getText().equals("")&&!campoFechaR.getText().equals("")&&!resArtic.equals("")){
					retiro = campoCant.getText();
					int cantRetiro = Integer.valueOf(retiro);
					for(int z=0;z<=5;z++){
						exist[z] = cantidadR[z];
						if(resArtic.equals(articulosR[z])){
							fechaRetN[z]=campoFechaR.getText();
							cantidadIni = cantidadR[z];
							if(cantidadIni>=cantRetiro){
								existencia = cantidadIni - cantRetiro;
								exist[z] = existencia;
								Inventarios ventana = new Inventarios();
								ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
								ventana.setVisible(true);
								ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
								dispose();
							}else{
								JOptionPane.showMessageDialog(etiqueta,"Error, no se tiene esa cantidad de articulos");
							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(etiqueta,"Falta llenar algun campo");
				}
			}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(etiqueta,"La cantidad es demasiado grande, prueba con menor a diez mil millones (10 ceros)");
				campoCant.requestFocusInWindow();
			}
		} //Fin del if
	}//Fin del método actionPerformed
	
	public void itemStateChanged(ItemEvent accion5){
		//resArtic="";
		String selecArtic = comboArticulos.getSelectedItem().toString();
		
		if(!selecArtic.equals(" Elige un articulo")){
			resArtic = selecArtic;
		}else{
			JOptionPane.showMessageDialog(etiqueta,"Falta seleccionar un articulo");
		}
	}//Fin del método stateChanged

	public void mouseEntered(MouseEvent accion){

	}//Fin del "mouseEntered"

	public void mouseExited(MouseEvent accion){

	}//Fin del "mouseExited"
	
	public void mousePressed(MouseEvent accion){
		int valorBoton = accion.getModifiersEx();

		if(valorBoton == 2048){
			try{
			int opcion;
			opcion = JOptionPane.showConfirmDialog(etiqueta,"Seguro de querer retirar esa mercancia?");
			if(opcion==0){
				if(!campoCant.getText().equals("")&&!campoFechaR.getText().equals("")&&!resArtic.equals("")){
					retiro = campoCant.getText();
					int cantRetiro = Integer.valueOf(retiro);
					for(int z=0;z<=5;z++){
						exist[z] = cantidadR[z];
						if(resArtic.equals(articulosR[z])){
							fechaRetN[z]=campoFechaR.getText();
							cantidadIni = cantidadR[z];
							if(cantidadIni>=cantRetiro){
								existencia = cantidadIni - cantRetiro;
								exist[z] = existencia;
								Inventarios ventana = new Inventarios();
								ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
								ventana.setVisible(true);
								ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
								dispose();
							}else{
								JOptionPane.showMessageDialog(etiqueta,"Error, no se tiene esa cantidad de articulos");
							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(etiqueta,"Falta llenar algun campo");
				}
			}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(etiqueta,"La cantidad es demasiado grande, prueba con menor a diez mil millones (10 ceros)");
				campoCant.requestFocusInWindow();
			}
		}
	}//Fin del "mousePressed"

	public void mouseReleased(MouseEvent accion){

	}//Fin del "mouseReleased"

	public void mouseClicked(MouseEvent accion){

	}////Fin del "mouseClicked"

	public void focusGained(FocusEvent f){
		String cadenaC = campoCant.getText();
		String cadenaFR = campoFechaR.getText();
		if(campoCant.isFocusOwner()&&foco==0&&cadenaC.equals("")){
			canti = true;
			foco=1;
		}
		if(campoFechaR.isFocusOwner()&&foco==0&&cadenaFR.equals("")){
			fechr = true;
			foco=2;
		}

	}//Fin del "focusGained"

	public void focusLost(FocusEvent f){
		String cadenaC = campoCant.getText();
		String cadenaFR = campoFechaR.getText();
	
		while(cadenaC.equals("")&&canti==true&&foco==1){
			canti = false;
			JOptionPane.showMessageDialog(etiqueta,"Olvidaste ingresar una cantidad");
			campoCant.requestFocusInWindow();
			foco=0;
			break;	
		}

		while(cadenaFR.equals("")&&fechr==true&&foco==2){
			fechr = false;
			JOptionPane.showMessageDialog(etiqueta,"Olvidaste ingresar una fecha");
			campoFechaR.requestFocusInWindow();
			foco=0;	
			break;	
		}
		
	
	}//Fin del "focusLost"

	public void keyPressed(KeyEvent t){

	}//Fin del "keyPressed"

	public void keyReleased(KeyEvent t){
		if(campoCant.isFocusOwner()){
			String cadena = campoCant.getText();// En esta variable se guarda el texto a validar
  			int longCadena = cadena.length(); //Regresa la longitud de la cadena
		   
			for (int x=0; x<longCadena; x++){
         			char caracter = cadena.charAt(x);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=48&&caracterCode<=57){
					resguardo = cad;
       					cad = cad + caracter;
	 			}else{
					JOptionPane.showMessageDialog(etiqueta,"La cantidad solo debe ser escrita en numeros enteros");
					campoCant.setText(cad);
				}
		
				try{
				int cnt = Integer.valueOf(cad);
				if(cnt>100000){
					JOptionPane.showMessageDialog(this,"Solo se puede retirar una cantidad menor o igual a 100000 (cien mil)");
					campoCant.setText(resguardo);
					campoFechaR.requestFocusInWindow();	
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
					retiro = campoCant.getText();
					campoFechaR.requestFocusInWindow();
					break;
  				}
				} catch(NumberFormatException e){
					campoCant.setText(resguardo);
					resguardo = "";
				}
			}
			cantidad = cad;
			cad = "";
			resguardo = "";
		}	
		
		if(campoFechaR.isFocusOwner()){
			String cadenaF = campoFechaR.getText();// En esta variable se guarda el texto a validar
			int longCadena = cadenaF.length(); //Regresa la longitud de la cadena
		   
			for (int x=0; x<longCadena; x++){
         			char caracter = cadenaF.charAt(x);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=48&&caracterCode<=57||caracterCode==45){
       					cadf = cadf + caracter;
	 			}else{
					JOptionPane.showMessageDialog(etiqueta,"El formato de fecha es: aaaa-mm-dd");
					campoFechaR.setText(cadf);
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
              				fech = cadf;
					if(campoCant.getText().equals("")){
						campoFechaR.requestFocusInWindow();
					}
					else if(campoCant.getText().equals("")){
						campoCant.requestFocusInWindow();
					}	
					else{
						JOptionPane.showMessageDialog(etiqueta,"De click en el boton retirar o en la rueda del mouse");
					}
  				} 
			}
			fech = cadf;
			cadf = "";
		}
		
	}//Fin del "keyReleased"
	
	public void keyTyped(KeyEvent t){	

	}//Fin del "keyTyped"


} //Fin de la clase Retiro
