//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef COORDENADAS_H
#define COORDENADAS_H

#include "InfoTur.h"

class Coordenadas{
    friend std::ostream & operator<< (std::ostream &, const Coordenadas &);

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