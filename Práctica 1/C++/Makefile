OBJETOS=InfoTur.o Coordenadas.o Localidad.o Coleccion.o

All: $(OBJETOS) TurRelevante

TurRelevante: TurRelevante.cc Coleccion.h
	g++ -g -Wall -o TurRelevante TurRelevante.cc $(OBJETOS)

InfoTur.o: InfoTur.h InfoTur.cc
	g++ -g -Wall -c InfoTur.cc

Coordenadas.o: Coordenadas.cc Coordenadas.h
	g++ -g -Wall -c Coordenadas.cc

Localidad.o: Localidad.cc Localidad.h Coordenadas.h InfoTur.h
	g++ -g -Wall -c Localidad.cc

Coleccion.o: Coleccion.cc Coleccion.h Localidad.h
	g++ -g -Wall -c Coleccion.cc

clean:
	rm -rf *.o *~ TurRelevante
