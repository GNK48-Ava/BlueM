import Bean.BookLost
import Bean.Lost
import java.util.Calendar
import java.util.Scanner

fun main() {
    //创建一个丢失图书的数组
    val losts = arrayOfNulls<BookLost>(10)
    //手动添加数组元素..由于只验证排序功能和搜索功能就不添加完数据了
    losts.apply {
        for (i in 0..9) {
            set(i, BookLost(Calendar.Builder().build()))
        }
        get(0)!!.date.set(2019, 6, 4)
        get(1)!!.date.set(2021, 5, 6)
        get(2)!!.date.set(2020, 12, 12)
        get(3)!!.date.set(2018, 7, 17)
        get(4)!!.date.set(2022, 7, 12)
        get(5)!!.date.set(2020, 2, 17)
        get(6)!!.date.set(2021, 5, 1)
        get(7)!!.date.set(2021, 3, 8)
        get(8)!!.date.set(2021, 12, 25)
        get(9)!!.date.set(2019, 5, 26)

        get(0)!!.location = "勤工助学中心"
        get(1)!!.location = "千喜鹤食堂"
        get(2)!!.location = "数字图书馆"
        get(3)!!.location = "勤工助学中心"
        get(4)!!.location = "延生食堂"
        get(5)!!.location = "千喜鹤食堂"
        get(6)!!.location = "延生食堂"
        get(7)!!.location = "老图书馆"
        get(8)!!.location = "勤工助学中心"
        get(9)!!.location = "数字图书馆"
    }
    val solution = Solution()
//验证排序
    /*   for (lost in losts) {
        lost!!.date.apply {
            print("${get(Calendar.YEAR)} ${get(Calendar.MONTH)} ${get(Calendar.DATE)} ")
        }

    }
    println()

    solution.sortLost(losts)
    for (lost in losts) {
        lost!!.date.apply {
            print("${get(Calendar.YEAR)} ${get(Calendar.MONTH)} ${get(Calendar.DATE)} ")
        }

    }
*/
//验证搜索
    val scanner = Scanner(System.`in`)
    println("请输入搜索关键字:")
    val key = scanner.next()
    val result = solution.selectByKeyword(losts, key)
    for (lost in result) {
        lost!!.location?.apply {
            println(this)
        }
    }
}


