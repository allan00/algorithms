package test.generic;

/**
 * Created by ping on 2015/9/9.
 */
public class Box<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
