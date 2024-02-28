package mvc.service.utill;

import mvc.domain.dto.RequestUserDto;
import mvc.domain.dto.ResponseUserDto;
import mvc.model.dao.MariaDao;
import mvc.model.dao.MvcDao;

import java.util.List;

//ctrl에 속하는 impl
public class MvcServiceImpl implements MvcService{
    //dao
    private MvcDao dao;

    public MvcServiceImpl(){
    }
    public MvcServiceImpl(MvcDao dao){
        this.dao = dao;
    }

    public void join(){
        System.out.println("join service");
        dao.joinRow();
    }
    public ResponseUserDto login(RequestUserDto params){
        System.out.println("login service");
        return dao.loginRow(params);
    }
    public void update(){
        System.out.println("update service");
        dao.updateRow();
    }
    public void delete(){
        System.out.println("delete service");
        dao.deleteRow();
    }

    @Override
    public List<ResponseUserDto> select() {
        System.out.println("service select()");
        return dao.selectRow();
    }
}
