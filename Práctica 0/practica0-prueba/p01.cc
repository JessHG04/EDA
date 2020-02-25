/* autor: Alicia Garrido
*  Se crean dos objetos InfoTur, uno de ellos con el constructor por defecto, y se prueba la sobrecarga del operador
*  asignacion y getInfoTur
*/

#include <iostream>
#include "InfoTur.h"

void muestra(vector<int>  sal){
  for(unsigned int i=0;i<sal.size()-1;i++)
   cout<<sal[i]<<",";
  if(sal.size()>0)
    cout<<sal[sal.size()-1];
}

int main(int argc, char*argv[]){
  InfoTur A(1,2,3,4,false),B;
  vector<int> sal;
  sal=A.getInfoTur();
  cout<<"A -> {";muestra(sal);cout<<"}"<<endl;
  sal=B.getInfoTur();
  cout<<"B -> {";muestra(sal);cout<<"}"<<endl;
  cout<<"despues de B=A:"<<endl;
  B=A;
  sal=A.getInfoTur();
  cout<<"A -> {";muestra(sal);cout<<"}"<<endl;
  sal=B.getInfoTur();
  cout<<"B -> {";muestra(sal);cout<<"}"<<endl;
  
}
