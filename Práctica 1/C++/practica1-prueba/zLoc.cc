#include <iostream>
#include "Localidad.h"
#include "Coordenadas.h"
using namespace std;


vector< vector<char> > crearMapa(){
	char matriz[][4] ={
		{'T', 'M', 'M', 'T'},
		{'M', 'M', 'T', 'T'},
		{'M', 'T', 'M', 'T'}
	};
	vector< vector<char> > mapache;
	
	for(int i = 0; i < 3; i++){
		vector<char> fila;
		for(int j = 0; j < 4; j++){
			fila.push_back(matriz[i][j]);
		}
		mapache.push_back(fila);
	}
	return mapache;
}

void imprimirMapa(vector< vector<char> > mapache){
	for(int i = 0; i < mapache.size(); i++){
		for(int j = 0; j < mapache[i].size(); j++){
			cout << mapache[i][j] << " ";
		}
		cout << endl;
	}

}

int main(){
	int i, j;
	Localidad loc("town");
	cout << loc.getNombre() << " " << loc.getId() << endl;
	vector< vector<char> >  mapa;
	mapa = crearMapa();
	imprimirMapa(mapa);


	for(i = -1; i <= (int) mapa.size(); i++){		
		for(j = -1; j <= (int)  mapa[0].size(); j++){
			Localidad nueva("tosis");
			cout << i << " " << j << " => " << nueva.setCoor(i, j, mapa) << endl;			
			cout << "la localidad se queda con la id " << nueva.getId() << endl;
			cout << "la localidad se queda en la coordenada " << nueva.getCoor().getFila() << " " << nueva.getCoor().getColumna() << endl;
		}
	}
	cout << endl << endl;

	imprimirMapa(mapa);	

	return 0;
}
