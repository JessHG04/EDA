#! /bin/bash

total=0
diferencias=""

function CorrigeResto(){
    nombre=$1
    if test -e $nombre.tmp; then
      diff $nombre.tmp $nombre.txt > d1.tmp
      nlin=$(cat d1.tmp|wc -l)
      if test $nlin -eq 0; then
        nota=2
      else
        nota=0
        diferencias="diferencias en fichero salida txt; ejecuta diff $nombre.txt $nombre.tmp"
      fi
      rm -rf d?.tmp  
    fi
    return $nota
}

compilador=g++
aplicacion=TurRelevante
fuentes=$(ls *.h *.cc 2>/dev/null)

directorio=practica1-prueba
cantidad=$(ls *.cc *.h|wc -l)
numfuentes=0
nota=0
rm -rf *.tmp  $directorio/*.tmp $directorio/*.terr *.class $directorio/*.class $directorio/*.tmp.err

for fichero in $fuentes; do
 if test $fichero == Coleccion.h || test $fichero == Coleccion.cc || \
    test $fichero == Coordenadas.h || test $fichero == Coordenadas.cc || \
    test $fichero == Localidad.h || test $fichero == Localidad.cc ||  \
    test $fichero == InfoTur.h || test $fichero == InfoTur.cc || test $fichero == TurRelevante.cc ; then 
  if test -f $fichero; then
  let numfuentes=numfuentes+1
  fi
 fi
done

if test $numfuentes -eq 9 -a $cantidad -eq 9; then
  continuar=true
else
  continuar=true
  echo ", juri juri noor ; 0"
fi

if $continuar; then
 make >/dev/null 2> errores.compilacion 
 grep -i "error:" errores.compilacion >numerror 
 grep -i "warning:" errores.compilacion >>numerror 
 numlin=$(cat numerror | wc -l)
 if test $numlin -ne 0; then
  echo "Error de compilacion; 0"
  rm -rf numerror
  make clean >/dev/null
  exit 1
 else
  rm -rf errores.compilacion
 fi
 # rm -rf errores.compilacion
 rm -rf numerror
 mv *.o $directorio
 mv $aplicacion $directorio
 cp *.h $directorio
 cd  $directorio
 ficherosprueba=$(ls *.cc)
 total=0
 for prueba in $ficherosprueba; do
  nombre=$(basename $prueba .cc)
  $compilador -g -o $nombre $prueba *.o 2> $nombre.terr  
  numlin=$(cat $nombre.terr | wc -l)
  if test $numlin -eq 0; then
    if test -e $nombre.dat; then
       $(./$nombre $nombre.dat  >$nombre.tmp 2>$nombre.tmp.err)
    else 
      if test -e $nombre.data; then
       $(./$aplicacion $nombre.data  >$nombre.tmp 2>$nombre.tmp.err)
      else
       $(./$nombre  >$nombre.tmp 2>$nombre.tmp.err)
      fi
    fi
    numlin=$(cat $nombre.tmp.err|wc -l)
    if test $numlin -eq 0; then
      CorrigeResto $nombre
      nota=$?
      if test $nota -eq 2; then
        echo "Prueba $nombre: Ok" 
        let total=total+1
      else
        echo "Prueba $nombre: $diferencias" 
      fi
    else
      echo "Prueba $nombre: Hay errores de ejecucion"
      cat $nombre.tmp.err
    fi
  else
   echo "Prueba $nombre: hay errores de compilacion" 
   cat $nombre.terr
  fi
 rm -rf d1.tmp $nombre.terr 
 done
 echo "Nota: $total"
fi

