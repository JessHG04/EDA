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

	cout<<colec<<endl;

	

	return 0;
}