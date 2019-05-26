package other;

/**
 * Created by longyun on 2018/10/20.
 */
public class Test {
    public static void main(String[] args) {
        int n = 5;
        //int a = (int)((-1 + Math.sqrt(8.0 * n + 1)) / 2);

        long start = System.currentTimeMillis();
        int mid = (1 + 2126753390) / 2; //这个耗时比较多
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end - start));

        double a = Math.abs(-1.1);
        System.out.println(a);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxsofar = nums[0];//全局最大---最后的返回值

        //记录中间过程值：局部最大 、 局部最小（负负得正）
        int maxherepre = nums[0];//局部最大
        int minherepre = nums[0];//局部最小

        int maxhere;//当前最大
        int minhere;//当前最小

        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max( Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);//更新局部最大
            minhere = Math.min( Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);//更新局部最小
            maxsofar = Math.max(maxhere, maxsofar);

            maxherepre = maxhere;//局部最大
            minherepre = minhere;//局部最小
        }
        return maxsofar;
    }

}
