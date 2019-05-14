import java.io.File
import java.io.BufferedReader

fun main () {
    val bufferedReader: BufferedReader = File("src\\Input").bufferedReader()
    val lineList = mutableListOf<String>()

    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach {
        println(it)
        encodeLine(it.toLowerCase())
        println()}

}

    fun encodeLine(line: String ) {
        var position = 0
        var checklist = arrayListOf<Char>()
        line.forEach {
            position += 1
            if (it !in checklist) {
                checklist.add(it)
                if (chkfirstchar(line,position,it)) { print("(") }
                else { print(")") }
            }
            else { print("(" ) }
        }
    }
     fun chkfirstchar (line: String, pos: Int, chk: Char):Boolean{
         var i = pos
         while(i <= line.length-1){
            if(chk == line[i]){return true}
             i++
         }
         return false
     }