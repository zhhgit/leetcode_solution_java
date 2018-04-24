方法一：backTracking,tempList方法超时。

方法二：对于每个数字，通过left，right来夹逼remain
特别要注意造成超时的几个点：
1.选取第一个数字时候，如果有重复要跳过；
2.在每一轮的left,right夹逼remain时候，如果remain小于0，可以直接跳过；
3.lists.contains(addList)判断是否重复，会造成超时；
4.nums[left] + nums[right] == remain找到后，先left++,right--，然后要跳过重复；
5.不等于remain时候，单边的left++或者right--也可以跳过重复（不跳过不会超时）；