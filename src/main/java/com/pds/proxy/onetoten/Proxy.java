package com.pds.proxy.onetoten;

public interface Proxy {
    void accessControl(Integer id);
    void remoteService(Integer id);
    void registerService(Integer id);
}
