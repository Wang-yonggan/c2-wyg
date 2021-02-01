package interface_;

public class Star implements Universe {

    @Override
    public void doAnything() {
        System.out.println("star:接口函数的实例化");
    }
    public void shine(){
        System.out.println("star:星星一闪一闪亮晶晶");
    }

}
