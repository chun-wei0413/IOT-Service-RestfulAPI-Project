package com.example.Fproject.controller.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//用於表示找不到特定請求值的異常狀況，並提供相應的訊息回應。
public class RequestNotFoundException extends RuntimeException{
    private List<String> values;
    public String RequestValue(){
        String result = String.format("Request value not found, this method request %s",values.get(0));
        for(int i=1,l=values.size();i<l;i++)
            result = String.format("%s,%s",result,values.get(i));
        return result;
    }
    public RequestNotFoundException(String... values){
        this.values = new ArrayList<>();
        for(String value:values)
            this.values.add(value);
    }
}
