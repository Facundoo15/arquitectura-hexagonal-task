package com.crymuzz.appblockchainalumno.student.code;

import com.crymuzz.appblockchainalumno.student.entity.Alumno;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class Block {

    private int index;
    private long timestamp;
    private Alumno data;
    private String previousHash;
    private String hash;

    public Block(int index, Alumno data, String previousHash) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return ShaUtil.applySha256(index + Long.toString(timestamp) + data + previousHash);
    }



}