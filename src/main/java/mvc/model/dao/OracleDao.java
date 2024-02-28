package mvc.model.dao;

import mvc.domain.dto.RequestUserDto;
import mvc.domain.dto.ResponseUserDto;

import java.util.List;

public class OracleDao implements MvcDao{
    @Override
    public void joinRow() {
        System.out.println("OracleDB joinRow");
    }

    @Override
    public ResponseUserDto loginRow(RequestUserDto params) {
        System.out.println("OracleDB loginRow");
        return null;
    }

    @Override
    public void updateRow() {
        System.out.println("OracleDB updateRow");
    }

    @Override
    public void deleteRow() {
        System.out.println("OracleDB deleteRow");
    }

    @Override
    public List<ResponseUserDto> selectRow() {
        return null;
    }
}
