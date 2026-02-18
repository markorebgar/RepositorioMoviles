package com.example.calculadorav2.model.sampledata

class CicloVidaModel {

    var misDatos = Datos("ok", "0","0", false,"", 0.0,0.0, false);

    public fun uno () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }

        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "1";
        }else{
            misDatos.textoAbajo += "1";
        }


        return misDatos;

    }
    public fun dos () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "2";
        }else{
            misDatos.textoAbajo += "2";
        }

        return misDatos;

    }
    public fun tres () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "3";
        }else{
            misDatos.textoAbajo += "3";
        }
        return misDatos;

    }
    public fun cuatro () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "4";
        }else{
            misDatos.textoAbajo += "4";
        }
        return misDatos;

    }
    public fun cinco () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "5";
        }else{
            misDatos.textoAbajo += "5";
        }
        return misDatos;

    }
    public fun seis () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "6";
        }else{
            misDatos.textoAbajo += "6";
        }
        return misDatos;

    }public fun siete () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "7";
        }else{
            misDatos.textoAbajo += "7";
        }
        return misDatos;

    }
    public fun ocho () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "8";
        }else{
            misDatos.textoAbajo += "8";
        }
        return misDatos;

    }
    public fun nueve () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo == "0"){
            misDatos.textoAbajo = "9";
        }else{
            misDatos.textoAbajo += "9";
        }
        return misDatos;

    }
    public fun cero () : Datos{
        misDatos.mostrarToast = false;

        if(misDatos.borrar && misDatos.operacion == ""){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.borrar = false;
        }
        if(misDatos.textoAbajo != "0"){
            misDatos.textoAbajo += "0";
        }

        return misDatos;

    }


    public fun sumar () : Datos{

        if(misDatos.textoAbajo == "operacion no valida"){

            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.primero = 0.0;
            misDatos.segundo = 0.0;
            misDatos.operacion = "";
            misDatos.mostrarToast = false;

            return misDatos;
        }

        if(misDatos.operacion != ""){

            misDatos.mostrarToast = true;
            return misDatos;

        }
        misDatos.mostrarToast = false;

        misDatos.primero = misDatos.textoAbajo.toDouble()

        misDatos.textoArriba = misDatos.textoAbajo + "+";
        misDatos.operacion = "+"



        misDatos.textoAbajo = "0"
        return misDatos;

    }
    public fun restar () : Datos{

        if(misDatos.textoAbajo == "operacion no valida"){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.primero = 0.0;
            misDatos.segundo = 0.0;
            misDatos.operacion = "";
            misDatos.mostrarToast = false;


            return misDatos;
        }

        if(misDatos.operacion != ""){

            misDatos.mostrarToast = true;
            return misDatos;

        }
        misDatos.primero = misDatos.textoAbajo.toDouble()

        misDatos.mostrarToast = false;
        misDatos.operacion = "-"
        misDatos.textoArriba = misDatos.textoAbajo + "-";
        misDatos.textoAbajo = "0"

        return misDatos;

    }
    public fun multiplicar () : Datos{

        if(misDatos.textoAbajo == "operacion no valida"){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.primero = 0.0;
            misDatos.segundo = 0.0;
            misDatos.operacion = "";
            misDatos.mostrarToast = false;


            return misDatos;
        }

        if(misDatos.operacion != ""){

            misDatos.mostrarToast = true;
            return misDatos;

        }
        misDatos.primero = misDatos.textoAbajo.toDouble()

        misDatos.mostrarToast = false;
        misDatos.operacion = "*"

        misDatos.textoArriba = misDatos.textoAbajo + "*";
        misDatos.textoAbajo = "0"

        return misDatos;

    }
    public fun dividir () : Datos{

        if(misDatos.textoAbajo == "operacion no valida"){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.primero = 0.0;
            misDatos.segundo = 0.0;
            misDatos.operacion = "";
            misDatos.mostrarToast = false;


            return misDatos;
        }

        if(misDatos.operacion != ""){

            misDatos.mostrarToast = true;
            return misDatos;

        }
        misDatos.primero = misDatos.textoAbajo.toDouble()

        misDatos.mostrarToast = false;
        misDatos.operacion = "/"

        misDatos.textoArriba = misDatos.textoAbajo + "/";
        misDatos.textoAbajo = "0"

        return misDatos;

    }

    public fun clear () : Datos{

        misDatos.textoArriba = "0";
        misDatos.textoAbajo = "0";
        misDatos.primero = 0.0;
        misDatos.segundo = 0.0;
        misDatos.operacion = "";
        misDatos.mostrarToast = false;


        return misDatos;

    }

    public fun igual () : Datos{
        misDatos.mostrarToast = false;
        if(misDatos.textoAbajo == "operacion no valida"){
            misDatos.textoArriba = "0";
            misDatos.textoAbajo = "0";
            misDatos.primero = 0.0;
            misDatos.segundo = 0.0;
            misDatos.operacion = "";
            misDatos.mostrarToast = false;


            return misDatos;
        }

        misDatos.segundo = misDatos.textoAbajo.toDouble()

        misDatos.textoArriba += misDatos.textoAbajo + "="

        var resul1 = "";
        var resul = 0.0;

        if(misDatos.operacion == ""){
            resul1 = "operacion no valida"
        }else if(misDatos.operacion == "+"){
            resul = misDatos.primero + misDatos.segundo
        }else if(misDatos.operacion == "-"){
            resul = misDatos.primero - misDatos.segundo
        }else if(misDatos.operacion == "*"){
            resul = misDatos.primero * misDatos.segundo
        }else{
            resul = misDatos.primero / misDatos.segundo
        }


        if(resul1 == "operacion no valida"){
            misDatos.textoAbajo = resul1
        }else{
            misDatos.textoAbajo = resul.toString()
        }

        misDatos.operacion = "";
        misDatos.primero = 0.0;
        misDatos.segundo = 0.0;


        misDatos.borrar = true

        return misDatos;

    }




}