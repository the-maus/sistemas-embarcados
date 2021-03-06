package br.edu.ifba.embarcados.lightsaverclient.conector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class Conector {

	private static final String ENDERECO_WS = "http://localhost:8080/lightsaverws/v1/sw/";

	public String acessar(String urlFuncao) {
		String resultado = "";

		@SuppressWarnings("resource")
		HttpClient cliente = new DefaultHttpClient();
		HttpGet get = new HttpGet(ENDERECO_WS + urlFuncao);
		HttpResponse resposta;
		try {
			resposta = cliente.execute(get);
			BufferedReader br = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent()));

			resultado = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public Integer getId() {
		Integer id = 0;

		String sid = acessar("id");
		if (sid != "") {
			id = Integer.parseInt(sid);
		}

		return id;
	}

	public Integer getLuminosidade() {
		Integer luminosidade = 0;

		String slum = acessar("sensores/luminosidade");
		if (slum != "") {
			luminosidade = Integer.parseInt(slum);
		}

		return luminosidade;
	}

	public Integer getTemperatura() {
		Integer temperatura = 0;

		String stemp = acessar("sensores/temperatura");
		if (stemp != "") {
			temperatura = Integer.parseInt(stemp);
		}

		return temperatura;
	}
	
	public Integer getDistancia() {
		Integer distancia = 0;

		String sdist = acessar("sensores/distancia");
		if (sdist != "") {
			distancia = Integer.parseInt(sdist);
		}

		return distancia;
	}

}
