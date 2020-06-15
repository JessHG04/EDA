#include <iostream>
#include <vector>
#include <string>
#include "InfoTur.h"

using namespace std;

int main(int argc,char * argv[]){
	vector<InfoTur> atope;
	vector<InfoTur> increible;
	for(int i=-5; i<5; i++) {
		for(int j=-5; j<5; j++) {
			for(int k=-5; k<5; k++) {
				for(int l=-5; l<5; l++) {
					InfoTur aDentro0(i,j,k,l,false);
					InfoTur aDentro1(i,j,k,l,true);
					InfoTur aDentro2(l,k,j,i,false);
					InfoTur aDentro3(l,k,j,i,true);
					atope.push_back(aDentro0);
					atope.push_back(aDentro1);
					increible.push_back(aDentro2);
					increible.push_back(aDentro3);

				}
			}
		}
	}
	InfoTur defecto;
	atope.push_back(defecto);

	cout << "vamos a meterles cadenas en top" << endl;
	for(int i=0; i<(int)atope.size(); i++) {
		string meterTop = "estamos en la posicion " + to_string(i);
		atope[i].setTop(meterTop);
	}

	cout << "vamos a mostrar el array que hemos petado de InfoTur"<< endl;
	for(int i=0; i<(int)atope.size(); i++) {
		cout << atope[i] << endl;
	}
	cout << "vamos a probar el masFrecuente en cada caso aunque va a tardar la vida" << endl;
	for(int i=0; i<(int)atope.size(); i++) {
		cout <<"posicion:" << i << " " << atope[i].getMasFrecuente() << endl;
	}
	cout << "vamos a comprobar los operadores == y != con los dos vectores" << endl;
	for(int i=10000; i<(int)atope.size(); i++) {
		increible[i] = atope[i];
	}
	for(int i=0; i<(int)atope.size(); i++) {
		cout << "resultado de == en pos: " << i << ":" << bool(atope[i]==increible[i]) <<  endl;
		cout << "resultado de != en pos: " << i << ":" << bool(atope[i]!=increible[i]) <<  endl;
	}
}
