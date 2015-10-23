package br.edu.ifba.bsi.embarcados.javaapp.concetor;

import com.sun.jna.Library;

public interface IComunicacaoSensores extends Library{
	
	public int iniciar(String porta);
	public int ler();
	public int getAcelX();
	public int getAcelY();
	public int getAcelZ();
	public int finalizar();

}
