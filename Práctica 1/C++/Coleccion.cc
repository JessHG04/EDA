//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#include "Coleccion.h"
#include <sstream>

ostream & operator<< (ostream &os, const Coleccion &c) { //Funcion amiga de sobrecarga del operador salida
    //MAPA
    for(unsigned x = 0; x<c.mapa.size(); x++){
        for(unsigned y = 0; y<c.mapa[0].size(); y++){
            os << c.mapa[x][y];
        }
        os << endl;
    }
    //LOCALIDADES
    for(unsigned int z = 0; z<c.localidades.size(); z++){
        os << c.localidades[z];
    }
    return os;
}

Coleccion::Coleccion(){

}

Coleccion::Coleccion(const Coleccion &c){
    mapa = c.mapa;
    localidades = c.localidades;
}

Coleccion::~Coleccion(){
    mapa.clear();
    localidades.clear();
}

Coleccion &Coleccion::operator=(const Coleccion &c){
    mapa = c.mapa;
    localidades = c.localidades;
    return *this;
}

void Coleccion::lectura(const string f){
    fstream fichero;
    fichero.open(f.c_str());
    string linea;
    int esta = -1;
    vector<int> coords;
    bool espacio = false;
    int coordX = -1;
    int coordY = -1;
    string scoordX = "";
    string scoordY = "";
    string info = "";
    int museo = -1;
    int monumento = -1;
    int hotel = -1;
    int restaurante = -1;
    bool ae = false;
    string top = "";
    vector<char> v;
    
    if(fichero.is_open()){
        while(getline(fichero, linea)&&linea!="<LOCALIDAD>"){
            //LECTURA MAPA
            for (unsigned y = 0; y<linea.length(); y++){
                v.push_back(linea[y]);
            }
            mapa.push_back(v);
            v.clear();
        }
        while(getline(fichero, linea)){
            //LECTURA LOCALIDADES
            Localidad l(linea); //Creo la localidad
            getline(fichero, linea);
            //Separo las coordenadas
            for (unsigned x = 0; x<linea.length(); x++){
                if(linea[x] == ' '){
                    espacio = true;
                }
                if(!espacio){
                    scoordX = scoordX + linea[x];
                }else if(espacio){
                    scoordY = scoordY + linea[x];
                }
            }
            espacio = false;

            istringstream(scoordX)>>coordX;
            istringstream(scoordY)>>coordY;
            esta = l.setCoor(coordX, coordY, getMapa());//Agrego coordenadas
            scoordX.clear();
            scoordY.clear();
            //INFORMACION
            getline(fichero, linea); //<INFO>
            getline(fichero, linea);
            while(linea != "<LOCALIDAD>" && !fichero.eof()){
                if(linea[0] == 'm'){//Caso Museo y Monumento
                    if(linea[1] == 'u'){ //Museo
                        stringstream ss(linea);
                        ss>>info;
                        ss>>museo;
                    }else{
                        stringstream ss(linea); // Monumento
                        ss>>info;
                        ss>>monumento;
                    }
                }
                if(linea[0] == 'h'){
                    stringstream ss(linea);
                    ss>>info;
                    ss>>hotel;
                }
                if(linea[0] == 'r'){ 
                    stringstream ss(linea);
                    ss>>info;
                    ss>>restaurante;
                }
                if(linea[0] == 'a'){
                    ae = true;
                }
                if(linea[0] == '*'){
                    top = linea;
                }
                getline(fichero, linea);
            }
            InfoTur it = InfoTur(museo, monumento, hotel, restaurante, ae);
            it.setTop(top);
            museo = -1;
            monumento = -1;
            hotel = -1;
            restaurante = -1;
            ae = false;
            top.clear();

            l.setInfo(it);
            if(esta > -1){
                localidades.push_back(l);
            }
        }
        fichero.close();
    }
}

vector<vector<char> > & Coleccion::getMapa(){
    return mapa;
}

vector<Localidad> &Coleccion::getLocalidades(){
    return localidades;
}

char Coleccion::getCoorMapa(Coordenadas c){
    char devolver = 'X';
    int f = c.getFila();
    int coor = c.getColumna();

    for(unsigned int x = 0; x<mapa.size(); x++){
        for(unsigned int y = 0; y<mapa[x].size(); y++){
            if(f == (int)x && coor == (int)y){
                devolver = mapa[x][y];
            }
        }
    }
    return devolver;
}