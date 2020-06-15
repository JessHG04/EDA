#include"InfoTur.h"

int main(int argc, char *argv[])
{
	InfoTur v;

	cout << "Constructor default:" << endl;
	cout << v << endl;

	InfoTur v1(1,1,1,1,false);
	InfoTur v2(2,2,2,2,true);

	cout << "Se crean dos objetos InfoTur:" << endl;
	cout << "v1: " << v1 << "v2: " << v2 << endl;

	InfoTur v3;
	InfoTur v4(1,2,3,4,true);

	cout << "Se comparan dos objetos:" << endl;

	cout << "Iguales: ";
	if(v3 == v4)
		cout << "True" << endl;
	else
		cout << "False" << endl;

	cout << "Distintos: ";
	if(v3 != v4)
		cout << "True" << endl;
	else
		cout << "False" << endl;

	cout << "v3: " << v3;
	cout << "v4: " << v4 << endl;

	cout << "Igualamos v3 y v4:" << endl;

	v3 = v4;

	cout << "v3: " << v3;
	cout << "v4: " << v4 << endl;

	string m0 = v.getMasFrecuente();
	string m1 = v1.getMasFrecuente();
	string m2 = v2.getMasFrecuente();
	string m3 = v3.getMasFrecuente();
	string m4 = v4.getMasFrecuente();

	cout << "Mas Frecuente 0:" << m0 << endl;
	cout << "Mas Frecuente 1:" << m1 << endl;
	cout << "Mas Frecuente 2:" << m2 << endl;
	cout << "Mas Frecuente 3:" << m3 << endl;
	cout << "Mas Frecuente 4:" << m4 << endl << endl;


	cout << "Usamos setTop() con los objetos:" << endl;
	v.setTop("Farra");
	v1.setTop("Ferre");
	v2.setTop("Firri");
	v3.setTop("Forro");
	v4.setTop("Furru");

	cout << "v:" << " " << v.getTop() << " " << v ;
	cout << "v1:" << " " << v1.getTop() << " " << v1;
	cout << "v2:" << " " << v2.getTop() << " " << v2;
	cout << "v3:" << " " << v3.getTop() << " " << v3;
	cout << "v4:" << " " << v4.getTop() << " " << v4 << endl;


	cout << "Usamos getInfoTur():" << endl;

	vector<int> a0 = v.getInfoTur();
	vector<int> a1 = v1.getInfoTur();
	vector<int> a2 = v2.getInfoTur();
	vector<int> a3 = v3.getInfoTur();
	vector<int> a4 = v4.getInfoTur();


	for(unsigned int i = 0; i < a0.size(); ++i)
	{
		cout << a0[i] << " ";
	}

	cout << endl;

	for(unsigned int i = 0; i < a1.size(); ++i)
	{
		cout << a1[i] << " ";	
	}

	cout << endl;

	for(unsigned int i = 0; i < a2.size(); ++i)
	{
		cout << a2[i] << " ";
	}

	cout << endl;

	for(unsigned int i = 0; i < a3.size(); ++i)
	{
		cout << a3[i] << " ";
	}

	cout << endl;

	for(unsigned int i = 0; i < a4.size(); ++i)
	{
		cout << a4[i] << " ";
	}

	cout << endl << endl;



	InfoTur v5(v1);

	cout << "Usamos el constructir de copia:" << endl << v5 << endl;



	cout << "Usamos el destructor: " << endl;
	v4.~InfoTur();
	cout << "v4: " << v4 << endl; 
}