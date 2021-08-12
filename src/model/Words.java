/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Minh Lưu
 */
public class Words implements Serializable{
    public String Word, Meaning, Transciption,TypeOfWord;
    public Words(){
        
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String Word) {
        this.Word = Word;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String Meaning) {
        this.Meaning = Meaning;
    }

    public String getTransciption() {
        return Transciption;
    }

    public void setTransciption(String Transciption) {
        this.Transciption = Transciption;
    }

    public String getTypeOfWord() {
        return TypeOfWord;
    }

    public void setTypeOfWord(String TypeOfWord) {
        this.TypeOfWord = TypeOfWord;
    }
}
