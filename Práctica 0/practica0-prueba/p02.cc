/* autor: Alicia Garrido
*  Se crean tres objetos InfoTur, uno de ellos con el constructor de
*  copia, se comprueba el funcionamiento de la sobrecarga del operador salida y
*  setTop.
*/
#include <iostream>
#include "InfoTur.h"

int main(int argc, char*argv[]){
  InfoTur A(1,2,3,4,false),B(0,2,0,2,true);
  InfoTur C(B);
  cout<<"A -> "<<A;
  cout<<"B -> "<<B;
  cout<<"C copia de B:"<<endl;
  cout<<"C -> "<<C;
  cout<<"setTop de B:"<<endl;
  B.setTop("Torre Eiffel");
  cout<<"B -> "<<B;
  cout<<"C -> "<<C;
  
}
