package com.pds.proxy.onetoten;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OneToTen implements Proxy{

    @Override
    public void accessControl(Integer id) {
        System.out.println("Acesso permitido ao usuario id: " + id);
    }

    @Override
    public void remoteService(Integer id) {
        System.out.println("A chave de acesso realmente utilizada foi: " + id);
    }

    @Override
    public void registerService(Integer id) {
        System.out.println("Acesso concluido com id: " + id);
    }
}
