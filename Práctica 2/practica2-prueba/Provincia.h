//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef PROVINCIA_H
#define PROVINCIA_H

#include "LNear.h"
#include "Coleccion.h"

using namespace std;

class Provincia{
    friend std::ostream & operator<< (std::ostream &, Provincia &p);
    private:
        Localidad lc;
        LNear locprox; //Lista

    public:
        Provincia();
        Provincia(Localidad l);
        Provincia(const Provincia &p);
        ~Provincia();
        Provincia &operator=(const Provincia &p);
        int distanciaManhattan(int x1, int y1, int x2, int y2);
        void calculaCercanas(Coleccion &c, int i);
        int borraLocalidad(std::string s);
        LNear &getCercanas();
        std::string getCostera(Coleccion &c);
        LNear getCosteras(Coleccion &c);
        std::string getConAeropuerto();
};
#endif