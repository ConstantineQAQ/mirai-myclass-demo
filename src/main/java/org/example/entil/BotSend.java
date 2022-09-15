package org.example.entil;

import net.mamoe.mirai.event.*;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.example.util.DateOfDay;

import java.util.Date;
import java.util.Timer;


public class BotSend extends SimpleListenerHost {
    Timer timer = new Timer();
    Date date = new Date();
    DateOfDay dateOfDay = new DateOfDay();
    DataBaseGet dataBaseGet = new DataBaseGet();


    @EventHandler
    public ListeningStatus ClassFriendMessageP(FriendMessageEvent event) throws Exception {
        getClassDetailPositive(event);

        return ListeningStatus.LISTENING;
    }


    @EventHandler
    public ListeningStatus ClassGroupMessage(GroupMessageEvent event) throws Exception {
        getClassDetilNegative(event);

        return ListeningStatus.LISTENING;
    }


/*    public void getClassDetailNegative() {
        int nowHour = DateUtil.getNowHour();
        if (nowHour == 8) {
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
    }*/

    //宿舍群发消息
    public void getClassDetilNegative(GroupMessageEvent event) throws Exception {
        //获取DateofDay对象以调用get方法
        DateOfDay dateOfDay = new DateOfDay();
        //获取Date对象
        Date date = new Date();
        //获取DataBaseGet对象，以便于调用获取课表的方法
        DataBaseGet dataBaseGet = new DataBaseGet();
        String s = event.getMessage().contentToString();
        if (s.matches("^(?:(?:课表)|(?:今日课表))[\\s]*$")) {
            event.getGroup().sendMessage(
                    "今日课表:\n" +
                            "\n" + DataBaseGet.getDayClass() +
                            "\n" + "--------------------------------" +
                            "\n" + "这周是本学期第" + DateOfDay.getWeekNumber(new Date()) + "周" +
                            "\n" + "--------------------------------" +
                            "\n" + "今天是" + DateOfDay.getWeek(new Date()) + "\n现在是" + DateOfDay.getTime(new Date())
            );
        }

        if (s.equals("明日课表")) {
            event.getGroup().sendMessage(
                    "明日课表:\n" +
                            "\n" + DataBaseGet.getDayClassTomorrow() +
                            "\n" + "--------------------------------" +
                            "\n" + "这周是本学期第" + DateOfDay.getWeekNumber_tomorrow() + "周" +
                            "\n" + "--------------------------------" +
                            "\n" + "明天是" + DateOfDay.getWeek_tomorrow()
            );
        }
    }

    //私人消息询问
    public void getClassDetailPositive(FriendMessageEvent event) throws Exception {
        //获取DateofDay对象以调用get方法
        DateOfDay dateOfDay = new DateOfDay();
        //获取Date对象
        Date date = new Date();
        //获取DataBaseGet对象，以便于调用获取课表的方法
        DataBaseGet dataBaseGet = new DataBaseGet();
        String s = event.getMessage().contentToString();
        if (s.matches("^(?:(?:课表)|(?:今日课表))[\\s]*$")) {
            event.getFriend().sendMessage(
                    "今日课表:\n" +
                            "\n" + DataBaseGet.getDayClass() +
                            "\n" + "--------------------------------" +
                            "\n" + "这周是本学期第" + DateOfDay.getWeekNumber(new Date()) + "周" +
                            "\n" + "--------------------------------" +
                            "\n" + "今天是" + DateOfDay.getWeek(new Date()) + "\n现在是" + DateOfDay.getTime(new Date())
            );
        }

        if (s.equals("明日课表")) {
            event.getFriend().sendMessage(
                    "明日课表:\n" +
                            "\n" + DataBaseGet.getDayClassTomorrow() +
                            "\n" + "--------------------------------" +
                            "\n" + "这周是本学期第" + DateOfDay.getWeekNumber_tomorrow() + "周" +
                            "\n" + "--------------------------------" +
                            "\n" + "明天是" + DateOfDay.getWeek_tomorrow()
            );
        }
    }

}
