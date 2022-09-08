package org.example.entil;

import kotlinx.coroutines.CoroutineScope;
import net.mamoe.mirai.event.*;
import net.mamoe.mirai.event.events.FriendEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.example.util.DateOfDay;

import java.util.Date;


public class BotSend extends SimpleListenerHost {
    Date date = new Date();
    DateOfDay dateOfDay = new DateOfDay();
    DataBaseGet dataBaseGet = new DataBaseGet();

    @EventHandler
    public ListeningStatus ClassFriendMessage(FriendMessageEvent event) throws Exception {
        getClassDetilNegativeP(event);
        getClassDetilPosstive(event);

        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus ClassGroupMessage(GroupMessageEvent event){

        getClassDetilNegativeG(event);
        return ListeningStatus.LISTENING;
    }

    //每天早上八点主动给我发送消息
    public void getClassDetilNegativeP(FriendEvent event) {
        if (dateOfDay.getTime(date) == "08:00") {
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

    //每天早上八点主动给宿舍群发消息
    public void getClassDetilNegativeG(GroupEvent event) {
        if (dateOfDay.getTime(date) == "08:00") {
            try {
                event.getBot().getGroup(167493031).sendMessage(dataBaseGet.getDayClass());
                event.getBot().getGroup(167493031).sendMessage("----------------------" +
                        "\n" + "这周是本学期第" + dateOfDay.getWeekNumber(date) + "周" +
                        "\n" + "----------------------" +
                        "\n" + dateOfDay.getWeek(date) + " " + dateOfDay.getTime(date));
            } catch (Exception e) {
                event.getBot().getFriend(357208746).sendMessage(e.getMessage());
            }
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
