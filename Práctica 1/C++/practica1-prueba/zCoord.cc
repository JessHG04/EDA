#include <iostream>
#include "Coordenadas.h"
using namespace std;

int main(){
	Coordenadas cor1(3, 3);

	cout << cor1.getFila() << " " << cor1.getColumna() << endl;

	Coordenadas cor2(-1, 3);

	cout << cor2.getFila() << " " << cor2.getColumna() << endl; // -1 -1
	

	Coordenadas cor3(0, 3);

	cout << cor3.getFila() << " " << cor3.getColumna() << endl; // 0 3


	return 0;
}
