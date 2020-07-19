
package com.database;

//import com.music.MusicPlayer;
//import com.music.MainScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
//import static sun.misc.MessageUtils.where;


public class DBase {
    String username="root";
    String password="";
    String url="jdbc:mysql://localhost:3306/music";
    String driver="com.mysql.jdbc.Driver";
    Connection dbcon;
    //int a;
    //MusicPlayer counter=new MusicPlayer();
    //MainScreen counter=new MainScreen();
    /*void main()
    {
        
    }*/
    
    
    void Connect() throws SQLException
    {
        dbcon=DriverManager.getConnection(url,username,password);
        
    }
    void close() throws SQLException
    {
        dbcon.close();
    }
    public String getSongPath(int x) throws SQLException
    { 
        //a=counter.x;
        Connect();
        String sql="select path from mp3 where songid = "+x;//+"and language ="+s="and type ="+t;
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        rst.next();
        String path = rst.getString(1);
        
        
        System.out.println(path);
        
        return(path);
    }
    
    
    
}
