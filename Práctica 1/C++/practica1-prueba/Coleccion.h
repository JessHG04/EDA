//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef COLECCION_h //Directiva de preprocesamiento (pa evitar errores de compilación)
#define COLECCION_h

#include "Localidad.h"
#include <fstream>
#include <sstream>
#include <algorithm>
#include <cstdlib>

using namespace std;

class Coleccion{
    friend ostream & operator<< (ostream &, const Coleccion &);

    private:
        vector<vector<char> > mapa;
        vector<Localidad> localidades;

    public:
        Coleccion();
        Coleccion(const Coleccion &);
        ~Coleccion();
        Coleccion & operator=(const Coleccion &);

        void lectura(string f);
        vector<vector<char> > & getMapa();
        vector<Localidad> & getLocalidades();
        char getCoorMapa(Coordenadas);
            
};

#endif
