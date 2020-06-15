//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef COLECCION_H
#define COLECCION_H

#include "Localidad.h"
#include <fstream>
#include <sstream>
#include <algorithm>
#include <cstdlib>

using namespace std;

class Coleccion{
    friend std::ostream & operator<< (std::ostream &, const Coleccion &);

    private:
        std::vector<std::vector<char> > mapa;
        std::vector<Localidad> localidades;

    public:
        Coleccion();
        Coleccion(const Coleccion &);
        ~Coleccion();
        Coleccion & operator=(const Coleccion &);

        void lectura(std::string f);
        std::vector<std::vector<char> > & getMapa();
        std::vector<Localidad> & getLocalidades();
        char getCoorMapa(Coordenadas);
            
};
#endif