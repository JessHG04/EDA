//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef LNEAR_H
#define LNEAR_H

#include "Coordenadas.h"
#include "Localidad.h"
#include "Coleccion.h"

using namespace std;

class NodoL;

class LNear{
    friend std::ostream &operator<<(std::ostream &, const LNear &);

    private:
        class NodoL;
        NodoL *pr;
        NodoL *ul;
        Localidad error;

    public:
        LNear();
        LNear(const LNear &);
        ~LNear();
        LNear & operator=(const LNear &);
        void borrarLista();
        bool esVacia();
        int rango();
        std::string getCostera(LNear);
        LNear getCosteras(Coleccion &);
        std::string getConAeropuerto(LNear);
        void insertaLocalidad(Localidad, int);
        int borraLocalidad(std::string);
        void borraLocalidades(int);
        Localidad & getLocalidad(int);
                   
};

class LNear::NodoL{ 
    friend std::ostream &operator<<(std::ostream &os, NodoL &n){
        os << n.localidad.getNombre() << " (" << n.distancia << ")" << std::endl;
        return os; 
    }

   public: 
        Localidad localidad;
        int distancia;
        NodoL *next;
        NodoL *prev;

        NodoL(Localidad);
        NodoL(const NodoL &);
        ~NodoL();
        NodoL & operator=(const NodoL&);
        friend class LNear;
};

#endif