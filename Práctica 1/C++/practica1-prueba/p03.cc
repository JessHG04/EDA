/**
* @author: Alicia Garrido
* Crea una Coleccion que lee el fichero con la informacion para un mapa y
* varias localidades que se situan. Se crea una localidad y se situa en el
* mismo mapa. Se muestra por pantalla el resultado de cada accion y los objetos
*/
#include <vector>
#include <iostream>
#include "Coleccion.h"

using namespace std;

int main(int argc,char* argv[]){
  Coleccion col;
  if(argc==2){
      string name=argv[1];
      col.lectura(name);
      vector<Localidad> cities=col.getLocalidades();
      for(int i=0;i<(int)cities.size();i++)
          cout<<"Ciudad "<<cities[i].getNombre()<<" con identificador "<<cities[i].getId()<<endl;
      Localidad city("SinCity");
      int id=city.setCoor(3,5,col.getMapa());
      if(id!=-1)
         cout<<"Ciudad "<<city.getNombre()<<" con identificador "<<city.getId()<<endl;
      else
         cout<<"Ciudad "<<city.getNombre()<<" sin identificador "<<city.getId()<<endl;
      cout<<"Estado de la coleccion y la localidad extra:"<<endl;
      cout<<col;
      cout<<city;
    }
  else
     cout<<"Forma de uso: p03 p03.dat"<<endl;
}
