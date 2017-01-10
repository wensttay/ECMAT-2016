package io.github.herocode.ecmat.websocket;

import com.google.gson.Gson;
import io.github.herocode.ecmat.interfaces.ShortCourseBusiness;
import io.github.herocode.ecmat.model.ShortCourseBusinessImpl;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.Session;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
//@WebListener
//@ServerEndpoint(value = "/ShortCourseWebServlet")
public class ShortCourseWebServlet implements ServletContextListener {

    private static final Set<Session> usersWs = new CopyOnWriteArraySet<>();
    private static Timer timer = null;

//    @OnError
    public void onError(Throwable throwable) {
    }

//    @OnOpen
    public void onConnect(Session session) {
        System.out.println("usuario conectado");

        usersWs.add(session);
    }

//    @OnClose
    public void onDisconnect(Session session) {

        usersWs.remove(session);
    }

    private void sendMessage(String message) {

        Iterator<Session> usersWsIterator = usersWs.iterator();

        Session userWs;

        while (usersWsIterator.hasNext()) {

            userWs = usersWsIterator.next();

            try {
                userWs.getBasicRemote().sendText(message);
            } catch (IOException ex) {

                usersWsIterator.remove();
                try {
                    userWs.close();
                } catch (IOException ex2) {
                }

            } catch (Exception ex3) {
            }

        }

    }

//    @OnMessage
    public void echoTextMessage(Session session, String msg, boolean last) {

        sendMessage(msg);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        if (timer == null) {

            System.out.println("iniciado task");

            Timer timer = new Timer();

            TimerTask timerTask = new ShortCourseScheduler();
            timer.scheduleAtFixedRate(timerTask, 2000, 2000);

        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\"T-A-S-K--D-E-S-T-R-O-Y-E-D\"");
    }

    private class ShortCourseScheduler extends TimerTask {

        private final ShortCourseBusiness shortCourseBusiness;
        private final Gson gSon;
        private Map<Integer, Integer> mapCurrentEnrollment;

        public ShortCourseScheduler() {

            shortCourseBusiness = ShortCourseBusinessImpl.getInstance();
            gSon = new Gson();
        }

        @Override
        public void run() {

//            if (usersWs.size() > 0) {
//                mapCurrentEnrollment = shortCourseBusiness.getShortcoursersCurrentEnrollments();
            sendMessage("olá :D");
//            }

        }

    }

}
