//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
//LNear
#include "LNear.h"

ostream & operator<< (ostream &os, const LNear &l){
    LNear::NodoL *lista; //-->ALICIA: el nodo se declara aqui como LNear::NodoL porque es funcion amiga y no hay this
    lista = l.pr;

    while(lista){
        os << *lista;
        lista = lista->next;
    }
    return os;
}

LNear::LNear(){
    pr = NULL;
    ul = NULL;
    error = Localidad();
}

LNear::LNear(const LNear &l){
    NodoL *aux;

    pr = NULL;
    aux = l.pr;
    while(aux){
        if(pr == NULL){ //Primer nodo
            pr = new NodoL(aux->localidad);
            pr->distancia = aux->distancia;
            ul = pr;
        }else{
            ul->next = new NodoL(aux->localidad);
            ul->next->distancia = aux->distancia;
            ul->next->prev = ul;
            ul = ul->next;
        }
        aux = aux->next;
    }
}

LNear::~LNear(){
    NodoL *borrar;

    while(pr!=NULL){
        borrar = pr;
        pr = pr->next;
        delete borrar;
    }
}

LNear &LNear::operator=(const LNear &l){
    NodoL *aux;

    if(this!=&l){
        aux = l.pr;
        while(aux){
            if(pr == NULL){ //Primer nodo
                pr = new NodoL(aux->localidad);
                pr->distancia = aux->distancia;
                ul = pr;
            }else{
                ul->next = new NodoL(aux->localidad);
                ul->next->distancia = aux->distancia;
                ul->next->prev = ul;
                ul = ul->next;
            }
            aux = aux->next;
        }
    }
    return *this;
}

void LNear::borrarLista(){
    NodoL *borrar;

    while(pr!=NULL){
        borrar = pr;
        pr = pr->next;
        delete borrar;
    }
}

bool LNear::esVacia(){
    bool devolver = true;

    if(pr != NULL){
        devolver = false;
    }

    return devolver;
}

int LNear::rango(){
    int devolver = -1;
    NodoL *aux = pr;

    if(aux!=NULL){
        while(aux){
            if(aux->distancia > devolver){
                devolver = aux->distancia;
            }
            aux = aux->next;
        }
    }
    return devolver;
}

string LNear::getCostera(LNear lista){
    string devolver = "";
    NodoL *aux = lista.pr;

    if(aux){
        devolver = aux->localidad.getNombre();
    }

    return devolver;
}

LNear LNear::getCosteras(Coleccion &c){
    LNear devolver;
    NodoL *aux = pr;
    bool costera = false;
    int x1, y1 = 0;
    int xIzq, yIzq, xDrcha, yDrcha, xArriba, yArriba, xAbajo, yAbajo = 0;

    if(aux){
        while(aux) {
            x1 = aux->localidad.getCoor().getFila();
            y1 = aux->localidad.getCoor().getColumna();
            xIzq = x1;
            yIzq = y1 - 1;
            xDrcha = x1;
            yDrcha = y1 + 1;
            xArriba = x1 - 1;
            yArriba = y1;
            xAbajo = x1 + 1;
            yAbajo = y1;
            
            if(costera == false && yIzq >= 0){ //Izquierda
                if(c.getMapa()[xIzq][yIzq] == 'M'){ //Compruebo que en el mapa haya mar
                    devolver.insertaLocalidad(aux->localidad, aux->distancia);
                    costera = true;
                }
            }
             if(costera == false && yDrcha < c.getMapa()[0].size()){ //Derecha
                if(c.getMapa()[xDrcha][yDrcha] == 'M'){ //Compruebo que en el mapa haya mar
                    devolver.insertaLocalidad(aux->localidad, aux->distancia);
                    costera = true;
                }
            } 
             if(costera == false && xArriba >= 0){ //Arriba
                if(c.getMapa()[xArriba][yArriba] == 'M'){ //Compruebo que en el mapa haya mar
                    devolver.insertaLocalidad(aux->localidad, aux->distancia);
                    costera = true;
                }
            } 
             if(costera == false && xAbajo<c.getMapa().size()){ //Abajo
                if(c.getMapa()[xAbajo][yAbajo] == 'M'){ //Compruebo que en el mapa haya mar
                    devolver.insertaLocalidad(aux->localidad, aux->distancia);
                    costera = true;
                }
            }
            costera = false;
            aux = aux->next;
        }
    }
    return devolver;
}

