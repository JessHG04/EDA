//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef LOCALIDAD_h //Directiva de preprocesamiento (pa evitar errores de compilación)
#define LOCALIDAD_h

#include "Coordenadas.h"

using namespace std;

class Localidad{
    friend ostream & operator<< (ostream &, const Localidad &);

    private:
        string nombre;
        Coordenadas coor;
        InfoTur info;
        int id;

    public:
        Localidad(string n);
        Localidad(const Localidad &);
        ~Localidad();
        Localidad & operator=(const Localidad &);
        
        int setCoor(int f, int c, vector<vector<char> > &m);
        void setInfo(InfoTur);
        string getNombre();
        Coordenadas getCoor();
        InfoTur &getInfo();
        int getId();
        
};

#endif
