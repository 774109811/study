package com.jt.common.util;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 定期清理无效的http连接
 */
public class IdleConnectionEvictor extends Thread {

    private final HttpClientConnectionManager connMgr;
    //等待的时长
    private Integer waitTime;
    //volatile  通知所有线程如果修改实时更新
    //关闭连接
    private volatile boolean shutdown;//默认false

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr,Integer waitTime) {
        this.connMgr = connMgr;
        this.waitTime = waitTime;
        this.start();
    }

    @Override
    public void run() {
        try {//当时true
            while (!shutdown) {
                synchronized (this) {
                    //等待1分钟
                	wait(waitTime);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    /**
     * 销毁释放资源
     * 执行关闭连接的方法
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();//通知关闭连接,wait直接执行
        }
    }
}
