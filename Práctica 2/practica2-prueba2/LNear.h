//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef LNEAR_h
#define LNEAR_h

#include "Coordenadas.h"
#include "Localidad.h"
#include "Coleccion.h"

using namespace std;

class NodoL;

class LNear{
    friend ostream &operator<<(ostream &, const LNear &);

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
        string getCostera(LNear);
        LNear getCosteras(Coleccion &);
        string getConAeropuerto(LNear);
        void insertaLocalidad(Localidad, int);
        int borraLocalidad(string);
        void borraLocalidades(int);
        Localidad & getLocalidad(int);
                   
};

class LNear::NodoL{ 
    friend ostream &operator<<(ostream &os, NodoL &n){
        os << n.localidad.getNombre() << " (" << n.distancia << ")" << endl;
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