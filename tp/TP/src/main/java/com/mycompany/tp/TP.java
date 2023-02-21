/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
/**
 *
 * @author id500182
 */
public class TP {

    public static void main(String[] args) {

    int n = 10;
    int[] sLgn = new int[]{5,4,4,4,3,3,4,4,4,4};
    int[] sCol = new int[]{2,2,7,7,3,2,3,4,4,5};
    int[] sDiaM = new int[]{0,1,1,2,1,3,2,3,3,7,4,3,1,2,1,2,2,0,1};
    int[] sDiaM2 = new int[]{4,3,1,2,1,2,2,0};  
    //int[] sDiaM2 = new int[]{0,2,2,1,2,1,3,4 };
    
    int[] sDiaD = new int[]{0,0,1,2,2,2,5,2,4,4,4,3,2,1,1,0,3,2,1};
     int[] sDiaD2 = new int[]{4,3,2,1,1,0,3,2};
    Model model = new Model(n + "-images problem");

    
    IntVar[][] vars = new IntVar[n][n];
    IntVar[][] vars2 = new IntVar[n][n];
    for (int i=0;i<n;i++)
        vars2[i]=vars[(n-1)-i];
    
    for(int q = 0; q < n; q++)
      for (int z=0;z<n;z++)
        {
            vars[q][z] = model.intVar("Q_"+q+""+z, 0, 1);
        }
    
    //pour les lignes
    for(int i  = 0; i < n; i++)
    {
        model.sum(vars[i],"=",sLgn[i]).post();  
    }

    
    pour les 
    for(int i=0;i<n; i++)
    {
       IntVar[] temporaire = new IntVar[n];
      
     for(int j=0;j<n;j++)
        {     
         temporaire[j]=vars[j][i];
        }
           model.sum(temporaire,"=",sCol[i]).post();   
    }
    
    
 model.arithm( vars[0][0],"=",sDiaM[0]).post();

 model.arithm( vars2[0][0],"=",sDiaD[0]).post();
      for (int z=1;z<n;z++)
        {
              IntVar[] diag10 = new IntVar[z+1];
              IntVar[] diag102 = new IntVar[z+1];
              for(int j=0;j<=z;j++)
              {
              diag10[j]=vars[j][z-j];
              diag102[j]=vars2[j][z-j];
              }
              model.sum(diag10,"=",sDiaM[z]).post(); 
              model.sum(diag102,"=",sDiaD[z]).post(); 
        }
       
       model.arithm( vars[n-1][n-1],"=",sDiaM[2*n-2]).post();
       model.arithm( vars2[n-1][n-1],"=",sDiaD[2*n-2]).post();
    
   
     
      for (int z=n-2;z>0;z--)
        {
            
              IntVar[] diag10 = new IntVar[n-1-z+1];
              IntVar[] diag102 = new IntVar[n-1-z+1];
              for(int j=0;j<(n-1-z+1);j++)
              { 
                
              diag10[j]=vars[z+j][n-1-j];
              diag102[j]=vars2[z+j][n-1-j];
              }
              model.sum(diag10,"=",sDiaM2[z-1]).post(); 
              model.sum(diag102,"=",sDiaD2[z-1]).post(); 
        }
    

    
    
    
    
     Solution solution = model.getSolver().findSolution();
     
     Solver s =  model.getSolver();
 
        if(solution != null)
        {
            System.out.println(solution.toString());

        }
    
  for(int q = 0; q < n; q++){
      for (int z=0;z<n;z++)
        {
            System.out.print(vars[q][z].getValue()+" ");
            
        }
   System.out.println();
  }
    }

    
    
    
    
}
