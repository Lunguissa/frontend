package mz.co.Lunguissa.controller;

import mz.co.Lunguissa.entity.MesaDeVoto;
import mz.co.Lunguissa.function.Connector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class Controller extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Combobox prov;
	private Textbox dis;
	private Textbox local;
	private Textbox nrVotos;
	@Wire("#btnOK")
	private Button btnOK;
	
	@Listen("onClick=#btnOK")
	public void show(){
		
		Clients.showNotification("voce submeteu:"
				+ prov.getText() 
				+ dis.getText()
				+ local.getText()
				+ nrVotos.getText());
		
		String prov=this.prov.getText();
		String dis=this.dis.getText();
		String local=this.local.getText();
		int nrVotos=Integer.parseInt(this.nrVotos.getText());
		
		MesaDeVoto mesa = new MesaDeVoto(prov, dis, local,nrVotos);
		try {
//			Connector.connection();
			Connector.write(mesa);
//			Connector.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("erro 1");
			e.printStackTrace();
		}
		
	}
			
	
}
