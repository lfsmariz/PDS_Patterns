package com.pds.proxy.onetoten;

import java.util.ArrayList;
import java.util.List;

public class ProxyOneToTen implements Proxy{

    private Proxy realService;
    private List<Integer> listAcess;
    private Integer countDenied;
    private Integer countRemote;

    public ProxyOneToTen() {
        realService = new OneToTen();
        listAcess = new ArrayList<>();
        countDenied = 0;
        countRemote = 0;
    }

    @Override
    public void accessControl(Integer id) {
        if (!id.equals(1)){
            System.out.println("Acesso negado");
            countDenied += 1;
        } else {
            realService.accessControl(id);
        }
    }

    @Override
    public void remoteService(Integer id) {
        System.out.println("chave de acesso de usuario: " + id);
        countRemote += 1;
        Integer AccessKey = 231312;
        realService.remoteService(AccessKey);
    }

    @Override
    public void registerService(Integer id) {
        System.out.println("Armazenando id...");
        listAcess.add(id);
        realService.registerService(id);
    }

    public void showRegister() {
        System.out.println("\n-------- LISTA DE ID'S DE USUARIOS REGISTRADOS PELO PROXY --------");
        System.out.println(listAcess.toString());
        System.out.println("\n-------- QUANTIDADE DE ACESSOS NEGADOS PELO PROXY --------");
        System.out.println(countDenied);
        System.out.println("\n-------- LISTA DE ACESSOS A SERVIÇO REMOTO REPARAMETRIZADO PELO PROXY --------");
        System.out.println(countRemote);

    }
}
