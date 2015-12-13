/*
 * Extern.cpp
 *
 *  Created on: 3 de dez de 2015
 *      Author: MATHEUS
 */

#include "Extern.h"
#include "Comunicacao.h"

struct InfoRF {
  int id;
  int luminosidade;
  int temperatura;
  int distancia;
} infoRF;


Comunicacao com = NULL;

int iniciar(char* porta){
	com = Comunicacao("COM5");
	return com.iniciar();
}
int ler(){
	int resultado = EXIT_FAILURE;
	char ci, cf;

	if(com.ler((char*) &ci, sizeof(ci)) == 0 && (ci == 'I')) {
		if(com.ler((char*) &infoRF, sizeof(InfoRF))==0){
			if(com.ler((char*) &cf, sizeof(cf)) == EXIT_SUCCESS && (cf == 'F')) {
				resultado = EXIT_SUCCESS;
			}
		}
	}

	return resultado;
}
int getId(){
	return infoRF.id;
}
int getLuminosidade(){
	return infoRF.luminosidade;
}
int getTemperatura(){
	return infoRF.temperatura;
}
int getDistancia(){
	return infoRF.distancia;
}
int finalizar(){
	return com.finalizar();
}

