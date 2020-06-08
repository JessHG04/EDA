//DNI 23900715N HERNANDEZ GOMEZ, JESSICA 
 #include "InfoTur.h"

std::ostream & operator<< (std::ostream &os, const InfoTur &c) { //Funcion amiga de sobrecarga del operador salida
    os << c.museo << " " << c.monumento << " " << c.hotel << " " << c.restaurante << " " << c.aeropuerto << " " << c.top << std::endl;
    return os;
}

InfoTur::InfoTur() { //Constructores
    museo = 0;
    monumento = 0;
    hotel = 0;
    restaurante = 0;
    aeropuerto = false;
    top = "";
}

InfoTur::InfoTur(int mu, int mo, int ho, int r, bool ae) {
    if (mu > 0){
        museo = mu;
    }else{
        museo = 0;
    }
    if (mo > 0){
        monumento = mo;
    }else{
        monumento = 0;
    }
    if(ho > 0){
        hotel = ho;
    }else{
        hotel = 0;
    }
    if(r > 0){
        restaurante = r;
    }else{
        restaurante = 0;
    }
    aeropuerto = ae;
    top = "";
}

InfoTur::InfoTur(const InfoTur &t) {
    museo = t.museo;
    monumento = t.monumento;
    hotel = t.hotel;
    restaurante = t.restaurante;
    aeropuerto = t.aeropuerto;
    top = t.top;
}

InfoTur::~InfoTur() {  //Destructor
    museo = 0;
    monumento = 0;
    hotel = 0;
    restaurante = 0;
    aeropuerto = false;
    top = "";
}

InfoTur & InfoTur::operator=(const InfoTur &t) { //Operadores
    museo = t.museo;
    monumento = t.monumento;
    hotel = t.hotel;
    restaurante = t.restaurante;
    aeropuerto = t.aeropuerto;
    top = t.top;
    return *this;
}

bool InfoTur::operator!=(const InfoTur &t){
    bool resultado = false;

    if(museo != t.museo){
        resultado = true;
    }else if(monumento != t.monumento){
        resultado = true;
    }else if(hotel != t.hotel){
        resultado = true;
    }else if(restaurante != t.restaurante){
        resultado = true;
    }else if(aeropuerto != t.aeropuerto){
        resultado = true;
    }else if(top != t.top){
        resultado = true;
    }

    return resultado;
}

bool InfoTur::operator==(const InfoTur &t){
    bool resultado = false;

    if(museo == t.museo && monumento == t.monumento && hotel == t.hotel && restaurante == t.restaurante && aeropuerto == t.aeropuerto && top == t.top){
        resultado = true;
    }

    return resultado;
}

std::vector<int> InfoTur::getInfoTur() { //Metodos
    std::vector<int> devolver;
    int aero;

    if(!aeropuerto){
        aero = 0;
    }else{
        aero = 1;
    }

    devolver.push_back(museo);
    devolver.push_back(monumento);
    devolver.push_back(hotel);
    devolver.push_back(restaurante);
    devolver.push_back(aero);
    
    return devolver;
}

std::string InfoTur::getMasFrecuente() {
    std::string devolver;
    int mas;
    int aero;

    if(!aeropuerto){
        aero = 0;
    }else{
        aero = 1;
    }

    mas = aero;
    devolver = "aeropuerto";

    if(hotel > mas){
        mas = hotel;
        devolver = "hotel";
    }
    if(monumento > mas){
        mas = monumento;
        devolver = "monumento";
    }
    if(museo > mas){
        mas = museo;
        devolver = "museo";
    }
    if(restaurante > mas){
        mas = restaurante;
        devolver = "restaurante";
    }
    return devolver;
}

void InfoTur::setTop(std::string s) {
    top = s;
}

std::string InfoTur::getTop() {
    return top;
}

bool InfoTur::getAeropuerto() {
    return aeropuerto;
}
