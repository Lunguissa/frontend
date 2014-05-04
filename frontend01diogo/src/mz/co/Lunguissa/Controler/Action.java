package mz.co.Lunguissa.Controler;

import java.util.Date;
import java.util.Vector;

import mz.co.Lunguissa.Classes.Cliente;
import mz.co.Lunguissa.Classes.Registo;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;

public class Action extends SelectorComposer<Component> {
	private  ListModel modelClientes;

	
	private Vector<Cliente> clientes =new Vector<Cliente>();
	@Wire("#cbxClientes")
	private Combobox cbxClientes;
	@Wire("#cbxServico")
	private Combobox cbxServico;
	@Wire("#dtHora")
	private Datebox dtHora;
	@Wire("#btnMarcar")
	private Button btnMarcar;
	@Wire("#txtNome")
	private Textbox txtNome;
	@Wire("#txtNumero")
	private Textbox txtNumero;
	@Wire("#btnInserir")
	private Button btnInserir;
	
	
	@Listen("onClick=#btnMarcar")
	public void marcar()
	{	Cliente cl = null;
		int cnt = cbxClientes.getSelectedIndex();
		for (int i=0;i<clientes.size();i++)
		{
			cl=clientes.get(cnt);
		}
		String srv= cbxServico.getSelectedItem().toString();
		Date tempo= dtHora.getValue();
		Registo obj =new Registo(cl, tempo, srv);
		Messagebox.show(obj.toString(),"Hora Marcada", Messagebox.OK, Messagebox.INFORMATION);
		
		txtNome.setText(null);
		txtNumero.setText(null);
	}
	
	@Listen("onClick=#btnInserir")
	public void inserir()
	{	Vector<String> nomes =new Vector<String>();
		String nome = txtNome.getText();
		int numero =Integer.parseInt(txtNumero.getText());
		Cliente cl =new Cliente(nome, numero);
		clientes.add(cl);
		 for(int i=0;i<clientes.size();i++)
		 {
			 nomes.add(clientes.get(i).getNome());
		 }
		modelClientes= new SimpleListModel(nomes);
		 cbxClientes.setModel(modelClientes);
	}
	
	
	
	
}
