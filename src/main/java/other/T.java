package other;

/**
 * Created by longyun on 2018/11/12.
 */
public class T {

    public static int FindNum(int nArr[],int nLen)
    {
        int nPos = 0;
        int nCandid = nArr[0]; //候选人
        int nMax = nArr[0]; //最大值
        boolean bIsExist = true; //是否存在

        for (int i = 1; i < nLen;i++) {
            //候选有效
            if (bIsExist){
                //候选失效
                if (nCandid > nArr[i]) {
                    bIsExist = false;
                } else {
                    nMax = nArr[i];
                }
            }
            //候选失效
            else {
                //重新找到候选
                if (nArr[i] >= nMax) {
                    bIsExist = true;
                    nCandid = nArr[i];
                    nMax = nArr[i];
                    nPos = i;
                }
            }
        }
        return bIsExist ? nPos : -1;
    }

    public static void main(String[] args) {
        int[] nArr = new int[]{1, 2, 3, 1, 2, 0, 5} ;
        int nPos = FindNum(nArr, nArr.length);
        if (nPos == -1) {
            System.out.println("不存在");
        } else {
            System.out.println(nArr[nPos]);
        }
    }
}
