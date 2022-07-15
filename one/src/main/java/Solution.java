import Bean.Lost;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

class Solution {

    /**
     * 失物排序方法
     *
     * @param lostArray 待排序的失物数组
     */
    //接口只有一个参数我也不分升降序了
    //先遍历一遍将时间数据拿出来，作为基准来排序失物数组。
    //但怎么想都觉得这样效率可能更低一点
    public void sortLost(Lost[] lostArray) {
        Integer[] dateArray = _getDateArray(lostArray);
        _qSort(lostArray, dateArray, 0, lostArray.length - 1);
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     *
     * @param lostArray 失物数组
     * @param keyword   用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost[] selectByKeyword(Lost[] lostArray, String keyword) {
        String key = ".*" + keyword.trim() + ".*";
        Lost[] result = new Lost[lostArray.length];//只用数组我实在想不明白如何返回数组大小精确的数组（遍历两次除外）
        int i = 0;
        for (Lost lost : lostArray) {
            String content = lost.getLocation();
            if (Pattern.matches(key, content)) {
                result[i++] = lost;
            }
        }
        return result;
    }

    private Integer[] _getDateArray(Lost[] lostArray) {
        Integer[] dateArray = new Integer[lostArray.length];
        int i = 0;
        for (Lost lost : lostArray) {
            Date _date = lost.getDate().getTime();
            Integer date = Integer.valueOf(String.valueOf(_date.getTime()).substring(0, 9));
            dateArray[i] = date;
            i++;
        }
        return dateArray;
    }

    //将日期排序，也得记得得将原来的失误列表也传进来换一下位置
    //没整swap函数大概是因为java的值传递吧，菜狗不会
    private int getPivot(Lost[] array, Integer[] dateArray, int left, int right) {
        int center = (left + right) / 2;
        if (dateArray[left] > dateArray[center]) {
            int temp = dateArray[left];
            dateArray[left] = dateArray[center];
            dateArray[center] = temp;
            Lost tempLost = array[left];
            array[left] = array[center];
            array[center] = tempLost;
        }
        if (dateArray[left] > dateArray[right]) {
            int temp = dateArray[left];
            dateArray[left] = dateArray[right];
            dateArray[right] = temp;
            Lost tempLost = array[left];
            array[left] = array[right];
            array[right] = tempLost;
        }
        if (dateArray[center] > dateArray[right]) {
            int temp = dateArray[center];
            dateArray[center] = dateArray[right];
            dateArray[right] = temp;
            Lost tempLost = array[center];
            array[center] = array[right];
            array[right] = tempLost;
        }
        int temp = dateArray[center];
        dateArray[center] = dateArray[right - 1];
        dateArray[right - 1] = temp;
        Lost tempLost = array[center];
        array[center] = array[right - 1];
        array[right - 1] = tempLost;

        return dateArray[right - 1];
    }

    //好巧不巧，出任务前一天晚上正好看了个快速排序的视频（BV18U4y1S71Z）。当时我就很感兴趣来着，并表示明天我试一下
    private void _qSort(Lost[] array, Integer[] dateArray, int left, int right) {

        int pivot = getPivot(array, dateArray, left, right);
        int low = left;
        int high = right - 1;
        while (true) {
            while (low < high && dateArray[++low] < pivot) {
            }
            while (low < high && dateArray[--high] > pivot) {
            }
            if (low < high) {
                int tempDate = dateArray[low];
                dateArray[low] = dateArray[high];
                dateArray[high] = tempDate;
                Lost tempLost = array[low];
                array[low] = array[high];
                array[high] = tempLost;
            } else {
                break;
            }
        }
        int tempDate = dateArray[low];
        dateArray[low] = dateArray[right - 1];
        dateArray[right - 1] = tempDate;
        Lost tempLost = array[low];
        array[low] = array[right - 1];
        array[right - 1] = tempLost;
        _qSort(array, dateArray, low + 1, right);
        _qSort(array, dateArray, left, low - 1);

    }


}