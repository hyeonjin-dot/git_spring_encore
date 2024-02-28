package mvc.model.dao;

import mvc.domain.dto.RequestUserDto;
import mvc.domain.dto.ResponseUserDto;

import java.util.List;

// DML (insert, update, delete) - executeUpdate() : int
// select - executeQuery() : resultSet
public interface MvcDao {
    public void joinRow();
    public ResponseUserDto loginRow(RequestUserDto params);
    public void updateRow();
    public void deleteRow();

    public List<ResponseUserDto> selectRow();
}
