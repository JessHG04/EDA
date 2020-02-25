//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#include "Provincia.h"

ostream & operator<< (ostream &os, Provincia &p) {
    os << p.lc.getNombre() << endl;
    os << p.locprox;
    return os;
}

Provincia::Provincia(){
    lc = Localidad();
    locprox = LNear();
}

Provincia::Provincia(Localidad l){
    lc = l;
    locprox = LNear();
}

Provincia::Provincia(const Provincia &p){
    lc = p.lc;
    locprox = p.locprox;
}

Provincia::~Provincia(){
    lc = Localidad();
    locprox = LNear();
}

Provincia &Provincia::operator=(const Provincia &p){
    lc = p.lc;
    locprox = p.locprox;
    return *this;
}

int Provincia::distanciaManhattan(int x1, int y1, int x2, int y2){
    int distancia = 0;

    distancia = abs(x1 - x2) + abs(y1 - y2);

    return distancia;
}

void Provincia::calculaCercanas(Coleccion &c, int i){
    int distancia = 0;
    int x1, y1 = 0;
    int x2 = lc.getCoor().getFila();
    int y2 = lc.getCoor().getColumna();

    locprox.borrarLista();

    //Recorrer las localidades de la Coleccion
    for(unsigned x = 0; x < c.getLocalidades().size(); x++){
        x1 = c.getLocalidades()[x].getCoor().getFila();
        y1 = c.getLocalidades()[x].getCoor().getColumna();
        distancia = distanciaManhattan(x1, y1, x2, y2);
        if(distancia <= i && distancia > 0){
            locprox.insertaLocalidad(c.getLocalidades()[x], distancia);
        }
    }
}

int Provincia::borraLocalidad(string s){ 
    int devolver = -1;

    
    
    return devolver;
}

LNear &Provincia::getCercanas(){
    return locprox;
}

string Provincia::getCostera(Coleccion &c){ 
    LNear costeras = locprox.getCosteras(c);
    string costera = locprox.getCostera(costeras);
    string devolver = "no hay ninguna localidad costera";

    if(costera == ""){
        return devolver;
    }else{
        return costera;
    }
}

LNear Provincia::getCosteras(Coleccion &c){ 
    LNear devolver = locprox.getCosteras(c);

    return devolver;
}

string Provincia::getConAeropuerto(){
    string propio = "propio";
    string no = "sin aeropuerto";
    string proximo = locprox.getConAeropuerto(locprox);

    if(lc.getInfo().getAeropuerto()){
        return propio;
    }else if(proximo != ""){
        return proximo;
    }else{
        return no;
    }
}