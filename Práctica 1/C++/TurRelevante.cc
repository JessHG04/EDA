//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#include "Coleccion.h"

using namespace std;

int main(int argc, char const *argv[]){
    Coleccion colec = Coleccion();

    if(argc == 2){
        colec.lectura(argv[1]);

        for(unsigned int x = 0; x < colec.getLocalidades().size(); x++){
				cout << colec.getLocalidades()[x].getNombre() << " (" << colec.getLocalidades()[x].getCoor().getFila() << "," << colec.getLocalidades()[x].getCoor().getColumna() << "): ";
				cout << colec.getLocalidades()[x].getInfo().getMasFrecuente();
				
				if(colec.getLocalidades()[x].getInfo().getTop() != ""){
					cout << " - " << colec.getLocalidades()[x].getInfo().getTop();
				}
				cout << endl;
			}
    }
}
