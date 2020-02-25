#include <iostream>
using namespace std;

#include "Localidad.h"
#include "Coordenadas.h"
#include "Coleccion.h"
#include "InfoTur.h"


void imprimirMapa(vector< vector<char> > mapa){
	for(int i = 0; i < mapa.size(); i++){
		for(int j = 0; j < mapa[i].size(); j++){
			cout << mapa[i][j];
		}
		cout << endl;
	}
}
void imprimirLocalidades(vector< Localidad > localidades){
	for(int i = 0; i < localidades.size(); i++){
		cout << localidades[i] << endl;
	}
}


int main(){
	Coleccion col;
	vector<Localidad> locas;
	vector< vector<char> > mapa;

	col.lectura("zCol03.dat");
	mapa = col.getMapa();
	locas = col.getLocalidades();

	imprimirMapa(mapa);
	imprimirLocalidades(locas);

	char elemento;
	
	for(int i = -1; i <= (int) mapa.size(); i++){
		for(int j = -1; j <= (int) mapa[0].size(); j++){
			Coordenadas c(i, j);
			cout << col.getCoorMapa(c);
		}
		cout << endl;
	}

	return 0;
}
