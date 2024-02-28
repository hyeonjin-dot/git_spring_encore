package mvc.bean.factory;

import mvc.model.dao.MariaDao;
import mvc.model.dao.MvcDao;
import mvc.service.utill.MvcService;
import mvc.service.utill.MvcServiceImpl;
import mvc.user.ctrl.*;
import mvc.user.ctrl.util.Controller;
import org.example.IndexController;

import java.util.HashMap;
import java.util.Map;

/*
mvc 패턴에서 front-controller와 실제 controller 사이에서 동작한다.
 */
public class BeanFactory {
    private Map<String, Controller> map;
    private static BeanFactory instance ;
    private MvcService service;
    private MvcDao dao;
    // join.hanwha, login.hanwha, update.hanwha, delete.hanwha <-만 들어온다고 가정
    private BeanFactory(){
        dao = new MariaDao(); //
        service = new MvcServiceImpl(dao);
        map = new HashMap<String, Controller>();

        //index
       map.put("/index.hanwha", new IndexController(service));
       ////
        map.put("/join.hanwha", new JoinCtrl(service));
        map.put("/login.hanwha", new LoginCtrl(service));
        map.put("/update.hanwha", new UpdateCtrl(service));
        map.put("/delete.hanwha", new DeleteCtrl(service));
        //새로운 업무모듈
        map.put("/select.hanwha", new SelectCtrl(service));
    }

    public static BeanFactory getInstance(){
        if (instance == null)
            instance = new BeanFactory();
        return instance;
    }

    public Controller getCtrl(String clientPath){
        return map.get(clientPath);
    }
}
