package mvc.domain.dto;

public class RequestUserDto {
    private String id;
    private String pwd;

    public RequestUserDto() {
    }

    public RequestUserDto(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
