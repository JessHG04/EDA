/**
* @author: Alicia Garrido
* Crea una Coleccion que lee el fichero con la informacion para un mapa y
* una localidad, que tiene como posicion en el mapa el mar, de manera que 
* debe ser desestimada. Se muestra el objeto Coleccion por pantalla
*/
#include <iostream>
#include "Coleccion.h"

using namespace std;

int main(int argc,char* argv[]){
    Coleccion coli;
    if(argc==2){
       string name=argv[1];
       coli.lectura(name);
       cout<<coli;
    }
    else
     cout<<"Forma de uso: p02 p02.dat"<<endl;
}
