"""
两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    def twoSum(self, nums:list, target: int) -> list:
        #一次哈希，一次for loop
        # hash_data = dict()
        # for i in range(len(nums)):
        #     index = hash_data.get(target-nums[i], None)
        #     if index != None:
        #        return [index,i]
        #     hash_data[nums[i]] = i

        # return []

        # 二次for loop
        hash_data = dict()

        # 先创立hash表
        for i in range(len(nums)):
            hash_data[nums[i]] = i

        #在hash表中找target和nums[i]的差值索引
        for i in range(len(nums)):
            index = hash_data.get(target-nums[i], None)
            if index != i and index != None:
                return [i, index]
        return []

if __name__ == "__main__":
    solution = Solution()
    print(solution.twoSum([2, 7, 11, 15], 9))