//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef COORDENADAS_h //Directiva de preprocesamiento (pa evitar errores de compilación)
#define COORDENADAS_h

#include "InfoTur.h"

using namespace std;

class Coordenadas{
    friend ostream & operator<< (ostream &, const Coordenadas &);

    private:
        int fila;
        int columna;
        
    public:
        Coordenadas();
        Coordenadas(int i, int j);
        Coordenadas(const Coordenadas &);
        ~Coordenadas();
        Coordenadas & operator=(const Coordenadas &);

        int getFila();
        int getColumna();
        void setFila(int);
        void setColumna(int);
    
};

#endif