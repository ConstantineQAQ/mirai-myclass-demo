package org.example;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import org.example.entil.BotSend;
import org.example.entil.DataBaseGet;
import org.example.util.DateOfDay;
import org.example.util.LoggerManager;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public final class PluginMain extends JavaPlugin {

    Date date = new Date();
    DateOfDay dateOfDay = new DateOfDay();
    DataBaseGet dataBaseGet = new DataBaseGet();

    private static boolean pluginLoaded = false;
    private static Bot CURRENT_BOT = null;

    public static Bot getCurrentBot() {
        return CURRENT_BOT;
    }

    public static PluginMain getInstance() {
        return INSTANCE;
    }

    public static boolean isPluginLoaded() {
        return pluginLoaded;
    }

    Timer timer = new Timer();
    BotSend botSend = new BotSend();
    public static final PluginMain INSTANCE = new PluginMain();


    private PluginMain() {
        super(new JvmPluginDescriptionBuilder("org.example.plugin", "1.0-SNAPSHOT")
                .name("myclass")
                .author("ConstantineQAQ")
                .build());
    }

    @Override
    public void onEnable() {
        LoggerManager.logDebug("兔兔课表---->启动", true);
        GlobalEventChannel.INSTANCE.registerListenerHost(new BotSend());
    }
}