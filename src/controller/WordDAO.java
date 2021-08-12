/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Words;
/**
 *
 * @author Minh Lưu
 */
public class WordDAO {
    private Connection conn;
     public WordDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QLTuDien;"
                    + "username=sa;password= minhluu1501");
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
     public ArrayList<Words> selectQuery()
     {
         ArrayList<Words> list = new ArrayList<>();
         String sql = "Select * from tbl_dt";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while( rs.next())
           {
               Words s = new Words();
               s.setWord(rs.getString("Word"));
               s.setMeaning(rs.getString("Meaning"));
               s.setTransciption(rs.getString("Transciption"));
               s.setTypeOfWord(rs.getString("TypeOfWord"));
               list.add(s);
           }
         } catch (Exception e) {
             e.printStackTrace();
         }
        return list;
     }
       public boolean  addNewWord(Words w)
    {
        String sql = "INSERT INTO tbl_dt(Word,Meaning,Transciption,TypeOfWord)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,w.getWord());
              ps.setString(2,w.getMeaning());
                ps.setString(3,w.getTransciption());
                  ps.setString(4,w.getTypeOfWord());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
     
}
