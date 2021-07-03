package com.pds.proxy;

import com.pds.proxy.onetoten.Proxy;
import com.pds.proxy.onetoten.ProxyOneToTen;

public class Main {
    public static void main(String[] args) {
        //Realizando instanciacao para interface.
        Proxy proxyTest = new ProxyOneToTen();

        //Exibição do proxy com controle de acesso
        System.out.println("--------Acesso negado pelo proxy--------");
        proxyTest.accessControl(2);
        proxyTest.accessControl(3);
        proxyTest.accessControl(4);

        System.out.println("--------Acesso permitido pelo proxy--------");
        proxyTest.accessControl(1);

        System.out.println("\n####################################################\n");

        //Utilização do proxy para acesso a serviço remoto
        System.out.println("--------Acesso remoto gerenciado pelo proxy--------");
        proxyTest.remoteService(11111);
        proxyTest.remoteService(22222);
        proxyTest.remoteService(33333);

        System.out.println("\n####################################################\n");

        //Utilização do proxy para controle do registro de entradas
        proxyTest.registerService(10);
        proxyTest.registerService(20);
        proxyTest.registerService(30);
        proxyTest.registerService(40);

        System.out.println("Com a utilização do proxy pudemos ter:");
        //Casting para utilização de métodos exclusivos da classe proxy
        ProxyOneToTen pureProxy = (ProxyOneToTen) proxyTest;
        pureProxy.showRegister();

    }
}
