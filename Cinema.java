package com.mycompany.mavenproject1;
import javax.swing.JOptionPane;
public class Mavenproject1 {

    public static void main(String[] args) {
      int[][] cinema = new int[27][23];
      //27 linhas
      //23 lacunas
      for (int i = 0; i < cinema.length; i++)
      {
          for(int c = 0; c < cinema[i].length; c++){
              cinema[i][c] = (int)((Math.random())*2);
          }}
       int ingresso;
       String ent;
       String nome = JOptionPane.showInputDialog("Bem vindo ao cinema! Qual é o seu nome?");
       do{
       ent = JOptionPane.showInputDialog("Olá "+nome+"! Quantos ingressos você quer?");
       ingresso = Integer.parseInt(ent);
       if (ingresso > 23) JOptionPane.showMessageDialog(null, "Desculpe, o limite de ingressos é 23, escolha um número menor");
       else if(ingresso < 1) JOptionPane.showMessageDialog(null,"Para continuar você tem que pelo menos comprar 1 ingresso");
           }while(ingresso > 23 & ingresso < 1);
       int dec = 0;
       do{
       ent = JOptionPane.showInputDialog("Você gosta de sentar mais a frente ou atrás?\n"
               + "[1] Mais para frente\n"
               + "[2] Mais para trás");
       dec = Integer.parseInt(ent);
       } while(dec < 1 || dec > 2);
      int d = 0;
      int b = 0;
      int[] backup1 = new int[3];
      if (dec == 1) {
      for (int i = 0; i < cinema.length; i++)
      {
          for(int c = 0; c < cinema[i].length; c++)
          {
          if (cinema[i][c] == 0) {
              d++; 
              if(d == 1){
                  backup1[0] = i;
                  backup1[1] = c;
              }
          }
          if (cinema[i][c] == 1 & d >= 1) {
              d = 0;
              backup1[0] = 0;
              backup1[1] = 0;}
          if (d == ingresso){
              backup1[2] = c;
              b++;
              JOptionPane.showMessageDialog(null,"Fileira encontrada! a Fileira mais recomendada para você e seus parceiros que você irá levar é a "+ (backup1[0]+1)+ ", da cadeira "+(backup1[1]+1) + " até a "+ (backup1[2]+1));
              break;
          }
      }
      if (d == ingresso) break;
      }
      } else {
      for (int i = (cinema.length-1); i >= 0; i--)
      {
          for(int c = (cinema[i].length-1); c >= 0; c--)
          {
          if (cinema[i][c] == 0) {
              d++; 
              if(d == 1){
                  backup1[0] = i;
                  backup1[1] = c;
              }}
          if (cinema[i][c] == 1 & d >= 1) {
              d = 0;
              backup1[0] = 0;
              backup1[1] = 0;
          }
          if (d == ingresso){
              backup1[2] = c;
              b++;
              JOptionPane.showMessageDialog(null,"Fileira encontrada!\n"
                      + " a Fileira mais recomendada para você e seus parceiros que você irá levar é a "+ (backup1[0]+1)+ ",\n"
                              + " da cadeira "+(backup1[1]+1) + " até a "+ (backup1[2]+1));
              break;
          }
      }
      if (d == ingresso) break;
      }      
    }
      if(d < ingresso){
         JOptionPane.showMessageDialog(null,"Não dará para você sentar junto com seus conhecidos,\n"
                 + " não tem cadeiras disponíveis para vocês sentarem enfileirados"); 
      }
       for (int i = 0; i < cinema.length; i++)
      {
          System.out.print("\n" + (i+1) + "-");
          for(int c = 0; c < cinema[i].length; c++){
              System.out.print(cinema[i][c]+" ");
      }}
       
    }
}
