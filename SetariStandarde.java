package com.app.setariStandarde;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.app.oracle.OracleUI;
import com.app.oracle.login;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;


public class SetariStandarde extends Panel{
	private static final long serialVersionUID = -1331676075054201812L;

	private MsSql sql = new MsSql();
	private String logName;

	public SetariStandarde(final String user) {

		logName=user;
		final Label titlu = new Label("<center><h2>Setari standarde</h2></center>",ContentMode.HTML);
		final VerticalLayout main = new VerticalLayout();
		main.setSpacing(true);
		main.setImmediate(true);
		main.setMargin(true);
		main.addComponent(titlu);
		setSizeFull();
		setContent(main);

		//======================================Configurare elemente din BD========================================================================
		sql.startConnection();
		final ArrayList<String> produse_CRUD = sql.getProduse_CRUD();
		final ArrayList<String> produse_Biscuit = sql.getProduse_Biscuit();
		ArrayList<String> lista_echipament=sql.getEchipamentDigital();
		ArrayList<String> lista_buncare=sql.getFunctie();
		ArrayList<String> lista_prese=sql.getAbateri();

		sql.close_connection();

		//======================================Creare elemente interfata (butoane, labels, text-fields......)=====================================

		final ComboBox departament = new ComboBox("Departament");
		final ComboBox tabel = new ComboBox("Tabel");
		final ComboBox produs = new ComboBox("Produs");
		final ComboBox produs2 = new ComboBox("Produs pentru copiere");
		produs2.setImmediate(true);
		final ComboBox hartieseparator = new ComboBox("Hartie / Separator Stea");
		hartieseparator.setImmediate(true);
		final ComboBox cmbEchipament = new ComboBox();
		final ComboBox cmbPosibil = new ComboBox();
		final ComboBox cmbPresa = new ComboBox();
		final ComboBox cmbBuncar = new ComboBox();
		

		final TextField H2_BUC_PE_RAND = new TextField("H2 BUC PE RAND");
		final TextField H2_NR_RANDURI_NIVEL_BT = new TextField("H2 NR RANDURI NIVEL BT");
		final TextField H4_BUC_PE_RAND = new TextField("H4 BUC PE RAND");
		final TextField H4_NR_RANDURI_NIVEL_BT = new TextField("H4 NR RANDURI NIVEL BT");
		final TextField H6_BUC_PE_RAND = new TextField("H6 BUC PE RAND");
		final TextField H6_NR_RANDURI_NIVEL_BT = new TextField("H6 NR RANDURI NIVEL BT");
		final TextField H2_BUC_PE_RANDCopie = new TextField("H2 BUC PE RAND2");
		final TextField H2_NR_RANDURI_NIVEL_BTCopie = new TextField("H2 NR RANDURI NIVEL BT2");
		final TextField H4_BUC_PE_RANDCopie = new TextField("H4 BUC PE RAND2");
		final TextField H4_NR_RANDURI_NIVEL_BTCopie = new TextField("H4 NR RANDURI NIVEL BT2");
		final TextField H6_BUC_PE_RANDCopie = new TextField("H6 BUC PE RAND2");
		final TextField H6_NR_RANDURI_NIVEL_BTCopie = new TextField("H6 NR RANDURI NIVEL BT2");
		H2_BUC_PE_RANDCopie.setEnabled(false);
		H2_NR_RANDURI_NIVEL_BTCopie.setEnabled(false);
		H4_BUC_PE_RANDCopie.setEnabled(false);
		H4_NR_RANDURI_NIVEL_BTCopie.setEnabled(false);
		H6_BUC_PE_RANDCopie.setEnabled(false);
		H6_NR_RANDURI_NIVEL_BTCopie.setEnabled(false);
		

		final TextField VALUE_RASTEL = new TextField("VALOARE RASTEL");
		final TextField NR_STIVE_PE_PLACA = new TextField("NR STIVE PE PLACA");
		final TextField NR_BUC_IN_STIVA = new TextField("NR BUC IN STIVA");
		final TextField TOTAL_PE_NIVEL_CU_PLACA = new TextField("TOTAL PE NIVEL CU PLACA");
		final TextField VALUE_RASTELCopie = new TextField("VALOARE RASTEL");
		final TextField NR_STIVE_PE_PLACACopie = new TextField("NR STIVE PE PLACA");
		final TextField NR_BUC_IN_STIVACopie = new TextField("NR BUC IN STIVA");
		final TextField TOTAL_PE_NIVEL_CU_PLACACopie = new TextField("TOTAL PE NIVEL CU PLACA");
		VALUE_RASTELCopie.setEnabled(false);
		NR_STIVE_PE_PLACACopie.setEnabled(false);
		NR_BUC_IN_STIVACopie.setEnabled(false);
		TOTAL_PE_NIVEL_CU_PLACACopie.setEnabled(false);

		final TextField VALUE_RASTEL2  = new TextField("Cantitate pe nivel de rastel");
		final TextField VALUE_PALET  = new TextField("Cantitate totala pe palet");
		final TextField BUC_STOLT_RASTEL  = new TextField("Cantitate stolt pe rastel");
		final TextField BUC_STOLT  = new TextField("Cantitate stolt pe palet");
		final TextField VALUE_RASTEL2Copie  = new TextField("Cantitate pe nivel de rastel");
		final TextField VALUE_PALETCopie  = new TextField("Cantitate totala pe palet");
		final TextField BUC_STOLT_RASTELCopie  = new TextField("Cantitate stolt pe rastel");
		final TextField BUC_STOLTCopie  = new TextField("Cantitate stolt pe palet");
		VALUE_RASTEL2Copie.setEnabled(false);
		VALUE_PALETCopie.setEnabled(false);
		BUC_STOLT_RASTELCopie.setEnabled(false);
		BUC_STOLTCopie.setEnabled(false);
	
		
		final TextField SEPARATOR = new TextField("Ø");
		final TextField SEPARATORCopie = new TextField("Ø");
		SEPARATORCopie.setEnabled(false);
		
		final TextField SUFLATOARE = new TextField("SUFLATOARE");
		final TextField RECEPTORI = new TextField("RECEPTORI");
		final TextField VENTUZA_R1  = new TextField("VENTUZA R1 ");
		final TextField VENTUZAR_R2   = new TextField("VENTUZA R2");
		
		

		final Label EchipamentSetat = new Label();
		final String c_bpartner_id = logName.split("_")[2];

		final Component spacing = new VerticalLayout();
		spacing.setHeight("20px");

		final Button save = new Button("Salveaza");
		final Button disconnect = new Button("Deconectare");
		final Button copiaza = new Button("Copiaza");

		final HorizontalLayout buttons = new HorizontalLayout();
		final GridLayout gridLayout = new GridLayout(3, 9); // Create a 2x8 grid layout
	    gridLayout.setWidth("50%"); // Set the width of the grid layout
	    gridLayout.setSpacing(true); // Enable spacing between components

		//=========================================Configurare/Initializare elemente interfata=====================================================


		hartieseparator.addItem("HARTIE");
		hartieseparator.addItem("SEPARATOR STEA");

		departament.addItem("FASONARE");
		departament.addItem("ARDERE 1 - DESCARCARE");
		departament.addItem("ARDERE 2 - DESCARCARE");
		departament.addItem("GLAZURARE");
		departament.setImmediate(true);

		tabel.setImmediate(true);

		produs.setFilteringMode(FilteringMode.CONTAINS);
		produs.setImmediate(true);


		buttons.setSpacing(true);


		cmbEchipament.setCaption("Selecteaza Echipamentul");
		for(String item: lista_echipament){
			cmbEchipament.addItem(item);
		}
		cmbEchipament.setImmediate(true);


		cmbPosibil.setCaption("Echipamente Disponibile");
		cmbPosibil.setImmediate(true);

		cmbPresa.setCaption("Selecteaza Presa");
		for(String item: lista_prese){
			cmbPresa.addItem(item);
		}

		cmbPresa.setImmediate(true);

		cmbBuncar.setCaption("Selecteaza Buncar");
		for(String item : lista_buncare){
			cmbBuncar.addItem(item);
		}

		cmbBuncar.setImmediate(true);
		//=============================================Adaugare elemente in interfata==============================================================

		buttons.addComponents(spacing,save,disconnect);

		main.addComponents(departament,spacing,buttons);

		//===========================================Actiuni elemente interfata (actionLIstener,changeListener,clickListener....)==================


		cmbPresa.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = -2382794646458901005L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(!(cmbPresa.getValue()+"").equals("null")){
					sql.startConnection();
					String lista_ab=sql.getAbatereLinie(cmbPresa.getValue()+"");
					sql.close_connection();
					cmbBuncar.setValue(lista_ab);
				}
			}
		});

		cmbEchipament.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = -2382794646458901005L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				String echipamentactual=(String) cmbEchipament.getValue();
				sql.startConnection();

				EchipamentSetat.setValue("Echipament Setat : "+sql.getEchipamentActual(echipamentactual));
				EchipamentSetat.setWidth("200px");
				String lista_echipamente_disponibile = "";
				cmbPosibil.removeAllItems();
				lista_echipamente_disponibile=sql.getEchipamentSetatDigital(echipamentactual);
				List<String> lista = new ArrayList<String>(Arrays.asList(lista_echipamente_disponibile.split(";")));
				for(String item : lista){
					if (!item.equals(sql.getEchipamentActual(echipamentactual))) cmbPosibil.addItem(item);
				}


				sql.close_connection();
			}
		});


		departament.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = -3817056312993558999L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tabel.removeAllItems();

				if((departament.getValue()+"").equals("FASONARE")) {
					main.removeAllComponents();
					main.addComponents(titlu,departament,tabel,produs,spacing,buttons);
					tabel.addItem("STANDARD INCARCARE PE BT");
					tabel.addItem("MODIFICARE BUNCAR PRESA");
				}

				if((departament.getValue()+"").equals("ARDERE 1 - DESCARCARE")) {
					main.removeAllComponents();
					main.addComponents(titlu,departament,tabel,produs,spacing,buttons);
					tabel.addItem("STANDARD DESCARCARE PRODUSE BISCUITATE");

				}

				if((departament.getValue()+"").equals("ARDERE 2 - DESCARCARE")) {
					main.removeAllComponents();
					main.addComponents(titlu,departament,tabel,produs,spacing,buttons);
					tabel.addItem("STANDARD DESCARCARE PRODUSE ARSE");

				}

				if((departament.getValue()+"").equals("GLAZURARE")) {
					main.removeAllComponents();
					main.addComponents(titlu,departament,tabel,spacing,buttons);
					tabel.addItem("SETARE DIGITAL PRINTING");
					tabel.addItem("SETARE SUFLATORI, RECEPTORI SI VENTUZE");

				}
			}

		});

		tabel.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = -3808246903772288220L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				produs.removeAllItems();

				if ((tabel.getValue() + "").equals("STANDARD INCARCARE PE BT")) {
					
				    main.removeAllComponents();
				    gridLayout.removeAllComponents();
				    
				    main.addComponents(titlu,departament,tabel);


				    // Add labels and TextFields to the grid layout
				    gridLayout.addComponent(produs, 0, 0);
				    gridLayout.addComponent(produs2, 1, 0);
				    gridLayout.addComponent(H2_BUC_PE_RAND, 0, 1);
				    gridLayout.addComponent(H2_BUC_PE_RANDCopie, 1, 1);
				    gridLayout.addComponent(H2_NR_RANDURI_NIVEL_BT, 0, 2);
				    gridLayout.addComponent(H2_NR_RANDURI_NIVEL_BTCopie, 1, 2);
				    gridLayout.addComponent(H4_BUC_PE_RAND, 0, 3);
				    gridLayout.addComponent(H4_BUC_PE_RANDCopie, 1, 3);
				    gridLayout.addComponent(H4_NR_RANDURI_NIVEL_BT, 0, 4);
				    gridLayout.addComponent(H4_NR_RANDURI_NIVEL_BTCopie, 1, 4);
				    gridLayout.addComponent(H6_BUC_PE_RAND, 0, 5);
				    gridLayout.addComponent(H6_BUC_PE_RANDCopie, 1, 5);
				    gridLayout.addComponent(H6_NR_RANDURI_NIVEL_BT, 0, 6);
				    gridLayout.addComponent(H6_NR_RANDURI_NIVEL_BTCopie, 1, 6);
				    gridLayout.addComponent(copiaza,1,7);

				    H2_BUC_PE_RAND.setValue("");
				    H2_NR_RANDURI_NIVEL_BT.setValue("");
				    H4_BUC_PE_RAND.setValue("");
				    H4_NR_RANDURI_NIVEL_BT.setValue("");
				    H6_BUC_PE_RAND.setValue("");
				    H6_NR_RANDURI_NIVEL_BT.setValue("");
				    
				    
				    
				    H2_BUC_PE_RANDCopie.setVisible(false);
				    H2_NR_RANDURI_NIVEL_BTCopie.setVisible(false);
				    H4_BUC_PE_RANDCopie.setVisible(false);
				    H4_NR_RANDURI_NIVEL_BTCopie.setVisible(false);
				    H6_BUC_PE_RANDCopie.setVisible(false);
				    H6_NR_RANDURI_NIVEL_BTCopie.setVisible(false);
				    copiaza.setVisible(false);
				    produs2.setVisible(false);
		

				    // Add spacing between columns
				    Label columnSpacing = new Label();
				    columnSpacing.setWidth("10px"); // Adjust the width as needed
				    gridLayout.addComponent(columnSpacing, 2, 0);
	

				    main.addComponent(gridLayout); // Add the grid layout to the main layout
				    main.addComponent(spacing); // Add the spacing component after the grid layout
				    main.addComponent(buttons); // Add the buttons layout after the spacing component

				    for (String item : produse_CRUD) {
				        produs.addItem(item);
				    }
				    for (String item : produse_CRUD) {
				        produs2.addItem(item);
				    }
			     
				}
				
				if ((tabel.getValue() + "").equals("MODIFICARE BUNCAR PRESA")) {
				    main.removeAllComponents();
				    
				    main.addComponents(titlu,departament,tabel,cmbPresa,cmbBuncar,spacing,buttons);
				}
				
				if ((tabel.getValue() + "").equals("STANDARD DESCARCARE PRODUSE BISCUITATE")) {
		
			         main.removeComponent(buttons);
			         gridLayout.removeAllComponents();
			         main.addComponents(titlu,departament,tabel);

					    // Add labels and TextFields to the grid layout
					    gridLayout.addComponent(produs, 0, 0);
					    gridLayout.addComponent(produs2, 1, 0);
					    gridLayout.addComponent(VALUE_RASTEL, 0, 1);
					    gridLayout.addComponent(VALUE_RASTELCopie, 1, 1);
					    gridLayout.addComponent(NR_STIVE_PE_PLACA, 0, 2);
					    gridLayout.addComponent(NR_STIVE_PE_PLACACopie, 1, 2);
					    gridLayout.addComponent(NR_BUC_IN_STIVA, 0, 3);
					    gridLayout.addComponent(NR_BUC_IN_STIVACopie, 1, 3);
					    gridLayout.addComponent(TOTAL_PE_NIVEL_CU_PLACA, 0, 4);
					    gridLayout.addComponent(TOTAL_PE_NIVEL_CU_PLACACopie, 1, 4);
					    gridLayout.addComponent(copiaza,1,5);

					    VALUE_RASTEL.setValue("");
					    NR_STIVE_PE_PLACA.setValue("");
					    NR_BUC_IN_STIVA.setValue("");
					    TOTAL_PE_NIVEL_CU_PLACA.setValue("");
					    
					    
					    
					    VALUE_RASTELCopie.setVisible(false);
					    NR_STIVE_PE_PLACACopie.setVisible(false);
					    NR_BUC_IN_STIVACopie.setVisible(false);
					    TOTAL_PE_NIVEL_CU_PLACACopie.setVisible(false);
					    copiaza.setVisible(false);
					    produs2.setVisible(false);

					    // Add spacing between columns
					    Label columnSpacing = new Label();
					    columnSpacing.setWidth("10px"); // Adjust the width as needed
					    gridLayout.addComponent(columnSpacing, 2, 0);
		

					    main.addComponent(gridLayout); // Add the grid layout to the main layout
					    main.addComponent(spacing); // Add the spacing component after the grid layout
					    main.addComponent(buttons); // Add the buttons layout after the spacing component
				     
					    for (String item : produse_Biscuit) {
					        produs.addItem(item);
					    }
					    for (String item : produse_Biscuit) {
					        produs2.addItem(item);
					    }
				     
				}
				
				if ((tabel.getValue() + "").equals("STANDARD DESCARCARE PRODUSE ARSE")) {
				    for (String item : produse_Biscuit) {
				        produs.addItem(item);
				    }
			         main.removeAllComponents();
			         gridLayout.removeAllComponents();
			         main.addComponents(titlu,departament,tabel);
				     
					    // Add labels and TextFields to the grid layout
					    gridLayout.addComponent(produs, 0, 0);
					    gridLayout.addComponent(produs2, 1, 0);
					    gridLayout.addComponent(VALUE_RASTEL2, 0, 1); 
					    gridLayout.addComponent(VALUE_RASTEL2Copie, 1, 1);
					    gridLayout.addComponent(VALUE_PALET, 0, 2);
					    gridLayout.addComponent(VALUE_PALETCopie, 1, 2);
					    gridLayout.addComponent(BUC_STOLT_RASTEL, 0, 3);
					    gridLayout.addComponent(BUC_STOLT_RASTELCopie, 1, 3);
					    gridLayout.addComponent(BUC_STOLT, 0, 4);
					    gridLayout.addComponent(BUC_STOLTCopie, 1, 4);
					    gridLayout.addComponent(hartieseparator, 0, 5);
					    gridLayout.addComponent(SEPARATORCopie, 1, 5);
					    gridLayout.addComponent(copiaza,1,6);

					    VALUE_RASTEL2.setValue("");
					    VALUE_PALET.setValue("");
					    BUC_STOLT_RASTEL.setValue("");
					    BUC_STOLT.setValue("");
					    SEPARATOR.setValue("");
					    
					    
					    
					    VALUE_RASTEL2Copie.setVisible(false);
					    VALUE_PALETCopie.setVisible(false);
					    BUC_STOLT_RASTELCopie.setVisible(false);
					    BUC_STOLTCopie.setVisible(false);
					    SEPARATORCopie.setVisible(false);
					    copiaza.setVisible(false);
					    produs2.setVisible(false);



					    // Add spacing between columns
					    Label columnSpacing = new Label();
					    columnSpacing.setWidth("10px"); // Adjust the width as needed
					    gridLayout.addComponent(columnSpacing, 2, 0);
		

					    main.addComponent(gridLayout); // Add the grid layout to the main layout
					    main.addComponent(spacing); // Add the spacing component after the grid layout
					    main.addComponent(buttons); // Add the buttons layout after the spacing component
				     
					    for (String item : produse_Biscuit) {
					        produs.addItem(item);
					    }
					    for (String item : produse_Biscuit) {
					        produs2.addItem(item);
					    }
				}
				
				if ((tabel.getValue() + "").equals("SETARE DIGITAL PRINTING")) {

					
				main.removeAllComponents();
				main.addComponents(titlu,departament,tabel,cmbEchipament,EchipamentSetat,cmbPosibil,spacing,buttons);
				
				}
				
				if ((tabel.getValue() + "").equals("SETARE SUFLATORI, RECEPTORI SI VENTUZE")) {

				main.removeAllComponents();
				main.addComponents(titlu,departament,tabel,produs,SUFLATOARE,RECEPTORI,VENTUZA_R1,VENTUZAR_R2,spacing,buttons);
				SUFLATOARE.setValue("");
				RECEPTORI.setValue("");
				VENTUZA_R1.setValue("");
				VENTUZAR_R2.setValue("");
			    for (String item : produse_Biscuit) {
			        produs.addItem(item);
			    }
				
				}

			}

		});



		
		
		hartieseparator.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = -3808246903777288220L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				
				if ((hartieseparator.getValue() + "").equals("SEPARATOR STEA")) {
		
			         main.removeComponent(buttons);
			         main.removeComponent(spacing);

				     main.addComponents(SEPARATOR,spacing,buttons);
				}
				
				if ((hartieseparator.getValue() + "").equals("HARTIE")) {
					
			         main.removeComponent(SEPARATOR);
			         SEPARATOR.setValue("");
				}
				

			}

		});
		
		
		produs.addValueChangeListener(new ValueChangeListener() {
		    private static final long serialVersionUID = 7035316032648314255L;

		    @Override
		    public void valueChange(ValueChangeEvent event) {
		        Object tabelValue = tabel.getValue();
		        Object produsValue = produs.getValue();

		        if ("STANDARD INCARCARE PE BT".equals(tabelValue) && produsValue != null) {
		        	produs2.setVisible(true);
		        	produs2.setValue(null);
		        	
		            sql.startConnection();
		            ArrayList<String> dateFasonare = sql.getDateFasonare(produsValue.toString());
		            sql.close_connection();

		            if (!dateFasonare.isEmpty()) {
		                H2_BUC_PE_RAND.setValue(dateFasonare.get(0));
		                H2_NR_RANDURI_NIVEL_BT.setValue(dateFasonare.get(1));
		                H4_BUC_PE_RAND.setValue(dateFasonare.get(2));
		                H4_NR_RANDURI_NIVEL_BT.setValue(dateFasonare.get(3));
		                H6_BUC_PE_RAND.setValue(dateFasonare.get(4));
		                H6_NR_RANDURI_NIVEL_BT.setValue(dateFasonare.get(5));
		            }
		        }

		        if ("STANDARD DESCARCARE PRODUSE BISCUITATE".equals(tabelValue) && produsValue != null) {
		        	produs2.setVisible(true);
		        	produs2.setValue(null);
		            sql.startConnection();
		            ArrayList<String> dateArdere1 = sql.getDateArdere1(produsValue.toString());
		            sql.close_connection();

		            if (!dateArdere1.isEmpty()) {
		                VALUE_RASTEL.setValue(dateArdere1.get(0));
		                NR_STIVE_PE_PLACA.setValue(dateArdere1.get(1));
		                NR_BUC_IN_STIVA.setValue(dateArdere1.get(2));
		                TOTAL_PE_NIVEL_CU_PLACA.setValue(dateArdere1.get(3));
		            }
		        }

		        if ("STANDARD DESCARCARE PRODUSE ARSE".equals(tabelValue) && produsValue != null) {

		        	produs2.setVisible(true);
		        	produs2.setValue(null);
		            sql.startConnection();
		            ArrayList<String> dateArdere2 = sql.getDateArdere2(produsValue.toString());
		            sql.close_connection();

		            if (!dateArdere2.isEmpty()) {
		                VALUE_RASTEL2.setValue(dateArdere2.get(1));
		                VALUE_PALET.setValue(dateArdere2.get(2));
		                BUC_STOLT_RASTEL.setValue(dateArdere2.get(3));
		                BUC_STOLT.setValue(dateArdere2.get(4));
		                if(dateArdere2.get(5).equals("HARTIE")) {
		                	hartieseparator.setValue("HARTIE");
		                }
		                else { 
		                	hartieseparator.setValue("SEPARATOR STEA");
		                	String replaced = dateArdere2.get(5);
		                	replaced = replaced.replace("Ø", "");
		                	SEPARATOR.setValue(replaced);

		                }
		               
		            }
		        }
		        
		        if ("SETARE SUFLATORI, RECEPTORI SI VENTUZE".equals(tabelValue) && produsValue != null) {

		            sql.startConnection();
		            ArrayList<String> dateGlazurare = sql.getDateGlazurare(produsValue.toString());
		            sql.close_connection();

		            if (!dateGlazurare.isEmpty()) {
		                SUFLATOARE.setValue(dateGlazurare.get(1));
		                RECEPTORI.setValue(dateGlazurare.get(2));
		                VENTUZA_R1.setValue(dateGlazurare.get(3));
		                VENTUZAR_R2.setValue(dateGlazurare.get(4));

		               
		            }
		        }
		    }
		});

		produs2.addValueChangeListener(new ValueChangeListener() {
		    private static final long serialVersionUID = 7035316092648314255L;

		    @Override
		    public void valueChange(ValueChangeEvent event) {
		        Object tabelValue = tabel.getValue();
		        Object produs2Value = produs2.getValue();
		        Object produsValue = produs.getValue();

		        if ("STANDARD INCARCARE PE BT".equals(tabelValue) && produs2Value != null) {
		            H2_BUC_PE_RANDCopie.setVisible(true);
		            H2_NR_RANDURI_NIVEL_BTCopie.setVisible(true);
		            H4_BUC_PE_RANDCopie.setVisible(true);
		            H4_NR_RANDURI_NIVEL_BTCopie.setVisible(true);
		            H6_BUC_PE_RANDCopie.setVisible(true);
		            H6_NR_RANDURI_NIVEL_BTCopie.setVisible(true);
		            copiaza.setVisible(true);
		            H2_BUC_PE_RANDCopie.setValue("");
		            H2_NR_RANDURI_NIVEL_BTCopie.setValue("");
		            H4_BUC_PE_RANDCopie.setValue("");
		            H4_NR_RANDURI_NIVEL_BTCopie.setValue("");
		            H6_BUC_PE_RANDCopie.setValue("");
		            H6_NR_RANDURI_NIVEL_BTCopie.setValue("");


		            
		            sql.startConnection();
		            ArrayList<String> dateFasonare = sql.getDateFasonare(produs2Value.toString());
		            sql.close_connection();

		            if (!dateFasonare.isEmpty()) {
		                H2_BUC_PE_RANDCopie.setValue(dateFasonare.get(0));
		                H2_NR_RANDURI_NIVEL_BTCopie.setValue(dateFasonare.get(1));
		                H4_BUC_PE_RANDCopie.setValue(dateFasonare.get(2));
		                H4_NR_RANDURI_NIVEL_BTCopie.setValue(dateFasonare.get(3));
		                H6_BUC_PE_RANDCopie.setValue(dateFasonare.get(4));
		                H6_NR_RANDURI_NIVEL_BTCopie.setValue(dateFasonare.get(5));
		            }

		            copiaza.setCaption("Copiaza datele de la produsul '" + produs2Value + "' la produsul '" + produsValue + "'");
		        }

		        if ("STANDARD DESCARCARE PRODUSE BISCUITATE".equals(tabelValue) && produs2Value != null) {
				    VALUE_RASTELCopie.setVisible(true);
				    NR_STIVE_PE_PLACACopie.setVisible(true);
				    NR_BUC_IN_STIVACopie.setVisible(true);
				    TOTAL_PE_NIVEL_CU_PLACACopie.setVisible(true);
				    copiaza.setVisible(true);
				    VALUE_RASTELCopie.setValue("");
				    NR_STIVE_PE_PLACACopie.setValue("");
				    NR_BUC_IN_STIVACopie.setValue("");
				    TOTAL_PE_NIVEL_CU_PLACACopie.setValue("");
				    
				    
		            sql.startConnection();
		            ArrayList<String> dateArdere1 = sql.getDateArdere1(produs2Value.toString());
		            sql.close_connection();

		            if (!dateArdere1.isEmpty()) {
		                VALUE_RASTELCopie.setValue(dateArdere1.get(0));
		                NR_STIVE_PE_PLACACopie.setValue(dateArdere1.get(1));
		                NR_BUC_IN_STIVACopie.setValue(dateArdere1.get(2));
		                TOTAL_PE_NIVEL_CU_PLACACopie.setValue(dateArdere1.get(3));
		            }
		            
		            copiaza.setCaption("Copiaza datele de la produsul '" + produs2Value + "' la produsul '" + produsValue + "'");
		        }

		        if ("STANDARD DESCARCARE PRODUSE ARSE".equals(tabelValue) && produs2Value != null) {
		        	
				    VALUE_RASTEL2Copie.setVisible(true);
				    VALUE_PALETCopie.setVisible(true);
				    BUC_STOLT_RASTELCopie.setVisible(true);
				    BUC_STOLTCopie.setVisible(true);
				    SEPARATORCopie.setVisible(true);
				    copiaza.setVisible(true);
				    VALUE_RASTEL2Copie.setValue("");
				    VALUE_PALETCopie.setValue("");
				    BUC_STOLT_RASTELCopie.setValue("");
				    BUC_STOLTCopie.setValue("");
				    SEPARATORCopie.setValue("");

				    
		            sql.startConnection();
		            ArrayList<String> dateArdere2 = sql.getDateArdere2(produs2Value.toString());
		            sql.close_connection();

		            if (!dateArdere2.isEmpty()) {
		                VALUE_RASTEL2Copie.setValue(dateArdere2.get(1));
		                VALUE_PALETCopie.setValue(dateArdere2.get(2));
		                BUC_STOLT_RASTELCopie.setValue(dateArdere2.get(3));
		                BUC_STOLTCopie.setValue(dateArdere2.get(4));
		                SEPARATORCopie.setValue(dateArdere2.get(5));
		            }
		            copiaza.setCaption("Copiaza datele de la produsul '" + produs2Value + "' la produsul '" + produsValue + "'");
		        }
		    }
		});



		//Buton Salvare
		save.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 8481136354637891840L;

			@Override
			public void buttonClick(ClickEvent event) {

				//Restrictii
				//==============================================================================================================
				if((departament.getValue()+"").equals("null")) {
					Notification.show("Nu ati selectat departamentul !",Notification.Type.WARNING_MESSAGE);
					departament.focus();
					return;
				}

				if((tabel.getValue()+"").equals("null")) {
					Notification.show("Nu ati selectat tabelul !",Notification.Type.WARNING_MESSAGE);
					tabel.focus();
					return;
				}

				if((produs.getValue()+"").equals("null")) {
					Notification.show("Nu ati selectat produsul !",Notification.Type.WARNING_MESSAGE);
					produs.focus();
					return;
				}

				if( (departament.getValue()+"").equals("FASONARE") && (tabel.getValue()+"").equals("STANDARD INCARCARE PE BT")) {
				if (!isValueInRange099(H2_BUC_PE_RAND.getValue()) ||
					    !isValueInRange099(H2_NR_RANDURI_NIVEL_BT.getValue()) ||
					    !isValueInRange099(H4_BUC_PE_RAND.getValue()) ||
					    !isValueInRange099(H4_NR_RANDURI_NIVEL_BT.getValue()) ||
					    !isValueInRange099(H6_BUC_PE_RAND.getValue()) ||
					    !isValueInRange099(H6_NR_RANDURI_NIVEL_BT.getValue())) {
					    Notification.show("Valorile trebuie sa fie intre 0 si 99!", Notification.Type.WARNING_MESSAGE);
					    // Set focus on the first text field that has an invalid value
					    if (!isValueInRange099(H2_BUC_PE_RAND.getValue())) {
					        H2_BUC_PE_RAND.focus();
					    } else if (!isValueInRange099(H2_NR_RANDURI_NIVEL_BT.getValue())) {
					        H2_NR_RANDURI_NIVEL_BT.focus();
					    } else if (!isValueInRange099(H4_BUC_PE_RAND.getValue())) {
					        H4_BUC_PE_RAND.focus();
					    } else if (!isValueInRange099(H4_NR_RANDURI_NIVEL_BT.getValue())) {
					        H4_NR_RANDURI_NIVEL_BT.focus();
					    } else if (!isValueInRange099(H6_BUC_PE_RAND.getValue())) {
					        H6_BUC_PE_RAND.focus();
					    } else if (!isValueInRange099(H6_NR_RANDURI_NIVEL_BT.getValue())) {
					        H6_NR_RANDURI_NIVEL_BT.focus();
					    }
					    return;
					}
				
				}
				
				
				if( (departament.getValue()+"").equals("ARDERE 1 - DESCARCARE") && (tabel.getValue()+"").equals("STANDARD DESCARCARE PRODUSE BISCUITATE")) {

				if (!isValueInRange099(NR_STIVE_PE_PLACA.getValue()) ||
					    !isValueInRange099(NR_BUC_IN_STIVA.getValue())) {
					    Notification.show("Valorile trebuie sa fie intre 0 si 99!", Notification.Type.WARNING_MESSAGE);
					    // Set focus on the first text field that has an invalid value
					    if (!isValueInRange099(NR_STIVE_PE_PLACA.getValue())) {
					        NR_STIVE_PE_PLACA.focus();
					    } else if (!isValueInRange099(NR_BUC_IN_STIVA.getValue())) {
					        NR_BUC_IN_STIVA.focus();
					    }
					    return;
					}
				
				
				
				if (!isValueInRange0999(VALUE_RASTEL.getValue()) ||
					    !isValueInRange0999(TOTAL_PE_NIVEL_CU_PLACA.getValue())) {
					    Notification.show("Valorile trebuie sa fie intre 0 si 999!", Notification.Type.WARNING_MESSAGE);
					    // Set focus on the first text field that has an invalid value
					    if (!isValueInRange0999(VALUE_RASTEL.getValue())) {
					    	VALUE_RASTEL.focus();
					    } else if (!isValueInRange0999(TOTAL_PE_NIVEL_CU_PLACA.getValue())) {
					    	TOTAL_PE_NIVEL_CU_PLACA.focus();
					    }
					    return;
					}

				}

				
				if( (departament.getValue()+"").equals("ARDERE 2 - DESCARCARE") && (tabel.getValue()+"").equals("STANDARD DESCARCARE PRODUSE ARSE")) {

				if (!isValueInRange099(BUC_STOLT_RASTEL.getValue()) ||
					    !isValueInRange099(BUC_STOLT.getValue()) ||
					    !isValueInRange099(SEPARATOR.getValue())) {
					    Notification.show("Valorile trebuie sa fie intre 0 si 99!", Notification.Type.WARNING_MESSAGE);
					    // Set focus on the first text field that has an invalid value
					    if (!isValueInRange099(BUC_STOLT_RASTEL.getValue())) {
					    	BUC_STOLT_RASTEL.focus();
					    } else if (!isValueInRange099(BUC_STOLT.getValue())) {
					    	BUC_STOLT.focus();
					    } else if (!isValueInRange099(SEPARATOR.getValue())) {
					    	SEPARATOR.focus();
					    }
					    return;
					}
				
				
				
				if (!isValueInRange09999(VALUE_RASTEL2.getValue()) ||
					    !isValueInRange09999(VALUE_PALET.getValue())) {
					    Notification.show("Valorile trebuie sa fie intre 0 si 9999!", Notification.Type.WARNING_MESSAGE);
					    // Set focus on the first text field that has an invalid value
					    if (!isValueInRange09999(VALUE_RASTEL2.getValue())) {
					    	VALUE_RASTEL2.focus();
					    } else if (!isValueInRange09999(VALUE_PALET.getValue())) {
					    	VALUE_PALET.focus();
					    }
					    return;
					}

				}
				
				//Salvare BD
				
				
				//==============================================================================================================
				
				if( (departament.getValue()+"").equals("FASONARE") && (tabel.getValue()+"").equals("STANDARD INCARCARE PE BT")) {
					sql.startConnection();
					if(sql.VerificareFasonare(produs.getValue().toString())==true)
					{
						String updateQueryFasonare = "UPDATE IPEC_RAST_MAX_FASONARE SET H2_BUC_PE_RAND='" + H2_BUC_PE_RAND.getValue() + "', H2_NR_RANDURI_NIVEL_BT='" + H2_NR_RANDURI_NIVEL_BT.getValue() + "', H4_BUC_PE_RAND='" + H4_BUC_PE_RAND.getValue() + "', H4_NR_RANDURI_NIVEL_BT='" + H4_NR_RANDURI_NIVEL_BT.getValue() + "', H6_BUC_PE_RAND='" + H6_BUC_PE_RAND.getValue() + "', H6_NR_RANDURI_NIVEL_BT='" + H6_NR_RANDURI_NIVEL_BT + "' WHERE COD_PRODUS='" + produs.getValue() + "'";

					      Notification notification = new Notification(updateQueryFasonare);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());    
					}
					else {
						//DACA NU EXISTA 
						String insertQueryFasonare = "INSERT INTO IPEC_RAST_MAX_FASONARE (COD_PRODUS,COD_PRODUS_NAV,H2_BUC_PE_RAND,H2_NR_RANDURI_NIVEL_BT,H4_BUC_PE_RAND,H4_NR_RANDURI_NIVEL_BT,H6_BUC_PE_RAND,H6_NR_RANDURI_NIVEL_BT) VALUES ('"+produs.getValue()+"','"+produs.getValue()+"','"+H2_BUC_PE_RAND.getValue()+"','"+H2_NR_RANDURI_NIVEL_BT.getValue()+"','"+H4_BUC_PE_RAND.getValue()+"','"+H4_NR_RANDURI_NIVEL_BT.getValue()+"','"+H6_BUC_PE_RAND.getValue()+"','"+H6_NR_RANDURI_NIVEL_BT.getValue()+"',)";
						
					      Notification notification = new Notification(insertQueryFasonare);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());   
					}
					sql.close_connection();
				}
				
				
				if( (departament.getValue()+"").equals("ARDERE 1 - DESCARCARE") && (tabel.getValue()+"").equals("STANDARD DESCARCARE PRODUSE BISCUITATE")) {
					sql.startConnection();
					if(sql.VerificareArdere1(produs.getValue().toString())==true)
					{
						String updateQueryArdere1 = "UPDATE IPEC_RAST_MAX_BISC SET Value_rastel='" + VALUE_RASTEL.getValue() + "', NR_STIVE_PE_PLACA='" + NR_STIVE_PE_PLACA.getValue() + "', NR_BUC_IN_STIVA='" + NR_BUC_IN_STIVA.getValue() + "', TOTAL_PE_NIVEL_CU_PLACA='" + TOTAL_PE_NIVEL_CU_PLACA.getValue() + "' WHERE COD_PRODUS='" + produs.getValue() + "'";

					      Notification notification = new Notification(updateQueryArdere1);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());    
					}
					else {
						//DACA NU EXISTA 
						String insertQueryArdere1 = "INSERT INTO IPEC_RAST_MAX_BISC (TIP,Value,COD_PRODUS_NAV,Value_rastel,NR_STIVE_PE_PLACA,NR_BUC_IN_STIVA,TOTAL_PE_NIVEL_CU_PLACA) VALUES ('TIP','"+produs.getValue()+"','"+produs.getValue()+"','"+VALUE_RASTEL.getValue()+"','"+NR_STIVE_PE_PLACA.getValue()+"','"+NR_BUC_IN_STIVA.getValue()+"','"+TOTAL_PE_NIVEL_CU_PLACA.getValue()+"')";
						
					      Notification notification = new Notification(insertQueryArdere1);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());   
					}
					sql.close_connection();
				}
				
				
				if( (departament.getValue()+"").equals("ARDERE 2 - DESCARCARE") && (tabel.getValue()+"").equals("STANDARD DESCARCARE PRODUSE ARSE")) {
					sql.startConnection();
					if(sql.VerificareArdere2(produs.getValue().toString())==true)
					{
						String SeparatorInsert="";
						if ((hartieseparator.getValue() + "").equals("HARTIE")) {
							SeparatorInsert="HARTIE";
						}
						else {
							SeparatorInsert="Ø"+SEPARATOR.getValue();	
						}
						String updateQueryArdere2 = "UPDATE IPEC_RAST_MAX SET VALUE_RASTEL='" + VALUE_RASTEL2.getValue() + "', VALUE_PALET='" + VALUE_PALET.getValue() + "', BUC_STOLT_RASTEL='" + BUC_STOLT_RASTEL.getValue() + "', BUC_STOLT='" + BUC_STOLT.getValue() + "', SEPARATOR='" +SeparatorInsert+"' WHERE COD_PRODUS_NAV='" + produs.getValue() + "'";

					      Notification notification = new Notification(updateQueryArdere2);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());    
					}
					else {
						//DACA NU EXISTA 
						
						String P_ARS = sql.getString("select max(ARS) as P_ARS from IPEC_STRUCTURA_BOM where BISCUIT='"+produs.getValue()+"' ");
						String SeparatorInsert="";
						if ((hartieseparator.getValue() + "").equals("HARTIE")) {
							SeparatorInsert="HARTIE";
						}
						else {
							SeparatorInsert="Ø"+SEPARATOR.getValue();	
						}
								
						String insertQueryArdere2 = "INSERT INTO IPEC_RAST_MAX (P_ARS,VALUE,VALUE_RASTEL,VALUE_PALET,COD_PRODUS_NAV,BUC_STOLT_RASTEL,BUC_STOLT,SEPARATOR) VALUES ('"+P_ARS+"','"+produs.getValue()+"','"+VALUE_RASTEL2.getValue()+"','"+VALUE_PALET.getValue()+"','"+produs.getValue()+"','"+BUC_STOLT_RASTEL.getValue()+"','"+BUC_STOLT.getValue()+"','"+SeparatorInsert+"')";
						
					      Notification notification = new Notification(insertQueryArdere2);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());   
					}
					sql.close_connection();
				}
				
				
				
				if( (tabel.getValue()+"").equals("SETARE DIGITAL PRINTING")) {
				
				String echipament,setare;
				echipament=cmbEchipament.getValue()+"";
				setare=cmbPosibil.getValue()+"";
				if(echipament.equals("null") || setare.equals("null") ){
					Notification.show("Completati toate campurile!");
				}else{
					sql.startConnection();
					String querry = "update IPEC_FISE_ADMINISTRARE set GRUPA='"+setare+"',UPDATEDBY='"+c_bpartner_id+"',UPDATED=CURRENT_TIMESTAMP where fisa='Mod_lucru_DPK' and ISACTIVE='Y' and tip='"+echipament+"'";
					sql.modificaDate(querry);
					
					try {
						sql.salveazaDate(new String[] {"FISA","RECIPIENTS","MESAJ","DETAIL_1","DETAIL_2"}
									   , new String[] {"Mod_lucru_DPK",c_bpartner_id,"DETAIL_1=ECHIPAMENT ; DETAIL_2=NEW_VALUE",echipament,setare}
									   , "IPEC_LOGS");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					sql.close_connection();
					Notification.show("S-a salvat!");
					cmbEchipament.setValue(null);
					cmbPosibil.setValue(null);
				}
				
			}
				
				
				
				if ((tabel.getValue() + "").equals("SETARE SUFLATORI, RECEPTORI SI VENTUZE")) {
				    sql.startConnection();
				    if (sql.VerificareGlazurare(produs.getValue().toString()) == true) {
				        String updateQueryFasonare = "UPDATE IPEC_FISA_TEHNICA_PRODUS SET SUFLATOARE='" + SUFLATOARE.getValue().toUpperCase() + "', RECEPTORI='" + RECEPTORI.getValue().toUpperCase() + "', VENTUZA_R1='" + VENTUZA_R1.getValue().toUpperCase() + "', VENTUZAR_R2='" + VENTUZAR_R2.getValue().toUpperCase() + "' WHERE COD_PRODUS_NAV='" + produs.getValue() + "'";

				        Notification notification = new Notification(updateQueryFasonare);
				        notification.setDelayMsec(12000);
				        notification.show(Page.getCurrent());
				    } else {
				        // DACA NU EXISTA 
				        String insertQueryFasonare = "INSERT INTO IPEC_FISA_TEHNICA_PRODUS (COD_PRODUS,COD_PRODUS_NAV,SUFLATOARE,RECEPTORI,VENTUZA_R1,VENTUZAR_R2) VALUES ('" + produs.getValue() + "','" + produs.getValue() + "','" + SUFLATOARE.getValue().toUpperCase() + "','" + RECEPTORI.getValue().toUpperCase() + "','" + VENTUZA_R1.getValue().toUpperCase() + "','" + VENTUZAR_R2.getValue().toUpperCase() + "')";

				        Notification notification = new Notification(insertQueryFasonare);
				        notification.setDelayMsec(12000);
				        notification.show(Page.getCurrent());
				    }
				    sql.close_connection();
				}

				
				
				if( (tabel.getValue()+"").equals("MODIFICARE BUNCAR PRESA")) {
					
					
					String presa,buncar;
					presa=cmbPresa.getValue()+"";
					buncar=cmbBuncar.getValue()+"";
					if(presa.equals("null") || buncar.equals("null") ){
						Notification.show("Completati toate campurile!");
					}else{
						sql.startConnection();
						String querry = "update ipec_fise_administrare set VALUE='"+buncar+"',updated=CURRENT_TIMESTAMP,c_bpartner_id='"+logName.split("_")[2]+"' where FISA = 'legaturaBuncarPresa' and GRUPA ='"+presa+"'";
						System.out.println(querry);
						sql.modificaDate(querry);
						
						sql.close_connection();
						Notification.show("S-a salvat!");
						cmbPresa.setValue(null);
						cmbBuncar.setValue(null);
					}
				
				}

				//Notification.show("S-a salvat !");



				//==============================================================================================================	
			}
		});

		//Buton de deconectare
		disconnect.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1677749219668144356L;

			@Override
			public void buttonClick(ClickEvent event) {
				OracleUI.disconnectUser();
				getParent().getUI().setContent(new login());
			}
		});
		
		
		
		copiaza.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1677749219668344356L;

			@Override
			public void buttonClick(ClickEvent event) {
				Object produs2Value = produs2.getValue();
				Object produsValue = produs.getValue();
				
				if(produsValue!=null && produs2Value!=null) {
				
				if( (departament.getValue()+"").equals("FASONARE") && (tabel.getValue()+"").equals("STANDARD INCARCARE PE BT")) {
					sql.startConnection();
					if(sql.VerificareFasonare(produs.getValue().toString())==true)
					{
						String updateQueryFasonare = "UPDATE IPEC_RAST_MAX_FASONARE SET H2_BUC_PE_RAND='" + H2_BUC_PE_RANDCopie.getValue() + "', H2_NR_RANDURI_NIVEL_BT='" + H2_NR_RANDURI_NIVEL_BTCopie.getValue() + "', H4_BUC_PE_RAND='" + H4_BUC_PE_RANDCopie.getValue() + "', H4_NR_RANDURI_NIVEL_BT='" + H4_NR_RANDURI_NIVEL_BTCopie.getValue() + "', H6_BUC_PE_RAND='" + H6_BUC_PE_RANDCopie.getValue() + "', H6_NR_RANDURI_NIVEL_BT='" + H6_NR_RANDURI_NIVEL_BTCopie + "' WHERE COD_PRODUS='" + produs.getValue() + "'";

					      Notification notification = new Notification(updateQueryFasonare);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());    
					}
					else {
						//DACA NU EXISTA 
						String insertQueryFasonare = "INSERT INTO IPEC_RAST_MAX_FASONARE (COD_PRODUS,COD_PRODUS_NAV,H2_BUC_PE_RAND,H2_NR_RANDURI_NIVEL_BT,H4_BUC_PE_RAND,H4_NR_RANDURI_NIVEL_BT,H6_BUC_PE_RAND,H6_NR_RANDURI_NIVEL_BT) VALUES ('"+produs.getValue()+"','"+produs.getValue()+"','"+H2_BUC_PE_RANDCopie.getValue()+"','"+H2_NR_RANDURI_NIVEL_BTCopie.getValue()+"','"+H4_BUC_PE_RANDCopie.getValue()+"','"+H4_NR_RANDURI_NIVEL_BTCopie.getValue()+"','"+H6_BUC_PE_RANDCopie.getValue()+"','"+H6_NR_RANDURI_NIVEL_BTCopie.getValue()+"',)";
						
					      Notification notification = new Notification(insertQueryFasonare);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());   
					}
									
					sql.close_connection();
				}
				
				
				if( (departament.getValue()+"").equals("ARDERE 1 - DESCARCARE") && (tabel.getValue()+"").equals("STANDARD DESCARCARE PRODUSE BISCUITATE")) {
					sql.startConnection();
					if(sql.VerificareArdere1(produs.getValue().toString())==true)
					{
						String updateQueryArdere1 = "UPDATE IPEC_RAST_MAX_BISC SET Value_rastel='" + VALUE_RASTELCopie.getValue() + "', NR_STIVE_PE_PLACA='" + NR_STIVE_PE_PLACACopie.getValue() + "', NR_BUC_IN_STIVA='" + NR_BUC_IN_STIVACopie.getValue() + "', TOTAL_PE_NIVEL_CU_PLACA='" + TOTAL_PE_NIVEL_CU_PLACACopie.getValue() + "' WHERE COD_PRODUS='" + produs.getValue() + "'";

					      Notification notification = new Notification(updateQueryArdere1);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());    
					}
					else {
						//DACA NU EXISTA 
						String insertQueryArdere1 = "INSERT INTO IPEC_RAST_MAX_BISC (TIP,Value,COD_PRODUS_NAV,Value_rastel,NR_STIVE_PE_PLACA,NR_BUC_IN_STIVA,TOTAL_PE_NIVEL_CU_PLACA) VALUES ('TIP','"+produs.getValue()+"','"+produs.getValue()+"','"+VALUE_RASTELCopie.getValue()+"','"+NR_STIVE_PE_PLACACopie.getValue()+"','"+NR_BUC_IN_STIVACopie.getValue()+"','"+TOTAL_PE_NIVEL_CU_PLACACopie.getValue()+"')";
						
					      Notification notification = new Notification(insertQueryArdere1);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());   
					}
					sql.close_connection();
				}
				
				
				if( (departament.getValue()+"").equals("ARDERE 2 - DESCARCARE") && (tabel.getValue()+"").equals("STANDARD DESCARCARE PRODUSE ARSE")) {
					sql.startConnection();
					if(sql.VerificareArdere2(produs.getValue().toString())==true)
					{
						String updateQueryArdere2 = "UPDATE IPEC_RAST_MAX SET VALUE_RASTEL='" + VALUE_RASTEL2Copie.getValue() + "', VALUE_PALET='" + VALUE_PALETCopie.getValue() + "', BUC_STOLT_RASTEL='" + BUC_STOLT_RASTELCopie.getValue() + "', BUC_STOLT='" + BUC_STOLTCopie.getValue() + "', SEPARATOR='" +SEPARATORCopie+"' WHERE COD_PRODUS_NAV='" + produs.getValue() + "'";

					      Notification notification = new Notification(updateQueryArdere2);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());    
					}
					else {
						//DACA NU EXISTA 
						
						String P_ARS = sql.getString("select max(ARS) as P_ARS from IPEC_STRUCTURA_BOM where BISCUIT='"+produs.getValue()+"' ");
								
						String insertQueryArdere2 = "INSERT INTO IPEC_RAST_MAX (P_ARS,VALUE,VALUE_RASTEL,VALUE_PALET,COD_PRODUS_NAV,BUC_STOLT_RASTEL,BUC_STOLT,SEPARATOR) VALUES ('"+P_ARS+"','"+produs.getValue()+"','"+VALUE_RASTEL2Copie.getValue()+"','"+VALUE_PALETCopie.getValue()+"','"+produs.getValue()+"','"+BUC_STOLT_RASTELCopie.getValue()+"','"+BUC_STOLTCopie.getValue()+"','"+SEPARATORCopie+"')";
						
					      Notification notification = new Notification(insertQueryArdere2);
					      notification.setDelayMsec(12000);
					      notification.show(Page.getCurrent());   
					}
					sql.close_connection();
				}
				
				
				}
				else {	
					
					Notification.show("Nu ati selectat produsele !"+produsValue+produs2Value,Notification.Type.WARNING_MESSAGE);
					
				}

			}
		});
		
		
		
		
		
		
		
		
	}
	
		
		


	
	
	
	private boolean isValueInRange099(String value) {
		if(value==null) return true;
	    
	    try {
	        int num = Integer.parseInt(value);
	        return num >= 0 && num <= 99;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	private boolean isValueInRange0999(String value) {
		if(value==null) return true;
	    
	    try {
	        int num = Integer.parseInt(value);
	        return num >= 0 && num <= 999;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	private boolean isValueInRange09999(String value) {
		if(value==null) return true;
	    
	    try {
	        int num = Integer.parseInt(value);
	        return num >= 0 && num <= 9999;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}



}




