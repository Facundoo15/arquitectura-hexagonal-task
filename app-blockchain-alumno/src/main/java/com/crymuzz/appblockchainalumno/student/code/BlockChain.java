package com.crymuzz.appblockchainalumno.student.code;

import com.crymuzz.appblockchainalumno.student.entity.Alumno;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlockChain {

    private List<Block> chain;

    public BlockChain() {
        this.chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }

    // Método para crear el bloque génesis
    private Block createGenesisBlock() {
        return new Block(0, new Alumno("00000000", "Genesis Block"), "0");
    }

    // Método para obtener el último bloque de la cadena
    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    // Método para añadir un nuevo bloque a la cadena
    public Block addBlock(Alumno data) {
        Block previousBlock = getLatestBlock();
        Block newBlock = new Block(chain.size(), data, previousBlock.getHash());
        return chain.add(newBlock) ? newBlock : null;
    }

    // Verificar la autenticidad de la cadena de bloques de alumnos:
    public boolean cadenaValida() {
        for (int i = 1; i < chain.size(); i++) {
            Block actual = chain.get(i); // Obtenemos el bloque actual de la chain
            Block previo = chain.get(i - 1); // También uno anterior
            // Validar el orden
            if(actual.getIndex() != previo.getIndex() + 1){
                return false;
            }

            // Comparar el hash del bloque actual con el hash calculado
            if (!actual.getHash().equals(actual.calculateHash())) {
                return false;
            }
            // Comparar el hash anterior del bloque actual con el hash del bloque anterior
            if (!actual.getPreviousHash().equals(previo.getHash())) {
                return false;
            }
        }
        return true;
    }


    public boolean updateChain(String hash, Alumno data) {
        Optional<Block> blockExist = chain.stream().filter(b -> b.getHash().equals(hash)).findFirst();
        if (blockExist.isPresent()) {
            Block block = blockExist.get();
            // Actualizar los datos del bloque
            block.setData(data);
            // Recalcular el hash del bloque actualizado
            block.setHash(block.calculateHash());
            // Recalcular el hash de todos los bloques siguientes en la cadena
            for (int i = block.getIndex() + 1; i < chain.size(); i++) {
                Block currentBlock = chain.get(i);
                currentBlock.setPreviousHash(chain.get(i - 1).getHash());
                currentBlock.setHash(currentBlock.calculateHash());
            }
            return true;
        }
        return false;
    }

    public List<Alumno> getDataList() {
        return this.chain.stream().filter(b -> b.getIndex() >= 1).map(Block::getData).toList();
    }

    public List<Block> getChain() {
        return this.chain;
    }

    public int getSizeData() {
        return chain.size();
    }

    public boolean existsHash(String hash) {
        return this.chain.stream().anyMatch(block -> block.getHash().equals(hash));
    }

    public void printBlockchain() {
        chain.forEach(System.out::println);
    }

}
