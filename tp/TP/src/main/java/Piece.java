
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author id500182
 */
public class Piece {
 public int num;
 public    int h;
 public    int d;
 public   int b;
 public  int g;
 
 public Piece(int haut, int droit, int bas  , int gauche,int num) {      
       this.h=haut;
       this.d=droit;
       this.b=bas;
       this.g=gauche;  
       this.num=num;
    }
}
