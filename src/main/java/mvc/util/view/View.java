package mvc.util.view;

// frontcontroller 인 dispatcherServlet이 화면의 분기방식과 응답 페이지 정보를 반환받을 수 있도록 view 생
public class View {
    private String responseJsp; // 응답 페이지 정보
    private boolean isFlag; //true->forward, false->redirect

    public View() {
    }

    public View(String responseJsp, boolean isFlag) {
        this.responseJsp = responseJsp;
        this.isFlag = isFlag;
    }

    public String getResponseJsp() {
        return responseJsp;
    }

    public void setResponseJsp(String responseJsp) {
        this.responseJsp = responseJsp;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    @Override
    public String toString() {
        return "View{" +
                "responseJsp='" + responseJsp + '\'' +
                ", isFlag=" + isFlag +
                '}';
    }
}
