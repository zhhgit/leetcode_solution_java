二维数组，如果s，p新增的最后一位相等，或者p最后一位为.，则matrix[i + 1][j + 1]与左上角相等。
如果p最后一位为*，如果p中*的前一位与s中当前位相等，或者p中*的前一位为.，则a*或者.*匹配情况有三种：
matrix[i + 1][j + 1]为matrix[i + 1][j]（情况1：对应于一位），
或为matrix[i + 1][j - 1]（情况2：对应于0位）
或为matrix[i][j+1]（情况3：对应于多位）
否则a*匹配0位