//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef PROVINCIA_h
#define PROVINCIA_h

#include "LNear.h"
#include "Coleccion.h"

using namespace std;

class Provincia{
    friend ostream & operator<< (ostream &, Provincia &p);
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
        int borraLocalidad(string s);
        LNear &getCercanas();
        string getCostera(Coleccion &c);
        LNear getCosteras(Coleccion &c);
        string getConAeropuerto();
};
#endif