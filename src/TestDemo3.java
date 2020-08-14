import java.util.Comparator;
import java.util.PriorityQueue;




/*
*
*           Java标准库中已经提供了一个现成的优先队列
*  标准库中的优先队列默认是一个小堆，每次出队列的元素都是最小值
* 相当于保准库中 自动定义了"值越小，优先级越高"这样的规则
* 也可以有办法修改这个规则，手动定义一个比较器对象，借助比较器对象来描述比较规则
*
* */
public class TestDemo3 {
   /* static class MyComp implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            //如果认为o1的优先级比o2高，先出o1，让compare返回<0的整数
            //反之返回一个>0的整数
            //如果认为o1和o2一样高，则返回0
            return o2 - o1;
            //o2-o1这里控制出队列的优先级  不需要记o2-o1是从小到大还是从大到小
            //如果需要从小到大 那么先随便写一个o2-o1试一下 看结果如果不是则反过来
        }
    }*/


    public static void main(String[] args) {
        //可以不在main方法外创建一个类实现Comparator接口
        //在main里创建一个匿名内部类
        //此处不知道类名是啥 但是可以知道这个类实现了Comparator接口
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        queue.offer(2);
        queue.offer(52);
        queue.offer(64);
        queue.offer(21);
        queue.offer(9);
        queue.offer(38);

        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }

}
