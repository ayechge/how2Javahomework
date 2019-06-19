package stream;

/**
 * @Author: zhaoty
 * @Date: 2019/6/19 17:10
 * @Version 1.0
 */
import java.io.Serializable;

public class Hero implements Serializable {
    //表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public float hp;
}