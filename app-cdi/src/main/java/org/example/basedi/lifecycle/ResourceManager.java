package org.example.basedi.lifecycle;

import io.quarkus.logging.Log;

public class ResourceManager {

    public ResourceManager () {
        Log.info("create instance, " + this.getClass().getSimpleName());
    }

    /**
     * 假设再次方法中打开资源，如网络、文件、数据库等
     */
    public void open() {
        Log.info("open resource here");
    }

    /**
     * 假设在此方法中关闭所有已打开的资源
     */
    public void closeAll() {
        Log.info("close all resource here");
    }
}
