package org.example;

import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);



        String [] bebidas = {"Café Negro", "Café con leche", "Capuchino", "Chocolate Caliente", "Té", "Agua Pura"};
        int[] precioBebidas = {5,7,10,8,7,5};
        String [] comidas =  {"Hamburguesas","Hot Dog","Pan con Pollo","Pan con Jamon","Pizza (porcion)","Papas Fritas","Tacos","Shuco"};
        int[] precioComidas = {18,15,12,10,15,10,15,10};
        String[] postres = {"Pastel de Chocolate","Pastel tres leches","Flan","Helado","Cheesecake"};
        int [] precioPostres = {15,16,10,10,18};
        int opcionElegida;

        int cantidad=0;
        //int cantidadAcutal;

        ArrayList<String>  productosPedidos = new ArrayList<>();
        ArrayList<Integer> cantidadesPedidas = new ArrayList<>();
        ArrayList<Integer> preciosUnitarios = new ArrayList<>();

        boolean agregarMas = true;

        while (agregarMas){
            System.out.println("====== Menu Bebidas ======");
            for (int i =0;i<bebidas.length;i++){
                System.out.print(i+1+" "+bebidas[i]);
                for (int j=0;j<20-bebidas[i].length();j++){
                    System.out.print("-");
                }
                System.out.println(" Q "+precioBebidas[i]);

            }
            System.out.print("Ingrese el numero de la bebida a elegir: ");
            opcionElegida = sc.nextInt();
            opcionElegida--;
            if(opcionElegida<0 || opcionElegida> bebidas.length){
                System.out.println("Cantidad no valida intente de nuevo");
            }else {
                if (productosPedidos.isEmpty() || !productosPedidos.contains(bebidas[opcionElegida])){
                    //Si el producto no existe o bien el arraylist esta vacio se debe de agregar
                    productosPedidos.add(bebidas[opcionElegida]);
                    System.out.print("Ingrese cantidad: ");
                    cantidad=sc.nextInt();
                    cantidadesPedidas.add(cantidad);
                    preciosUnitarios.add(precioBebidas[opcionElegida]);

                }else { //si el producto ya existe enotnces se obtiene el indice del mismo y se actualiza unicamente el array cantidadesPedidas
                    System.out.print("Ingrese la cantidad a agregar: ");
                    cantidad = sc.nextInt();
                    int indiceProducto =productosPedidos.indexOf(bebidas[opcionElegida]);
                    cantidad = cantidadesPedidas.get(indiceProducto)+cantidad;
                    cantidadesPedidas.set(indiceProducto, cantidad);
                }

                System.out.println("Desea agregar mas bebidas: (escriba 1 para agregar mas)");

                opcionElegida = sc.nextInt();
                if (opcionElegida!=1){
                    agregarMas = false;
                }

            }


        }

        agregarMas=true;
        while (agregarMas){
            System.out.println("====== Menu Comidas ======");
            for (int i =0;i<comidas.length;i++){
                System.out.print(i+1+" "+comidas[i]);
                for (int j=0;j<20-comidas[i].length();j++){
                    System.out.print("-");
                }
                System.out.println(" Q "+precioComidas[i]);

            }
            System.out.print("Ingrese el numero de la comida a elegir: ");
            opcionElegida = sc.nextInt();
            opcionElegida--;
            if(opcionElegida<0 || opcionElegida>comidas.length-1){
                System.out.println("Cantidad no valida intente de nuevo");
            }else {
                if (productosPedidos.isEmpty() || !productosPedidos.contains(comidas[opcionElegida])){
                    //Si el producto no existe o bien el arraylist esta vacio se debe de agregar
                    productosPedidos.add(comidas[opcionElegida]);
                    System.out.print("Ingrese cantidad: ");
                    cantidad=sc.nextInt();
                    cantidadesPedidas.add(cantidad);

                    preciosUnitarios.add(precioComidas[opcionElegida]); // correccion la forma en al que se accede
                    // al precio unitario, si el array esta vacio o si el producto no existe solo se debe de acceder al precio

                }else { //si el producto ya existe enotnces se obtiene el indice del mismo y se actualiza unicamente el array cantidadesPedidas
                    System.out.print("Ingrese la cantidad a agregar: ");
                    cantidad = sc.nextInt();
                    int indiceProducto =productosPedidos.indexOf(comidas[opcionElegida]);
                    cantidad = cantidadesPedidas.get(indiceProducto)+cantidad;
                    cantidadesPedidas.set(indiceProducto, cantidad);
                }

                System.out.println("Desea agregar mas comidas: (escriba 1 para agregar mas");

                opcionElegida = sc.nextInt();
                if (opcionElegida!=1){
                    agregarMas = false;
                }

            }


        }
        System.out.println("Cant----descripcion---------precio Unitario-----Subtotal");


        //CICLO FOR QUE SE ENCARGA DE MOSTRAR EL PEDIDO FINAL
        for (int i =0;i<productosPedidos.size();i++){

            String productoAImprimir = productosPedidos.get(i);
            int cantidadAImprimir = cantidadesPedidas.get(i);
            int precioAImprimir = preciosUnitarios.get(i);

            int subtotal = cantidadAImprimir * precioAImprimir;
            String infoProducto="";

            if (cantidadAImprimir<10){
                infoProducto = " ";
            }
            infoProducto = infoProducto + cantidadAImprimir + " ------ "+productoAImprimir;
            String separador =" ";

            for (int j=0;j<24-productoAImprimir.length();j++){
                separador=separador + "-";
            }

            if (precioAImprimir<10){
                separador = separador +" Q  ";
            }else {
                separador = separador + " Q ";
            }

            infoProducto = infoProducto + separador+precioAImprimir + " -------- Q "+subtotal;

            System.out.println(infoProducto);

        }

    }
}
