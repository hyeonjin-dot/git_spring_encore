package mvc.service.utill;

import mvc.domain.dto.RequestUserDto;
import mvc.domain.dto.ResponseUserDto;

import java.util.List;

public interface MvcService {
    public void join();
    public ResponseUserDto login(RequestUserDto params);
    public void update();
    public void delete();
    public List<ResponseUserDto> select();
}
