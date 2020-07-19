
package com.music;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class MusicPlayer {
    FileInputStream fis;
    BufferedInputStream bis;
    public Player player; 
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;
    

    
    public void stop()
    {
        if(player!=null)
        {
            player.close();
            songTotalLength=0;
            pauseLocation=0;
            
            
        }
    }
     public void pause()
    {
        if(player!=null)
        {
            try {
                pauseLocation=fis.available();
                player.close();
            } catch (IOException ex) {
               
               
            }
            
        }
    }
      public void play(String path) //throws FileNotFoundException
    {
        try {
            fis=new FileInputStream(path);
        bis=new BufferedInputStream(fis);
        
        player=new Player(bis);
        songTotalLength=fis.available();
        
       
       fileLocation= path + "";
        } catch (FileNotFoundException | JavaLayerException ex) {
            
        } catch (IOException ex) {
            
        }
        
        
            new Thread()
            {
                @Override
                public void run()
                {
                    try {
                        player.play();
                    } catch (JavaLayerException ex1) {
                       
                    
                    }
                    
                }
            }.start();
        }
        
        
    
    public void resume() //throws FileNotFoundException
    {
        try {
            fis=new FileInputStream(fileLocation);
        bis=new BufferedInputStream(fis);
        
        player=new Player(bis);
fis.skip(songTotalLength-pauseLocation);
        } catch (FileNotFoundException | JavaLayerException ex) {
            
        } catch (IOException ex) {
            
        }
        
        
            new Thread()
            {
                @Override
                public void run()
                {
                    try {
                        player.play();
                    } catch (JavaLayerException ex1) {
                       
                    
                    }
                    
                }
            }.start();
        }
    
 
            
    public void next(String path)
    {
        
        try {
            fis=new FileInputStream(path);
        bis=new BufferedInputStream(fis);
        
        player=new Player(bis);
        songTotalLength=fis.available();
        
       
       fileLocation= path + "";
        } catch (FileNotFoundException | JavaLayerException ex) {
            
        } catch (IOException ex) {
            
        }
        
        
            new Thread()
            {
                @Override
                public void run()
                {
                    try {
                        player.play();
                    } catch (JavaLayerException ex1) {
                       
                    
                    }
                    
                }
            }.start();
    }
     public void previous(String path)
    {
        try {
            fis=new FileInputStream(path);
        bis=new BufferedInputStream(fis);
        
        player=new Player(bis);
        songTotalLength=fis.available();
        
       
       fileLocation= path + "";
        } catch (FileNotFoundException | JavaLayerException ex) {
            
        } catch (IOException ex) {
            
        }
        
        
            new Thread()
            {
                @Override
                public void run()
                {
                    try {
                        player.play();
                    } catch (JavaLayerException ex1) {
                       
                    
                    }
                    
                }
            }.start();
    }
        
        
   



    
}
