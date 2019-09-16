package array;

/**
 * Created By poplar on 2019/9/16
 * 自定义实现一个List的添加功能
 */
public class ArrayList {
    Object[] objects = new Object[10];

    int index = 0;

    /*添加元素*/
    public void add(Object object) {

        if (index == objects.length) {
            //扩容
            Object[] newObject = new Object[objects.length + 15];
            System.arraycopy(objects, 0, newObject, 0, objects.length);
            objects = newObject;
        }
        objects[index] = object;
        index++;
    }

    //获取数组的长度
    public int getSize() {
        return index;
    }

    //测试
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 105; i++) {
            arrayList.add(new Object());
        }
        System.out.println(arrayList.getSize());
    }
}
