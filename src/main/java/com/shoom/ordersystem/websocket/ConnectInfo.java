package com.shoom.ordersystem.websocket;

import java.net.InetSocketAddress;

/**
 * 链接信息实体对象
 */
public class ConnectInfo {

    private String userId;
    private InetSocketAddress userIp;
    private WebSocketServer webSocketServer;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InetSocketAddress getUserIp() {
        return userIp;
    }

    public void setUserIp(InetSocketAddress userIp) {
        this.userIp = userIp;
    }

    public WebSocketServer getWebSocketServer() {
        return webSocketServer;
    }

    public void setWebSocketServer(WebSocketServer webSocketServer) {
        this.webSocketServer = webSocketServer;
    }
}
