//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#include "Localidad.h"

ostream & operator<< (ostream &os, const Localidad &l) { //Funcion amiga de sobrecarga del operador salida
    os << l.id << "-" << l.nombre << "-" << l.coor << endl << l.info;
    return os;
}

Localidad::Localidad(){
    nombre = "";
    coor = Coordenadas();
    info = InfoTur();
    id = -1;
}

Localidad::Localidad(string n){
    nombre = n;
    coor = Coordenadas();
    info = InfoTur();
    id = -1;
}

Localidad::Localidad(const Localidad &l){
    nombre = l.nombre;
    coor = l.coor;
    info = l.info;
    id = l.id;
}

Localidad::~Localidad(){
    nombre = "";
    coor = Coordenadas();
    info = InfoTur();
    id = -1;
}

Localidad & Localidad::operator=(const Localidad &l){
    nombre = l.nombre;
    coor = l.coor;
    info = l.info;
    id = l.id;

    return *this;
}

int Localidad::setCoor(int f, int c, vector<vector<char> > &mapa){
    int devolver = -1;

    if(f >= 0 && f<(int)mapa.size()){
        if(c >= 0 && c < (int)mapa[f].size()){
            if(id == -1){
                if(mapa[f][c] == 'T'){
                    coor.setFila(f);
                    coor.setColumna(c);
                    mapa[f][c] = 'L';
                    id = mapa[1].size() * f + c;
                    devolver = id;
                }
            }
        }
    }
    return devolver;
}

void Localidad::setInfo(InfoTur i){
    info = i;
}

string Localidad::getNombre(){
    return nombre;
}

Coordenadas Localidad::getCoor(){
    return coor;
}

InfoTur &Localidad::getInfo(){
    return info;
}

int Localidad::getId(){
    return id;
}
