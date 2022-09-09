package org.example.entil;

import kotlinx.coroutines.CoroutineScope;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.*;
import net.mamoe.mirai.event.events.FriendEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.example.util.DateOfDay;
import org.example.util.DateUtil;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.Objects;
import java.util.Timer;


public class BotSend extends SimpleListenerHost {
    Timer timer = new Timer();
    Date date = new Date();
    DateOfDay dateOfDay = new DateOfDay();
    DataBaseGet dataBaseGet = new DataBaseGet();



    @EventHandler
    public ListeningStatus ClassFriendMessageP(FriendMessageEvent event) throws Exception {
        getClassDetilPosstive(event);

        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus ClassGroupMessage(GroupMessageEvent event) throws Exception {

        getClassDetilNegativeG(event);
        return ListeningStatus.LISTENING;
    }

    public void getClassDetilNegative(){
        int nowHour = DateUtil.getNowHour();
        if(nowHour == 8) {
            Long qqId = null;
            Long GroupId = null;
            try {
                qqId = 357208746L;
                GroupId = 167493031L;
                Bot.getInstances().get(0).getFriend(qqId).sendMessage(dataBaseGet.getDayClass());
                Bot.getInstances().get(0).getFriend(qqId).sendMessage("----------------------" +
                        "\n" + "这周是本学期第" + dateOfDay.getWeekNumber(date) + "周" +
                        "\n" + "----------------------" +
                        "\n" + dateOfDay.getWeek(date) + " " + dateOfDay.getTime(date));
                Bot.getInstances().get(0).getFriend(GroupId).sendMessage(dataBaseGet.getDayClass());
                Bot.getInstances().get(0).getFriend(GroupId).sendMessage("----------------------" +
                        "\n" + "这周是本学期第" + dateOfDay.getWeekNumber(date) + "周" +
                        "\n" + "----------------------" +
                        "\n" + dateOfDay.getWeek(date) + " " + dateOfDay.getTime(date));
            } catch (Exception e) {
                Bot.getInstances().get(0).getFriend(qqId).sendMessage(e.getMessage());
            }
        }
    }

/*    //每天早上八点主动给我发送消息
    public void getClassDetilNegativeP(FriendEvent event) {
        int nowHour = DateUtil.getNowHour();
        if (nowHour == 14) {
            int nowMinute = DateUtil.getNowMinute();
            if(nowMinute == 56){
                try {
                    event.getBot().getFriend(357208746).sendMessage(dataBaseGet.getDayClass());
                    event.getBot().getFriend(357208746).sendMessage("----------------------" +
                            "\n" + "这周是本学期第" + dateOfDay.getWeekNumber(date) + "周" +
                            "\n" + "----------------------" +
                            "\n" + dateOfDay.getWeek(date) + " " + dateOfDay.getTime(date));
                } catch (Exception e) {
                    event.getBot().getFriend(357208746).sendMessage(e.getMessage());
                }
            }
        }
    }*/

    //每天早上八点主动给宿舍群发消息
    public void getClassDetilNegativeG(GroupMessageEvent event) throws Exception {
        //获取DateofDay对象以调用get方法
        DateOfDay dateOfDay = new DateOfDay();
        //获取Date对象
        Date date = new Date();
        //获取DataBaseGet对象，以便于调用获取课表的方法
        DataBaseGet dataBaseGet = new DataBaseGet();
        String s = event.getMessage().contentToString();
        if (s.matches("^(?:(?:课表)|(?:今日课表))[\\s]*$"))
        {
            event.getGroup().sendMessage(dataBaseGet.getDayClass());
            event.getGroup().sendMessage("----------------------" +
                    "\n" + "这周是本学期第" + dateOfDay.getWeekNumber(date) + "周" +
                    "\n" + "----------------------" +
                    "\n" + dateOfDay.getWeek(date) + " " + dateOfDay.getTime(date));
        }
    }

    public void getClassDetilPosstive(FriendMessageEvent event) throws Exception {
        //获取DateofDay对象以调用get方法
        DateOfDay dateOfDay = new DateOfDay();
        //获取Date对象
        Date date = new Date();
        //获取DataBaseGet对象，以便于调用获取课表的方法
        DataBaseGet dataBaseGet = new DataBaseGet();
        String s = event.getMessage().contentToString();
        if (s.matches("^(?:(?:课表)|(?:今日课表))[\\s]*$"))
        {
            event.getFriend().sendMessage(dataBaseGet.getDayClass());
            event.getFriend().sendMessage("----------------------" +
                    "\n" + "这周是本学期第" + dateOfDay.getWeekNumber(date) + "周" +
                    "\n" + "----------------------" +
                    "\n" + dateOfDay.getWeek(date) + " " + dateOfDay.getTime(date));
        }
    }
}
