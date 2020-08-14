

/*
*
*
*                               优先级队列
*
*
*
* */

public class TestDeMO2 {

    private int[] array = new int[100];
    private int size = 0;//[0,size)表示有效元素


    //入队列    O（logN）
    public void offer(int x) {
        //1.把x放到数组末尾
        array[size] = x;
        size++;
        //2.把x进行向上调整
        //array表示用来承载堆的数组
        //size表示数组的有效元素的个数
        //size-1表示从哪个位置进行向上调整
        shiftUp(array, size, size - 1);
    }


    private static void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        //循环中的条件 child > 0 是保证child不为根节点
        while (child > 0) {
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }


    //出队列    O（logN）
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[0];
        //1.将最后一个元素复制给0号元素
        array[0] = array[size - 1];
        //2.删除最后一个元素
        size--;
        //3.从0号下标开始进行向下调整
        shiftDown(array, size, 0);
        return ret;
    }


    public static void shiftDown(int[] array, int size, int index) {
        //从父节点下标出发
        //parent和child都是对应的下标
        int parent = index;
        //找左子树下标
        int child = 2 * parent + 1;
        //判断child下标是否超出size
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }


    //取队首元素   O（1）
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }



    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        TestDeMO2 queue = new TestDeMO2();
        queue.offer(1);
        queue.offer(50);
        queue.offer(3);
        queue.offer(44);
        queue.offer(61);
        queue.offer(20);
        queue.offer(7);
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }
}
