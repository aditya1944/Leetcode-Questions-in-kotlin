fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    if(r==mat.size && c == mat[0].size){
        return mat;
    }
    if(r*c > mat.size * mat[0].size || r*c < mat.size* mat[0].size){
        return mat;
    }
    val newMatx = Array<IntArray>(r) { IntArray(c){-1} }

    var newMatxRowIndex = 0;
    var newMatxColIndex = 0;


    for(rowIndex in mat.indices){
        for(colIndex in mat[rowIndex].indices){
            if(newMatxColIndex==c){
                ++newMatxRowIndex;
                newMatxColIndex = 0;
            }
            newMatx[newMatxRowIndex][newMatxColIndex] = mat[rowIndex][colIndex];
            ++newMatxColIndex;
        }
    }

    return newMatx;
}

fun main(){
    val matx = matrixReshape(arrayOf(intArrayOf(1,2), intArrayOf(3,4)),1,4)
    for(rowIndex in matx.indices){
        for(colIndex in matx[rowIndex].indices){
            print(matx[rowIndex][colIndex]);
        }
        println();
    }
}