/* autor: Alicia Garrido
*  Se crea un objeto InfoTur con distintos valores para sus caracteristicas y
*  se invoca getMasFrecuente, mostrando por pantalla el resultado de la accion
*  y el objeto InfoTur.
*/
#include <iostream>
#include "InfoTur.h"

int main(int argc, char*argv[]){
  InfoTur A(1,4,3,4,false);
  cout<<"A -> "<<A;
  cout<<"mas frecuente de A -> "<<A.getMasFrecuente()<<endl;
}
