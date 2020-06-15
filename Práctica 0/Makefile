all: Probando InfoTur.o

Probando: InfoTur.o Probando.o
	g++ -g -o Probando Probando.o InfoTur.o

Probando.o: Probando.cc InfoTur.h
	g++ -g -Wall -c Probando.cc

InfoTur.o: InfoTur.cc InfoTur.h
	g++ -g -c InfoTur.cc

clean:
	rm -rf Probando *.o *~
 