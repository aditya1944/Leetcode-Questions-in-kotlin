
fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
    val parentMap = HashMap<Int, Int>();
    for(vertex in 0 until n){
        parentMap[vertex] = vertex;
    }
    for(edge in edges){
        val fromVertex = edge[0];
        val toVertex = edge[1];
        union(fromVertex, toVertex, parentMap);
    }
    return findParent(parentMap,start)==findParent(parentMap,end);
}

fun union(v1: Int, v2: Int, parentMap: HashMap<Int, Int>){
    val v1Parent = findParent(parentMap, v1);
    val v2Parent = findParent(parentMap,v2);
    parentMap[v1Parent] = v2Parent;
}

fun findParent(parentMap: HashMap<Int, Int>, vertex: Int): Int{
    if(parentMap[vertex] == vertex){
        return vertex;
    }
    return findParent(parentMap, parentMap.getValue(vertex));
}


fun main(){
    print(validPath(6, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(3,5), intArrayOf(5,4), intArrayOf(4,3)), 0, 2));
}