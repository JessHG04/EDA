#pragma ONCE

#include <iostream>
#include <string>
#include <vector>
using namespace std;
class InfoTur{
    friend std::ostream & operator<< (std::ostream &, const InfoTur &);

    private:
        int museo;
        int monumento;
        int hotel;
        int restaurante;
        bool aeropuerto;
        std::string top;

    public:
        InfoTur();
        InfoTur(int mu, int mo, int ho, int r, bool ae);
        InfoTur(const InfoTur &);
        ~InfoTur();
        InfoTur & operator=(const InfoTur &);
        bool operator!=(const InfoTur&);
        bool operator==(const InfoTur&);
        
        std::vector<int> getInfoTur();
        std::string getMasFrecuente();
        void setTop(std::string n);
        std::string getTop();
        bool getAeropuerto();
};