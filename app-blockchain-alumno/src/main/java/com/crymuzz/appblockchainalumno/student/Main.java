package com.crymuzz.appblockchainalumno.student;

import com.crymuzz.appblockchainalumno.student.code.BlockChain;
import com.crymuzz.appblockchainalumno.student.entity.Alumno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        BlockChain blockchain = new BlockChain();
        // Añadir bloques con alumnos
        blockchain.addBlock(new Alumno("12345678", "Juan Perez"));
        blockchain.addBlock(new Alumno("12345678", "Favio Angulo"));
        blockchain.addBlock(new Alumno("87654321", "Maria Gomez"));
        blockchain.addBlock(new Alumno("11223344", "Carlos Ruiz"));

        // Imprimir la cadena de bloques
        blockchain.printBlockchain();

        // Verificar la validez de la cadena
        System.out.println("¿La cadena es válida?: " + (blockchain.cadenaValida() ? "Cadena válida" : "Cadena " +
                "Inválida"));
    }
}