//DNI 23900715N HERNANDEZ GOMEZ, JESSICA 
#include "Coordenadas.h"

std::ostream & operator<< (std::ostream &os, const Coordenadas &c) { //Funcion amiga de sobrecarga del operador salida
    os << "(" << c.fila << "," << c.columna << ")";
    return os;
}

Coordenadas::Coordenadas(){
    fila = -1;
    columna = -1;
}

Coordenadas::Coordenadas(int i, int j){
    if(i>=0 && j>=0){
        fila = i;
        columna = j;
    }else{
        fila = -1;
        columna = -1;
    }
}

Coordenadas::Coordenadas(const Coordenadas &c){
    fila = c.fila;
    columna = c.columna;
}

Coordenadas::~Coordenadas(){
    fila = -1;
    columna = -1;
}

Coordenadas & Coordenadas::operator=(const Coordenadas &c){
    fila = c.fila;
    columna = c.columna;
    return *this;
}

int Coordenadas::getFila(){
    return fila;
}

int Coordenadas::getColumna(){
    return columna;
}

void Coordenadas::setFila(int f){
    fila = f;
}

void Coordenadas::setColumna(int c){
    columna = c;
}