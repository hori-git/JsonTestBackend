package bean;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonBean {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    //@JsonProperty("datas")
    //private List<String> datas;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDatas(List<String> datas) {
        //this.datas = datas;
    }
}