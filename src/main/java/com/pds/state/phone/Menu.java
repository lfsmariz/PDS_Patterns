package com.pds.state.phone;

import java.util.Scanner;

public class Menu {

    public Menu(){

        ContextPhone ctxt = new ContextPhone();

        System.out.println("Realize uma das ações abaixo\n\n");
        Scanner sc = new Scanner(System.in);
        Integer opt = 1000;
        while(!opt.equals(0)){
            System.out.println(optionsMenu());
            opt = sc.nextInt();
            switch (opt){
                case 1:
                    System.out.println(ctxt.getState().cancelCall());
                    break;
                case 2:
                    System.out.println(ctxt.getState().acceptCall());
                    break;
                case 3:
                    System.out.println(ctxt.getState().createCall());
                    break;
                case 4:
                    System.out.println(ctxt.getState().changeCall());
                    break;
                case 5:
                    System.out.println(ctxt.getState().waitingCall());
                    break;
                case 6:
                    System.out.println(ctxt.getState().returnToCall());
                    break;
                default:
                    System.out.println("Insira um novo valor");
            }

        }

        sc.close();
    }

    private String optionsMenu() {
      return  "1 ->  Cancelar chamada\n" +
              "2 ->  Atender chamada\n" +
              "3 ->  Fazer chamada\n" +
              "4 ->  Alternar chamada\n" +
              "5 ->  Colocar chamada em espera\n" +
              "6 ->  Retornar para chamada\n\n\n" +
              "0 ->  Encerrar aplicação";
    }
}
