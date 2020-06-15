//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#ifndef INFOTUR_h //Directiva de preprocesamiento (pa evitar errores de compilación)
#define INFOTUR_h

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class InfoTur{
    friend ostream & operator<< (ostream &, const InfoTur &);

    private:
        int museo;
        int monumento;
        int hotel;
        int restaurante;
        bool aeropuerto;
        string top;

    public:
        InfoTur();
        InfoTur(int mu, int mo, int ho, int r, bool ae);
        InfoTur(const InfoTur &);
        ~InfoTur();
        InfoTur & operator=(const InfoTur &);
        bool operator!=(const InfoTur&);
        bool operator==(const InfoTur&);
        
        vector<int> getInfoTur();
        string getMasFrecuente();
        void setTop(string n);
        string getTop();
        bool getAeropuerto();
};

#endif