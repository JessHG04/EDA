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

	col.lectura("zCol02.dat");
	mapa = col.getMapa();
	locas = col.getLocalidades();

	imprimirMapa(mapa);
	imprimirLocalidades(locas);
	

	return 0;
}
