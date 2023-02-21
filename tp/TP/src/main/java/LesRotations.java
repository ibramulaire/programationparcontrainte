/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author id500182
 */
public class LesRotations {
    
  public   Piece[] Mespieces;

    
    public LesRotations(Piece p) {
        
        Mespieces= new Piece[4];
        Mespieces[0]=p;
        Mespieces[1]=new Piece(p.g,p.h,p.d,p.b,p.num);
        
        Mespieces[2]=new Piece(p.b,p.g,p.h,p.d,p.num);
        Mespieces[3]=new Piece(p.d,p.b,p.g,p.h,p.num);
         
    }

     
    
    
    
    }
    
    
     
    
     
