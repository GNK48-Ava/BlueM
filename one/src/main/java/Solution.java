import Bean.Lost;

import java.util.Calendar;

class Solution {

    /**
     * 失物排序方法
     *
     * @param lostArray 待排序的失物数组
     */
    public void sortLost(Lost[] lostArray) {
        int[] dateArray = getDateArray(lostArray);
        new Util()._qSort(lostArray, dateArray, 0, lostArray.length - 1);

    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     *
     * @param lostArray 失物数组
     * @param keyword   用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost[] selectByKeyword(Lost[] lostArray, String keyword) {
        return null;
    }

    public int[] getDateArray(Lost[] lostArray) {
        int[] dateArray = new int[lostArray.length];
        int year;
        int month;
        int date;
        int i = 0;
        for (Lost lost : lostArray) {
            Calendar _date = lost.getDate();
            year = _date.get(Calendar.YEAR);
            month = _date.get(Calendar.MONTH);
            date = _date.get(Calendar.DATE);
            StringBuffer stringBuffer = new StringBuffer().append(year).append(month).append(date);
            dateArray[i] = Integer.parseInt(stringBuffer.toString());
        }
        return dateArray;
    }


    class Util {
        int getPivot(int[] array, int left, int right) {
            int center = (left + right) / 2;
            if (array[left] > array[center]) {
                int temp = array[left];
                array[left] = array[center];
                array[center] = temp;
            }
            if (array[center] > array[right]) {
                int temp = array[center];
                array[center] = array[right];
                array[right] = temp;
            }
            if (array[left] > array[right]) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            int temp = array[center];
            array[center] = array[right - 1];
            array[right - 1] = temp;


            return array[right - 1];
        }

        void _qSort(Lost[] array, int[] dateArray, int left, int right) {
            int pivot = getPivot(dateArray, left, right);
            int low = left;
            int high = right - 1;
            while (true) {
                while (dateArray[low] < pivot && low < high) {
                    low++;
                }
                while (dateArray[high] > pivot && low < high) {
                    high--;
                }
                if (low < high) {
                    int tempDate = dateArray[low];
                    dateArray[low] = dateArray[high];
                    dateArray[high] = tempDate;
                    Lost tempLost = array[low];
                    array[low] = array[high];
                    array[high] = tempLost;
                } else break;


            }
            for(int i=left;i<=right;i++){
                Calendar date = array[i].getDate();
                System.out.print(date.get(Calendar.YEAR) + " " + date.get(Calendar.MONTH) + "  " + date.get(Calendar.DATE)+" ");
            }
            _qSort(array, dateArray, low + 1, right);
            _qSort(array, dateArray, left, low - 1);
        }

    }


}