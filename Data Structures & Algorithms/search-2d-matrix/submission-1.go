func searchMatrix(matrix [][]int, target int) bool {
    lo := 0
    hi := len(matrix[0]) * len(matrix) - 1
    rowLen := len(matrix[0])

    for lo <= hi {
        mid := (lo + hi) / 2
        val := matrix[mid / rowLen][mid % rowLen]
        if val == target {
            return true
        } else if val < target {
            lo = mid + 1
        } else {
            hi = mid - 1
        }
    }

    return false
}
