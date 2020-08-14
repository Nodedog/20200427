
import java.util.Arrays;

public class TestDemo {




    //向下调整

    //堆是一棵完全二叉树，通常使用数组表示
    //数组中哪些元素是堆[0,size)
    //index表示从指定下标出发进行调整
    public static void shiftDown(int[] array ,int size ,int index ){
        //从父节点下标出发
        //parent和child都是对应的下标
        int parent = index;
        //找左子树下标
        int child = 2 * parent + 1;
        //判断child下标是否超出size
        while (child < size){
            //判断右子树下标是否超出size并且 判断右子树对应的元素是否比左子树大，哪个大就赋值给child
            if (child + 1 < size && array[child + 1] > array[child]){
                child = child +1;
            }
            //经过if条件语句 不知道child指向的左右哪棵子树，但指向的肯定是左右子树中值较大的那个


            //下面判断child位置的元素与parent位置的元素哪个大
            //如果不符合大堆的要求（child位置的元素>parent位置的元素），交换两者的值
            if (array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                //否则说明已经符合堆的要求则break
                break;
            }
            //下次循环之前需要更新parent和child 的值
            parent = child;
            child = 2 * parent + 1;
        }
    }


    //基于向下调整建堆  必须从后往前遍历
    public static void creatHeap(int[] array , int size){
        //从后往前遍历，从最后一个非叶子节出发，依次进行向下调整
        //size-1得到最后一个元素的下标
        //再-1/2找到最后一个节点的父节点下标
        for (int i = (size - 1 - 1)/2; i >= 0; i--) {
            shiftDown(array,size,i);
        }
    }


    //向上调整
    private static void shiftUp(int[] array, int size ,int index){
        int child = index;
        int parent = (child-1)/2;
        //循环中的条件 child > 0 是保证child不为根节点
        while( child > 0){
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else{
                break;
            }
            child = parent;
            parent = (child-1)/2;
        }
    }

    //基于向上调整建堆 必须从前往后遍历
    public static void creatHeap2(int[] array , int size){
        for (int i = 0; i < size; i++) {
            shiftUp(array,size,i);
        }
    }



    public static void main(String[] args) {
        int[] array = {8,7,12,65,21,4,19};
        creatHeap2(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