string LNear::getConAeropuerto(LNear lista){
    string devolver = "";
    NodoL *aux = lista.pr;
    bool aeropuerto = false;

    if(aux){
        while(aux && !aeropuerto){
            if(aux->localidad.getInfo().getAeropuerto()){
                devolver = aux->localidad.getNombre();
            }
        }
    }
    return devolver;
}

void LNear::insertaLocalidad(Localidad l, int i){
    bool insertado = false;
    NodoL *insertar = new NodoL(l);
    insertar->distancia = i;
    NodoL *aux = pr;
    //cout <<  "Nodo insertar: " << *insertar;

    if(aux == NULL){ //Lista vacia
        pr = insertar;
        ul = insertar;
        insertado = true;
    }else{    
        //1- Distancia
        //2- Alfabeticamente
        while(aux && !insertado){
            //Primero menor
            if(aux->distancia < i){ 
                if(aux->next!=NULL && aux->next->distancia > i){ //Insercion directa
                    insertar->prev = aux;
                    insertar->next = aux->next;
                    aux->next->prev = insertar;
                    aux->next = insertar;
                    insertado = true;

                }
                else if(aux->next!=NULL && aux->next->distancia == i){ //Orden lexicografico
                    if(aux->next->localidad.getNombre().compare(insertar->localidad.getNombre())<0){
                        aux->next->prev = insertar;
                        insertar->next = aux->next->prev;
                        aux->next = insertar;
                        insertar->prev = aux;
                        insertado = true;
                    }
                    else {aux=aux->next;}

                }
                else if(aux->next == NULL){ //No hay siguiente
                    aux->next = insertar;
                    insertar->prev = aux;
                    insertado = true;
                }
                else {aux=aux->next;} //-->ALICIA: por si no se cumple ningun caso que pase al siguiente nodo
            }
            else
            if(aux->distancia > i){ //-->ALICIA: para insertar en cabeza
               if(aux==pr){
                 insertar->next=pr;
                 pr->prev=insertar;
                 pr=insertar;
                 insertado=true;
               }
               else {aux=aux->next;} //-->ALICIA: por si no se cumple ningun caso que pase al siguiente nodo
            }
            else 
            aux = aux->next;
        }
    }
    if(!insertado){
        delete insertar;
    }
}

int LNear::borraLocalidad(string s){
    int devolver = -1;
    bool eliminado = false;
    NodoL *aux;

    aux = pr;

    while(aux && !eliminado){
        if(aux->localidad.getNombre().compare(s) == 0){
            //Primero de lista
            if(aux->prev == NULL){
                devolver = aux->distancia;
                if(aux->next!=NULL){
                aux->next->prev = NULL;
                }
                else ul=NULL;
                pr = pr->next;
                delete aux;
                eliminado = true;
            }else
            //Normal
            if(aux->prev != NULL && aux->next != NULL){
                devolver = aux->distancia;
                aux->prev->next = aux->next;
                aux->next->prev = aux->prev;
                delete aux;
                eliminado = true;
            }else
            //Ultimo de lista
            if(aux->next == NULL){
                devolver = aux->distancia;
                aux->prev->next = NULL;
                ul = ul->prev;
                delete aux;
                eliminado = true;
            }
        }
    }
    return devolver;
}

void LNear::borraLocalidades(int i){
    NodoL *aux;

    aux = pr;
    while(aux){
        if(aux->distancia > i){
            ul = aux->prev;
            aux->prev->next = NULL;
            while(aux){
                aux = aux->next;
                delete aux->prev;
            }
        }else{
            aux = aux->next;
        }
    }
}

Localidad & LNear::getLocalidad(int i){
    NodoL *aux;
    int n = 0;
    aux = pr;

    while(aux && n<=i){
        if(n == i){
            //devolver = aux->localidad; //-->ALICIA: aqui directamente el return
            return aux->localidad;
        }
        aux = aux->next;
    }
    return error; //-->ALICIA: si llega aqui devuelve error
}

//NodoL
LNear::NodoL::NodoL(Localidad n){
    localidad = n;
    distancia = -1;
    next = NULL;
    prev = NULL;
}
LNear::NodoL::NodoL(const NodoL &n){
    localidad = n.localidad;
    distancia = n.distancia;
    next = n.next;
    prev = n.prev;
}

LNear::NodoL::~NodoL(){
    localidad = Localidad();
    distancia = -1;
    next = NULL;
    prev = NULL;
}

LNear::NodoL &LNear::NodoL::operator=(const NodoL &n){
    localidad = n.localidad;
    distancia = n.distancia;
    next = n.next;
    prev = n.prev;
    return *this;
}