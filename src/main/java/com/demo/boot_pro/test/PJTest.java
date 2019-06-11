package com.demo.boot_pro.test;

import java.util.Scanner;

/**
 * Created by DIAN on 2019/6/4.
 */
public class PJTest {
    public static void main(String[] args) {
       /* System.out.println("===============2222222================");
        //2
        for (int i = 0; i < 7; i++) {
            if(i==1||i==2){
                for (int j = 0; j < 3; j++) {
                    if(j==2){
                        System.out.print("* ");
                    }else {
                        System.out.print("  ");
                    }

                }
            }else if(i==4||i==5){
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        System.out.print("* ");
                    }else {
                        System.out.print("  ");
                    }

                }
            }else{
                for (int j = 0; j < 3; j++) {
                        System.out.print("* ");
                }
            }
            System.out.println();
        }

        System.out.println("==============0000000=================");
        for(int i = 0; i < 7; i++){
            if(i==0||i==6){
                for (int j = 0; j < 3; j++) {
                    System.out.print("* ");
                }
            }else{
                for (int j = 0; j < 3; j++) {
                   if(j==0||j==2){
                       System.out.print("* ");
                   }else{
                       System.out.print("  ");
                   }
                }
            }
            System.out.println();
        }

        System.out.println("===============111111111================");
        for(int i = 0; i < 7; i++){
            if(i==1){
                for (int j = 0; j < 3; j++) {
                    if(j==2){
                        System.out.print("  ");
                    }else {
                        System.out.print("* ");
                    }
                }
            }else if(i==6){
                for (int j = 0; j < 3; j++) {
                    System.out.print("* ");
                }
            }else{
                for (int j = 0; j < 3; j++) {
                    if(j==1){
                        System.out.print("* ");
                    }else {
                        System.out.print("  ");
                    }

                }
            }
            System.out.println();
        }

        System.out.println("===============999999999================");
        for(int i = 0; i < 7; i++){
               if(i==0||i==3||i==6){
                   for (int j = 0; j < 3; j++) {
                       System.out.print("* ");
                   }
               }else  if(i==1||i==2){
                   for (int j = 0; j < 3; j++) {
                       if(j==0||j==2){
                           System.out.print("* ");
                       }else {
                           System.out.print("  ");
                       }

                   }
               }else{
                   for (int j = 0; j < 3; j++) {
                       if(j==2){
                           System.out.print("* ");
                       }else {
                           System.out.print("  ");
                       }

                   }
               }


            System.out.println();
        }*/


        for(int i = 0; i < 8; i++){
            if(i==0){
                for (int j = 0; j < 9; j++) {
                    if(j==0||j==1||j==4||j==7||j==8){
                        System.out.print("  ");
                    }else{
                        System.out.print("* ");
                    }

                }
            }else if(i==1||i==4){
                for (int j = 0; j < 9; j++) {
                    if(j == 0||j==8){
                        System.out.print("  ");
                    }else{
                        System.out.print("* ");
                    }

                }
            }else if(i==5){
                for (int j = 0; j < 9; j++) {
                    if(j==0||j==1||j==7||j==8){
                        System.out.print("  ");
                    }else{
                        System.out.print("* ");
                    }

                }

            } else if(i==6){
                for (int j = 0; j < 9; j++) {
                    if(j==3||j==4||j==5){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }

                }

            } else if(i==7){
                for (int j = 0; j < 9; j++) {
                    if(j==4){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }

                }

            }else{
                for (int j = 0; j < 9; j++) {
                    System.out.print("* ");
                }
            }


            System.out.println();
        }
    }



}
