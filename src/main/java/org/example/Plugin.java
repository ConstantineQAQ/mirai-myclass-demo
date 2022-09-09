package org.example;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import org.example.entil.BotSend;

import java.util.Timer;
import java.util.TimerTask;

public final class Plugin extends JavaPlugin {
    Timer timer = new Timer();
    BotSend botSend = new BotSend();
    public static final Plugin INSTANCE = new Plugin();



    private Plugin() {
        super(new JvmPluginDescriptionBuilder("org.example.plugin", "1.0-SNAPSHOT")
                .name("myclass")
                .author("ConstantineQAQ")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("兔兔的课表插件启动了捏!");
        GlobalEventChannel.INSTANCE.registerListenerHost(new BotSend());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                botSend.getClassDetilNegative();
                this.cancel();
            }
        },3000);
    }
}