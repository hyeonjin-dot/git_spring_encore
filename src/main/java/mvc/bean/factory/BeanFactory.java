package mvc.bean.factory;

import mvc.service.utill.MvcService;
import mvc.service.utill.MvcServiceImpl;
import mvc.user.ctrl.DeleteCtrl;
import mvc.user.ctrl.JoinCtrl;
import mvc.user.ctrl.LoginCtrl;
import mvc.user.ctrl.UpdateCtrl;
import mvc.user.ctrl.util.Controller;

import java.util.HashMap;
import java.util.Map;

/*
mvc 패턴에서 front-controller와 실제 controller 사이에서 동작한다.
 */
public class BeanFactory {
    private Map<String, Controller> map;
    private static BeanFactory instance ;
    private MvcService service;
    // join.hanwha, login.hanwha, update.hanwha, delete.hanwha <-만 들어온다고 가정
    private BeanFactory(){
        service = new MvcServiceImpl();
        map = new HashMap<String, Controller>();
        map.put("/join.hanwha", new JoinCtrl(service));
        map.put("/login.hanwha", new LoginCtrl(service));
        map.put("/update.hanwha", new UpdateCtrl(service));
        map.put("/delete.hanwha", new DeleteCtrl(service));
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
