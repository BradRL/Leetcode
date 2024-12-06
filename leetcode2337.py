class Solution(object):
    """
    Move pieces to obtain a string
    task desc...
    You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
        The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, 
        and a piece 'R' can move to the right only if there is a blank space directly to its right.
        The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.

    Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.
    """
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


