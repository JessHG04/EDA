#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <cstdlib>
#include "Coleccion.h"

using namespace std;

int main(int argc, char *argv[]){

	Coleccion colec = Coleccion();
	string fichero=argv[1];
	colec.lectura(fichero);

	Localidad localidad=Localidad("Fnatic City");
	InfoTur info=InfoTur(2,5,1,2,true);
	string top="*** e-Sports Reckless stadium";
	info.setTop(top);

	localidad.setInfo(info);
	localidad.setCoor(2,5,colec.getMapa());

	cout<<localidad<<endl;
	cout<<colec<<endl;

	colec.getLocalidades().push_back(localidad);

	cout<<colec<<endl;

	return 0;
}