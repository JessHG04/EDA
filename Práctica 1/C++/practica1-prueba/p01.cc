/**
* @author: Alicia Garrido
* Crea una matriz de caracteres y dos localidades, de manera que una localidad se intenta situar
* en el mar y otra en tierra. Se muestra el resultado de cada accion y las localidades por pantalla
*/
#include <iostream>
#include <vector>
#include "Localidad.h"

using namespace std;

void muestraMapa(vector< vector<char> > &v){
  cout<<"[";
  int i=0;
  for(;i<(int)v.size();i++){
    cout<<"[";
    int j=0;
    for(;j<(int)v[i].size()-1;j++){
       cout<<v[i][j]<<", ";
    }
    if(i==(int)v.size()-1)
      cout<<v[i][j]<<"]";
    else
      cout<<v[i][j]<<"], ";
  }
  cout<<"]"<<endl;
}

int main(){
    Localidad one("Pumpkiski");
    Localidad two("Kisimmee");
    vector< vector<char> > mapa;
    bool mar=false;
    for(int i=0;i<3;i++){
      vector<char> l;
      char tipo='T';
      if(mar)
        tipo='M';
      else mar=true;
      for(int j=0;j<7;j++)
           l.push_back(tipo);
      mapa.push_back(l);
    }
    cout<<"Se situa "<<one.getNombre()<<" en (1,3)? -> "<<one.setCoor(1,3,mapa)<<endl;
    cout<<"Se situa "<<two.getNombre()<<" en (0,5)? -> "<<two.setCoor(0,5,mapa)<<endl;;
    cout<<"Localidades y mapa finales:"<<endl;
    cout<<one<<endl;
    cout<<two<<endl;
    muestraMapa(mapa);
}
