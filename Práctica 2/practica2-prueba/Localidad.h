//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef LOCALIDAD_H
#define LOCALIDAD_H

#include "Coordenadas.h"

class Localidad{
    friend std::ostream & operator<< (std::ostream &, const Localidad &);

    private:
        std::string nombre;
        Coordenadas coor;
        InfoTur info;
        int id;

    public:
        Localidad();
        Localidad(std::string n);
        Localidad(const Localidad &);
        ~Localidad();
        Localidad & operator=(const Localidad &);
        
        int setCoor(int f, int c, std::vector<std::vector<char> > &m);
        void setInfo(InfoTur);
        std::string getNombre();
        Coordenadas getCoor();
        InfoTur &getInfo();
        int getId();
        
};
#endif