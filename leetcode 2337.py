class Solution(object):
    def canChange(self, start, target):
        """
        :type start: str
        :type target: str
        :rtype: bool
        """
        if start == target:
            return True

        leftCount = 0
        rightCount = 0

        for i in range(len(start)):
            if start[i] == "L":
                leftCount -= 1
            elif start[i] == "R":
                rightCount += 1
                if leftCount > 0:
                    return False

            if target[i] == "L":
                leftCount += 1
                if rightCount > 0:
                    return False
            elif target[i] == "R":
                rightCount -= 1

            if leftCount < 0 or rightCount < 0:
                return False

        if leftCount == 0 and rightCount == 0:
            return True
        else:
            return False


