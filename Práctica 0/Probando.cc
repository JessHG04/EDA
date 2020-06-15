//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
#include "InfoTur.h"

int main(){
    vector<InfoTur> info;
    vector<InfoTur> limpio;
    InfoTur it;
    int num;
    int contador = 0;
    bool aux;
    
    
    while(cin >> num){
        if(num%2 == 0){
            aux = false; 
        }else{
            aux = true;
        }
        it = InfoTur(num, num, num, num, aux);
        info.push_back(it);

    }

    for(unsigned int x = 0; x < info.size(); x++){
        if(contador % 2 == 0){
            if(info[x].getAeropuerto()){
                limpio.push_back(info[x]);
            }
        }
        contador++;
    }

    for(unsigned int x = 0; x < limpio.size(); x++){
        cout << limpio[x];
    }
}
