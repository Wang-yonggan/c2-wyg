package Tasks;

public class Task2 {
    public static boolean is_hui(String str, boolean flag) {
        /**
         * @param: flag:去除一次的机会
         */
        char arr[] = str.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1])
                if (flag)
                    return is_hui(String.copyValueOf(str.toCharArray(), i + 1, len - i - 1), false) || is_hui(String.copyValueOf(str.toCharArray(), i, len - i - 2), false);
                else
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abbca";
        //对于abcca-->bcc--消去机会-->bc||cc-->(cc)true
        System.out.println(is_hui(str, true));
    }
}
