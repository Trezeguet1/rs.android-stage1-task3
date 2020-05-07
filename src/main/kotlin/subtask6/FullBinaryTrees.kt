package subtask6
import java.util.*
import kotlin.collections.ArrayList

class FullBinaryTrees {

    // TODO: Complete the following function
    private var map: MutableMap<Int, ArrayList<TreeNode>?> = mutableMapOf()
    private val q = ArrayDeque<TreeNode>()
    fun stringForNodeCount(count: Int): String {
        if (count <= 0 || count % 2 == 0){
            return "[]"
        }
        if (count == 1){
            return "[[0]]"
        }
        val list = arrayListOf<TreeNode>()
        list.add(TreeNode(0))
        map[1] = list

        val combos = allTrees(count)

        val res = mutableListOf<String>()
        if (combos != null) {
            for (tr in combos){
                res.add(format(tr))
            }
        }


        return res.joinToString( ",",  "[",  "]")
    }

    private fun allTrees(n: Int): ArrayList<TreeNode>? {
        if(map.containsKey(n)) return map[n];
        val list = arrayListOf<TreeNode>()
        var i = 1
        for (i in 1 until n step 2){

            val left: ArrayList<TreeNode>? = allTrees(i)
            val right: ArrayList<TreeNode>? = allTrees(n - 1 - i)
            if (left != null && right != null) {
                for (j in left.indices) {
                    for (k in right.indices) {
                        val root = TreeNode(0)
                        root.left = left[j]
                        root.right = right[k]
                        list.add(root)
                    }
                }
            }
        }

        map[n] = list
        return list
    }

    private fun format(node: TreeNode): String{
        val res = mutableListOf<String>()
        if (node == null)
            return ""
        q.clear()
        q.add(node)
        while (!q.isEmpty()) {
            val node = q.remove()

            if (node.value == 1){
                res.add("null")
                continue
            }

            res.add(node.toString())
            if (node.left != null){
                q.add(node.left)} else {
                q.add(TreeNode(1))}
            if (node.right != null) {
                q.add(node.right)
            } else {
                q.add(TreeNode(1))
            }
        }


        while (res.last() == "null") {
            res.removeAt(res.lastIndex)
        }
        return res.joinToString(",",  "[",  "]")
    }



    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {

            return value.toString()
        }
    }
}
