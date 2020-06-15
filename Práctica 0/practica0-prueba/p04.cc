/* autor: Alicia Garrido
*  Se crean tres objetos InfoTur, uno de ellos con el constructor de copia, se muestran
*  por pantalla y se comprueba el funcionamiento de la sobrecarga del operador
*  distinto y setTop.
*/
#include <iostream>
#include "InfoTur.h"

int main(int argc, char*argv[]){
  InfoTur A(1,2,3,4,false),B(1,2,3,4,true);
  InfoTur C(B);
  cout<<"A -> "<<A;
  cout<<"B -> "<<B;
  cout<<"C copia de B:"<<endl;
  cout<<"C -> "<<C;
  if(A!=B)
     cout<<"A y B son distintos"<<endl;
  else
     cout<<"A y B son iguales"<<endl;
  if(B!=C)
     cout<<"B y C son distintos"<<endl;
  else
     cout<<"B y C son iguales"<<endl;
  B.setTop("Torre Eiffel");
  cout<<"Se asigna top a B"<<endl;
  cout<<"B -> "<<B;
  cout<<"C -> "<<C;
  if(B!=C)
     cout<<"B y C son distintos"<<endl;
  else
     cout<<"B y C son iguales"<<endl;
  
}
