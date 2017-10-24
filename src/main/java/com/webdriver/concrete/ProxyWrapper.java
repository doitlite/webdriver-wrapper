package com.webdriver.concrete;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyWrapper {

    public static final Logger logger = LoggerFactory.getLogger(ProxyWrapper.class);
    private BrowserMobProxy proxy;
    private int proxyPort = 4444;

    public ProxyWrapper() {
        initProxy();
    }

    private void initProxy() {
        if (proxy != null && ((BrowserMobProxyServer) proxy).isStopped()) {
            proxy.abort();
        }
        proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
    }

    public void startProxy(){
        logger.info("Starting proxy");
        proxy.start(proxyPort);
    }

    public void stopProxy(){
        logger.info("Stopping proxy");
        if (proxy != null && ! ((BrowserMobProxyServer) proxy).isStopped()) {
            proxy.stop();
        }
    }

    public Proxy getSeleniumProxy(){
        return ClientUtil.createSeleniumProxy(proxy);
    }

    public BrowserMobProxy getProxy() {
        return proxy;
    }
}
